package com.twshop.enums.mall;

/**
 * @classname: EnumMallSkuImgType
 * @description:sku图片类型
 * 
 * @author chengl
 *
 */
public enum EnumMallSkuImgType {

	BANNER(0, "BANNER图"), DETAIL(1, "详情");

	private Integer code;

	private String name;

	private EnumMallSkuImgType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumMallSkuImgType getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumMallSkuImgType ruleEnum : EnumMallSkuImgType.values()) {
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
