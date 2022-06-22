package me.ssu.springquerydslrestapi.global.common.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApiResponseCode {

	OK(200, "R20000", "정상"),

	BAD_REQUEST(400, "R40000", "비정상적인 요청입니다."),
	INVALID_INPUT_VALUE(400, "R40001", "유효하지 않은 값입니다."),
	INVALID_TYPE_VALUE(400, "R40002", "유효하지 않은 값입니다."),
	BODY_READ_FAILED(400, "R40003", "BODY JSON parse error"),
	BIZ_DEFAULT_ERROR(400, "R40010", "처리할 수 없는 요청입니다."),
	DUPLICATION_ENTITY_DATA(400, "R40020", "데이터가 중복되어 저장할 수 없습니다."),
	REMOVED_ENTITY_DATA(400, "R40030", "데이터가 삭제된 상태여서 처리할 수 없습니다."),
	NOT_USABLE_ENTITY_DATA(400, "R40040", "데이터가 사용할 수 없는 상태입니다."),

	UNAUTHORIZED(401, "R40100", "인증이 필요한 API 입니다."),
	EXPIRED_TOKEN(401, "R40101", "만료된 토큰입니다."),
	EXPIRED_OR_INVALID_TOKEN(401, "R40102", "만료되었거나 유효하지 않은 토큰입니다."),
	INVALID_TOKEN(401, "R40103", "토큰이 유효하지 않거나, 검증에 실패했습니다."),
	USER_PASSWORD_NOT_MATCH(401, "R40104", "아이디 혹은 비밀번호가 잘못되었습니다."),
	TOKEN_GENERATION_FAILED(401, "R40105", "토큰을 생성할 수 없습니다."),
	LOGIN_FAILED(401, "R40106", "로그인이 실패했습니다."),
	LOGIN_FAILED_NOT_FOUND_OR_NOT_MATCHED_PWD(401, "R40107", "아이디/비밀번호를 확인해 주세요."),


	NOT_FOUND(404, "R40400", "존재하지 않거나 비활성화된 API 입니다."),
	DATA_NOT_FOUND(404, "R40402", "데이터가 존재하지 않습니다."),

	INTERNAL_SERVER_ERROR(500, "R50000", "처리 중 오류가 발생했습니다."),
	EXTERNAL_API_UNAVAILABLE(503, "R50301", "서버가 요청을 처리할 준비가 되지 않았습니다.");

	private final int status;
	private final String code;
	private final String message;

	ApiResponseCode(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}