package me.ssu.springquerydslrestapi.global.common;

import lombok.Getter;

@Getter
public enum CommonCodeMaster {
	df("EV01", "eventStatusCommonCode");


	private final String code;
	private final String codeField;

	CommonCodeMaster(String code, String codeField) {
		this.code = code;
		this.codeField = codeField;
	}
}
