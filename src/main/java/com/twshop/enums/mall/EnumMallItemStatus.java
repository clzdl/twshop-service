package com.twshop.enums.mall;

/**
 * @classname: EnumMallItemStatus
 * @description: 产品状态
 * 
 * @author chengl
 *
 */
public enum EnumMallItemStatus {

	TOBESHELF(0, "待上架"), SHELVED(1, "已上架"), OUTSHELF(2, "已下架");

	private Integer code;

	private String name;

	private EnumMallItemStatus(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumMallItemStatus getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumMallItemStatus ruleEnum : EnumMallItemStatus.values()) {
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
