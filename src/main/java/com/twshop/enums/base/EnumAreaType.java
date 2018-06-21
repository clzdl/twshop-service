package com.twshop.enums.base;

/**
 * @classname: EnumAreaType
 * @description: 地区类型
 * @author chengl
 *
 */
public enum EnumAreaType {

	SPEC_PROVINCE(0, "直辖市"), PROVINCE(1, "省份"), CITY(2, "城市"), COUNTY(3, "区县");

	private Integer code;

	private String name;

	private EnumAreaType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumAreaType getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumAreaType ruleEnum : EnumAreaType.values()) {
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
