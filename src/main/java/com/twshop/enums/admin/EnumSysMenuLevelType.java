package com.twshop.enums.admin;

/**
 * @classname: EnumSysMenuLevelType
 * @description: 系统菜单层级
 * 
 * @author chengl
 *
 */
public enum EnumSysMenuLevelType {

	FIRST(0, "一级"), SECOND(1, "二级");

	private Integer code;

	private String name;

	private EnumSysMenuLevelType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumSysMenuLevelType getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumSysMenuLevelType ruleEnum : EnumSysMenuLevelType.values()) {
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
