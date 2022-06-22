package me.ssu.springquerydslrestapi.global.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 공통 상수
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonConstant {

//	@NoArgsConstructor(access = AccessLevel.PRIVATE)
//	public static class Jwt {
//		public static final Long TOKEN_EXPIRED_HOURS = 3L; // 인증토큰 유효 시간
//		public static final Long REFRESH_TOKEN_EXTENSION_HOURS = 24L; // refreshToken 연장 기준 시간
//		public static final int REFRESH_TOKEN_EXPIRE_DAYS = 30; // refreshToken 유효 일 수
//	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Fee {
		public static final String Y = "Y";
		public static final String N = "N";
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Offline {
		public static final String Y = "Y";
		public static final String N = "N";
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class ActiveProfile {
		public static final String LOCAL = "local";
		public static final String DEV = "dev";
		public static final String ALPHA = "alpha";
		public static final String PROD = "prod";
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class ErpMemberDivision {
		public static final String MANAGER = "JJI20001"; // 관리자
		public static final String MEMBER = "JJI20002"; // 회원
	}

//	@NoArgsConstructor(access = AccessLevel.PRIVATE)
//	public static class ErpMemberAuth {
//		public static final String SUPER_MANAGER = "JJA10001"; // 슈퍼관리자
//		public static final String MANAGER = "JJA10002"; // 일반관리자
//		public static final String TEACHING_ASSISTANT = "JJA10003"; // 조교
//		public static final String STUDENT = "JJA10004"; // 수강생
//		public static final String TA = "JJA10005"; // TA
//	}
}
