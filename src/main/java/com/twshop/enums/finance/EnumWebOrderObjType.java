package com.twshop.enums.finance;

/**
 * @classname: EnumWebOrderPayMethod
 * @description: 支付方式
 * 
 * @author chengl
 *
 */
public enum EnumWebOrderObjType {

	SINGLE(0, "单品购买"), CART(1, "购物车购买");

	private Integer code;

	private String name;

	private EnumWebOrderObjType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumWebOrderObjType getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumWebOrderObjType ruleEnum : EnumWebOrderObjType.values()) {
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
