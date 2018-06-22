package com.twshop.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;
import com.base.util.string.StringUtil;
import com.twshop.Constants;

@Table(name = "base_merchant")
public class BaseMerchant {
	/**
	 * 商户信息
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 商户名
	 */
	private String name;

	/**
	 * logo存放路径
	 */
	@Column(name = "logo_url")
	private String logoUrl;

	@Transient
	private String logoUrlOutput;

	/**
	 * 联系人
	 */
	@Column(name = "contact_man")
	private String contactMan;

	/**
	 * 联系电话
	 */
	@Column(name = "contact_phone")
	private String contactPhone;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 地市代码
	 */
	@Column(name = "city_code")
	private String cityCode;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 经度
	 */
	private String longitude;

	/**
	 * 纬度
	 */
	private String latitude;

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
	 * 获取商户信息
	 *
	 * @return id - 商户信息
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置商户信息
	 *
	 * @param id
	 *            商户信息
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取商户名
	 *
	 * @return name - 商户名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置商户名
	 *
	 * @param name
	 *            商户名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取logo存放路径
	 *
	 * @return logo_url - logo存放路径
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * 设置logo存放路径
	 *
	 * @param logoUrl
	 *            logo存放路径
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	/**
	 * 获取联系人
	 *
	 * @return contact_man - 联系人
	 */
	public String getContactMan() {
		return contactMan;
	}

	/**
	 * 设置联系人
	 *
	 * @param contactMan
	 *            联系人
	 */
	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}

	/**
	 * 获取联系电话
	 *
	 * @return contact_phone - 联系电话
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * 设置联系电话
	 *
	 * @param contactPhone
	 *            联系电话
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * 获取描述
	 *
	 * @return description - 描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置描述
	 *
	 * @param description
	 *            描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取地市代码
	 *
	 * @return city_code - 地市代码
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * 设置地市代码
	 *
	 * @param cityCode
	 *            地市代码
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * 获取地址
	 *
	 * @return address - 地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置地址
	 *
	 * @param address
	 *            地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取经度
	 *
	 * @return longitude - 经度
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * 设置经度
	 *
	 * @param longitude
	 *            经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * 获取纬度
	 *
	 * @return latitude - 纬度
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * 设置纬度
	 *
	 * @param latitude
	 *            纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	public String getLogoUrlOutput() {
		if (StringUtil.isNotBlank(logoUrl)) {
			return Constants.SITE_NAME_IMG + logoUrl;
		}
		return "";
	}

	public void setLogoUrlOutput(String logoUrlOutput) {
		this.logoUrlOutput = logoUrlOutput;
	}

}