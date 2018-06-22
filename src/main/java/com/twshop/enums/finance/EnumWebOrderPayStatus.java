package com.twshop.enums.finance;

/**
 * @classname: EnumWebOrderPayStatus
 * @description: 支付状态
 * 
 * @author chengl
 *
 */
public enum EnumWebOrderPayStatus {

	UNPAY(0, "未支付"), PAYED(1, "已支付"), REFUND(2, "已退款");

	private Integer code;

	private String name;

	private EnumWebOrderPayStatus(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumWebOrderPayStatus getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumWebOrderPayStatus ruleEnum : EnumWebOrderPayStatus.values()) {
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
