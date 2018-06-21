package com.twshop.entity.wechat;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;
import com.twshop.enums.wechat.EnumWechatAppType;

@Table(name = "wechat_account")
public class WechatAccount {
	/**
	 * 微信公众号配置
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 商户ID
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 类型
	 */
	@Column(name = "app_type")
	private Integer appType;

	@Transient
	private String appTypeOutput;

	/**
	 * 微信公众号
	 */
	@Column(name = "app_id")
	private String appId;

	/**
	 * APP名称
	 */
	@Column(name = "app_name")
	private String appName;

	/**
	 * 微信app秘钥
	 */
	@Column(name = "app_secret")
	private String appSecret;

	/**
	 * 微信商户支付号
	 */
	@Column(name = "merchant_pay_no")
	private String merchantPayNo;

	/**
	 * 微信商户支付key
	 */
	@Column(name = "merchant_pay_key")
	private String merchantPayKey;

	/**
	 * 回调地址
	 */
	@Column(name = "notify_url")
	private String notifyUrl;

	/**
	 * 微信接入token
	 */
	private String token;

	/**
	 * 微信基本token
	 */
	@Column(name = "access_token")
	private String accessToken;

	/**
	 * 微信基本token过期时间
	 */
	@Column(name = "expires_in")
	private String expiresIn;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	@Transient
	private String createTimeOutput;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取微信公众号配置
	 *
	 * @return id - 微信公众号配置
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置微信公众号配置
	 *
	 * @param id
	 *            微信公众号配置
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取商户ID
	 *
	 * @return merchant_id - 商户ID
	 */
	public Long getMerchantId() {
		return merchantId;
	}

	/**
	 * 设置商户ID
	 *
	 * @param merchantId
	 *            商户ID
	 */
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * 获取微信公众号
	 *
	 * @return app_id - 微信公众号
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 设置微信公众号
	 *
	 * @param appId
	 *            微信公众号
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 获取APP名称
	 *
	 * @return app_name - APP名称
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * 设置APP名称
	 *
	 * @param appName
	 *            APP名称
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * 获取微信app秘钥
	 *
	 * @return app_secret - 微信app秘钥
	 */
	public String getAppSecret() {
		return appSecret;
	}

	/**
	 * 设置微信app秘钥
	 *
	 * @param appSecret
	 *            微信app秘钥
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	/**
	 * 获取微信商户支付号
	 *
	 * @return merchant_pay_no - 微信商户支付号
	 */
	public String getMerchantPayNo() {
		return merchantPayNo;
	}

	/**
	 * 设置微信商户支付号
	 *
	 * @param merchantPayNo
	 *            微信商户支付号
	 */
	public void setMerchantPayNo(String merchantPayNo) {
		this.merchantPayNo = merchantPayNo;
	}

	/**
	 * 获取微信商户支付key
	 *
	 * @return merchant_pay_key - 微信商户支付key
	 */
	public String getMerchantPayKey() {
		return merchantPayKey;
	}

	/**
	 * 设置微信商户支付key
	 *
	 * @param merchantPayKey
	 *            微信商户支付key
	 */
	public void setMerchantPayKey(String merchantPayKey) {
		this.merchantPayKey = merchantPayKey;
	}

	/**
	 * 获取回调地址
	 *
	 * @return notify_url - 回调地址
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}

	/**
	 * 设置回调地址
	 *
	 * @param notifyUrl
	 *            回调地址
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	/**
	 * 获取微信接入token
	 *
	 * @return token - 微信接入token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 设置微信接入token
	 *
	 * @param token
	 *            微信接入token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 获取微信基本token
	 *
	 * @return access_token - 微信基本token
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * 设置微信基本token
	 *
	 * @param accessToken
	 *            微信基本token
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 获取微信基本token过期时间
	 *
	 * @return expires_in - 微信基本token过期时间
	 */
	public String getExpiresIn() {
		return expiresIn;
	}

	/**
	 * 设置微信基本token过期时间
	 *
	 * @param expiresIn
	 *            微信基本token过期时间
	 */
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return modify_time
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateTimeOutput() {
		if (createTime != null) {
			return DateUtil.formatDate(DateUtil._DATE_TIME_FORMAT1, createTime);
		}
		return "";
	}

	public void setCreateTimeOutput(String createTimeOutput) {
		this.createTimeOutput = createTimeOutput;
	}

	public Integer getAppType() {
		return appType;
	}

	public void setAppType(Integer appType) {
		this.appType = appType;
	}

	public String getAppTypeOutput() {
		EnumWechatAppType enumType = EnumWechatAppType.getEnum(appType);
		if (null != enumType) {
			return enumType.getName();
		}
		return "";
	}

	public void setAppTypeOutput(String appTypeOutput) {
		this.appTypeOutput = appTypeOutput;
	}

}