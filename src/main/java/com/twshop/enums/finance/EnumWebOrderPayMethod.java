package com.twshop.enums.finance;

/**
 * @classname: EnumWebOrderPayMethod
 * @description: 支付方式
 * 
 * @author chengl
 *
 */
public enum EnumWebOrderPayMethod {

	WECHAT(0, "微信"), ALIPAY(1, "支付宝");

	private Integer code;

	private String name;

	private EnumWebOrderPayMethod(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumWebOrderPayMethod getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumWebOrderPayMethod ruleEnum : EnumWebOrderPayMethod.values()) {
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
