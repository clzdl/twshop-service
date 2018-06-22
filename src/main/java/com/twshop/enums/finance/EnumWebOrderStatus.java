package com.twshop.enums.finance;

/**
 * @classname: EnumWebOrderStatus
 * @description: 订单状态
 * 
 * @author chengl
 *
 */
public enum EnumWebOrderStatus {

	UNPAY(0, "待支付"), UNSEND(1, "待发货"), UNRECEIPT(2, "待收货"), RECEIPTD(3, "已签收"), APPLY_REFUND(4, "申请退货"), REFUND(5,
			"已退货"), OVER(9, "订单结束");

	private Integer code;

	private String name;

	private EnumWebOrderStatus(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumWebOrderStatus getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumWebOrderStatus ruleEnum : EnumWebOrderStatus.values()) {
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
