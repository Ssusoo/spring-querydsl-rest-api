package me.ssu.springquerydslrestapi.global.common.code;

import lombok.Getter;

@Getter
public enum JwtPayloadKey {

	MANAGER_SERIAL_NO("managerSerialNo"),
	MEMBER_SERIAL_NO("memberSerialNo"),
	MEMBER_ID("memberId"),
	MEMBER_NAME("memberName");

	private final String key;

	JwtPayloadKey(String key) {
		this.key = key;
	}
}