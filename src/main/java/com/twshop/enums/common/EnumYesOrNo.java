package com.twshop.enums.common;

/**
 * @classname: EnumYesOrNo
 * @description: 是否枚举
 * @author java
 *
 */
public enum EnumYesOrNo {

	YES(1, "是"), NO(0, "否");

	private Integer code;

	private String name;

	private EnumYesOrNo(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumYesOrNo getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumYesOrNo ruleEnum : EnumYesOrNo.values()) {
			if (ruleEnum.code.equals(code))
				return ruleEnum;
		}
		return null;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
