package me.ssu.springquerydslrestapi.domains.account.domain;


import lombok.*;
import me.ssu.springquerydslrestapi.base.domain.BaseEntity;
import me.ssu.springquerydslrestapi.global.common.code.JwtPayloadKey;

import javax.persistence.*;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@Entity
public class Account extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "mem_serl_no", nullable = false, updatable = false)
	private Long memberSerialNo; // 회원 인증 이력 일련번호

	// TODO 계속해서 저장이 안 되도록
	@Column(unique = true)
	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<JwtPayloadKey> keys;
}
