package com.twshop.enums.wechat;

/**
 * @classname: EnumWechatAppType
 * @description:微信程序类型
 * 
 * @author chengl
 *
 */
public enum EnumWechatAppType {

	WXPUBLICSIGN(0, "微信公众号"), WXAPP(1, "小程序");

	private Integer code;

	private String name;

	private EnumWechatAppType(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumWechatAppType getEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (EnumWechatAppType ruleEnum : EnumWechatAppType.values()) {
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
