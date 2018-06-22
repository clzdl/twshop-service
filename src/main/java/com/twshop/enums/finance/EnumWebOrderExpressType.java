package com.twshop.enums.finance;

/**
 * @classname: EnumWebOrderExpressType
 * @description: 快递公司类型
 * 
 * @author chengl
 *
 */
public enum EnumWebOrderExpressType {

	SF(0, "顺丰快递"), YT(1, "圆通快递"), YZ(2, "邮政");

	private Integer code;

	private String name;

	private EnumWebOrderExpressType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumWebOrderExpressType getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumWebOrderExpressType ruleEnum : EnumWebOrderExpressType.values()) {
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
