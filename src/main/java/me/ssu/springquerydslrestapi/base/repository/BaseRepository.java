package me.ssu.springquerydslrestapi.base.repository;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import me.ssu.springquerydslrestapi.global.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.data.util.ProxyUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
public abstract class BaseRepository<E, ID> {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private JPAQueryFactory query;
//	@Autowired private AuthenticateAdapter authenticateAdapter;
	private JpaEntityInformation<E, ID> entityInformation;

//	protected JwtAuthToken.TokenPayload getTokenPayload() {
//		return authenticateAdapter.getTokenPayload();
//	}

	protected <DTO> JPAQuery<DTO> select(Expression<DTO> expressions) {
		return query.select(expressions);
	}

	protected <DTO> JPAQuery<DTO> select(Class<DTO> clazz, Expression<?>... expressions) {
		return query.select(Projections.constructor(clazz, expressions));
	}

	protected JPAUpdateClause update(EntityPath<E> path) {
		return query.update(path);
	}

	protected JPAQuery<Integer> selectOne() {
		return query.selectOne();
	}

	protected JPAQuery<E> selectFrom(EntityPath<E> from) {
		return query.selectFrom(from);
	}

	protected <C extends Expression<?>> JPAQuery<String> selectGroupConcat(C column) {
		return select(Expressions.stringTemplate("group_concat({0})", column));
	}

	@Transactional
	public E save(E entity) {
		if (isNewEntity(entity)) {
			em.persist(entity);
			return entity;
		}

		return em.merge(entity);
	}

	@Transactional
	public List<E> saveAll(Iterable<E> entities) {

		Assert.notNull(entities, "Entities must not be null!");

		List<E> result = new ArrayList<E>();

		for (E entity : entities) {
			result.add(save(entity));
		}

		return result;
	}

	@Transactional
	public E saveAndFlush(E entity) {

		E result = save(entity);
		flush();

		return result;
	}

	@Transactional
	public List<E> saveAllAndFlush(Iterable<E> entities) {

		List<E> result = saveAll(entities);
		flush();

		return result;
	}

	@Transactional
	public void flush() {
		em.flush();
	}


	@Transactional
	@SuppressWarnings("unchecked")
	public void delete(E entity) {
		JpaEntityInformation<E, ID> entityInformation = this.getJpaEntityInformation(entity.getClass());
		if (isNewEntity(entity)) {
			return;
		}

		E existing = (E) em.find(ProxyUtils.getUserClass(entity), entityInformation.getId(entity));
		if (existing == null) {
			return;
		}

		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@SuppressWarnings("unchecked")
	private JpaEntityInformation<E, ID> getJpaEntityInformation(Class<?> clazz) {
		if (this.entityInformation == null) {
			this.entityInformation =
					(JpaEntityInformation<E, ID>) JpaEntityInformationSupport.getEntityInformation(clazz, em);
		}

		return this.entityInformation;
	}

	private Boolean isNewEntity(E entity) {
		return this.getJpaEntityInformation(entity.getClass()).isNew(entity);
	}

	protected <DTO> Pagination<DTO> applyPagination(JPAQuery<DTO> contentQuery, JPAQuery<?> countQuery, Pageable pageable) {
		return new Pagination<>(PageableExecutionUtils.getPage(contentQuery.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch(), pageable, countQuery::fetchCount));
	}
}