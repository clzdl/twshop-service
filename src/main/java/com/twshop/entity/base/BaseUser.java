package com.twshop.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;
import com.twshop.enums.common.EnumYesOrNo;

@Table(name = "base_user")
public class BaseUser {
	/**
	 * 微信用户信息
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * wechat_account表的id
	 */
	@Column(name = "wechat_account_id")
	private Long wechatAccountId;

	/**
	 * 微信openid
	 */
	@Column(name = "open_id")
	private String openId;

	/**
	 * 昵称
	 */
	@Column(name = "nick_name")
	private String nickName;

	/**
	 * 昵称
	 */
	@Column(name = "merchant_id")
	private Long merchantId;

	/**
	 * 国家(从微信获取)
	 */
	private String country;

	/**
	 * 省份(从微信获取)
	 */
	private String province;

	/**
	 * 城市(从微信获取)
	 */
	private String city;

	/**
	 * 微信unionid
	 */
	@Column(name = "unionId")
	private String unionid;

	/**
	 * 微信头像
	 */
	private String avator;

	/**
	 * 是否具有分销权限;0-否，1-是
	 */
	@Column(name = "grant_distribute_tag")
	private Byte grantDistributeTag;

	@Transient
	private String grantDistributeTagOutput;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", updatable = false)
	private Date createTime;

	@Transient
	private String createTimeOutput;

	@Column(name = "modify_time")
	private Date modifyTime;

	/**
	 * 获取微信用户信息
	 *
	 * @return id - 微信用户信息
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置微信用户信息
	 *
	 * @param id
	 *            微信用户信息
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取wechat_account表的id
	 *
	 * @return wechat_account_id - wechat_account表的id
	 */
	public Long getWechatAccountId() {
		return wechatAccountId;
	}

	/**
	 * 设置wechat_account表的id
	 *
	 * @param wechatAccountId
	 *            wechat_account表的id
	 */
	public void setWechatAccountId(Long wechatAccountId) {
		this.wechatAccountId = wechatAccountId;
	}

	/**
	 * 获取微信openid
	 *
	 * @return open_id - 微信openid
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * 设置微信openid
	 *
	 * @param openId
	 *            微信openid
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * 获取昵称
	 *
	 * @return nick_name - 昵称
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 设置昵称
	 *
	 * @param nickName
	 *            昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取国家(从微信获取)
	 *
	 * @return country - 国家(从微信获取)
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置国家(从微信获取)
	 *
	 * @param country
	 *            国家(从微信获取)
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 获取省份(从微信获取)
	 *
	 * @return province - 省份(从微信获取)
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置省份(从微信获取)
	 *
	 * @param province
	 *            省份(从微信获取)
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 获取城市(从微信获取)
	 *
	 * @return city - 城市(从微信获取)
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置城市(从微信获取)
	 *
	 * @param city
	 *            城市(从微信获取)
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取微信unionid
	 *
	 * @return unionId - 微信unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * 设置微信unionid
	 *
	 * @param unionid
	 *            微信unionid
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * 获取微信头像
	 *
	 * @return avator - 微信头像
	 */
	public String getAvator() {
		return avator;
	}

	/**
	 * 设置微信头像
	 *
	 * @param avator
	 *            微信头像
	 */
	public void setAvator(String avator) {
		this.avator = avator;
	}

	/**
	 * 获取是否具有分销权限;0-否，1-是
	 *
	 * @return grant_distribute_tag - 是否具有分销权限;0-否，1-是
	 */
	public Byte getGrantDistributeTag() {
		return grantDistributeTag;
	}

	/**
	 * 设置是否具有分销权限;0-否，1-是
	 *
	 * @param grantDistributeTag
	 *            是否具有分销权限;0-否，1-是
	 */
	public void setGrantDistributeTag(Byte grantDistributeTag) {
		this.grantDistributeTag = grantDistributeTag;
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

	public String getGrantDistributeTagOutput() {
		EnumYesOrNo enumYes = EnumYesOrNo.getEnum(grantDistributeTag.intValue());
		if (null != enumYes) {
			return enumYes.getName();
		}
		return "";
	}

	public void setGrantDistributeTagOutput(String grantDistributeTagOutput) {
		this.grantDistributeTagOutput = grantDistributeTagOutput;
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

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

}