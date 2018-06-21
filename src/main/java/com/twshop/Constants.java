package com.twshop;

import com.base.util.conf.PropUtil;

public class Constants {
	/** 登录信息 cookie cache 中的过期时间 */
	public static final Integer CACHE_LOGIN_EXPIRE = 7 * 24 * 60 * 60;
	/// 主域名不能带 "." 前缀，否则cookie写不进去
	public static final String DOMAIN = PropUtil.getInstance().get("domain.main.name");
	public static final String AUTH = PropUtil.getInstance().get("domain.cookie.name");
	/** 图片域名 */
	public static final String SITE_NAME_IMG = PropUtil.getInstance().get("img.site.name");
	/** 手机端 域名 */
	public static final String SITE_NAME_M = PropUtil.getInstance().get("m.site.name");

}