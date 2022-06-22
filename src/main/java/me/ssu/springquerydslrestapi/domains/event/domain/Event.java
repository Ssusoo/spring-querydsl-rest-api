package me.ssu.springquerydslrestapi.domains.event.domain;

import lombok.*;
import me.ssu.springquerydslrestapi.base.domain.BaseEntity;
import me.ssu.springquerydslrestapi.domains.account.domain.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Table(name = "evt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = "id")
@Entity
public class Event extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "evt_sel_no")
	private Long eventSerialNo;

	@Column(name = "evt_stat_comm_cd", length = 8, nullable = false)
	private String eventStatusCommonCode;   // 이벤트 상태 공통 코드

	// TODO 단방향 맵핑
	@ManyToOne
//	@JsonSerialize(using = AccountSerializer.class)
	private Account manager;

	@Column(name = "evt_nm", length = 10, nullable = false)
	private String eventName; // 이벤트 이름

	@Column(name = "evt_des_crp", length = 20)
	private String eventDescription; // 이벤트 설명

	private String location; // 이벤트 위치(optional) 이게 없으면 온라인 모임
	private int basePrice; // 기본 금액(optional)
	private int maxPrice; // 최고 금액(optional)
	private int limitOfEnrollment; // 등록 한도


	@Column(name = "offline_yn", nullable = false)
	private String offlineYn; // 온/오프라인

	@Column(name = "free_yn", nullable = false)
	private String freeYn; // 무료/유료

	@Column(name = "")
	private LocalDateTime beginEnrollmentDateTime; // 등록 시작일시
	private LocalDateTime closeEnrollmentDateTime; // 종료일시
	private LocalDateTime beginEventDateTime; // 이벤트 시작일시
	private LocalDateTime endEventDateTime; // 이벤트 종료일시
}
