package com.twshop.enums.admin;

/**
 * @classname: EnumSysUserType
 * @description: 系统用户类型
 * @author chengl
 *
 */
public enum EnumSysUserType {

	PLAT(0, "平台系统用户"), MER(1, "商家系统用户");

	private Integer code;

	private String name;

	private EnumSysUserType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumSysUserType getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumSysUserType ruleEnum : EnumSysUserType.values()) {
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
