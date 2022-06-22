package me.ssu.springquerydslrestapi.global.common.code;

import lombok.Getter;

@Getter
public enum EventStatusCode {

	DRAFT("", ""),
	PUBLISHED("EV010002", "출판"),
	BEGAN_ENROLLMENT("", "");

	private final String code;
	private final String codeField;

	EventStatusCode(String code, String codeField) {
		this.code = code;
		this.codeField = codeField;
	}
}
