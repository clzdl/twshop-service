package com.twshop.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.mvc.enums.EnumUserSex;
import com.base.util.date.DateUtil;

@Table(name = "sys_user")
public class SysUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 姓名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 手机
	 */
	@Column(name = "user_tel")
	private String userTel;

	/**
	 * 邮箱
	 */
	@Column(name = "user_email")
	private String userEmail;

	/**
	 * 性别，1男 0女
	 */
	@Column(name = "user_sex")
	private String userSex;

	/**
	 * 登陆名
	 */
	@Column(name = "user_login")
	private String userLogin;

	/**
	 * 密码
	 */
	@Column(name = "user_pwd")
	private String userPwd;

	/**
	 * 用户类型;0-系统，1-商户
	 */
	@Column(name = "user_type")
	private Byte userType;

	/**
	 * 所属机构id
	 */
	@Column(name = "org_id")
	private Long orgId;

	/**
	 * 创建日期
	 */
	@Column(name = "create_time", updatable = false)
	private Integer createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	@Transient
	private String createTimeOutput;

	@Transient
	private SysOrg sysOrg;

	@Transient
	private String userSexName;

	@Transient
	private String roleIds;// 保存用户的角色字符串 用“，”隔开

	@Column(name = "merchant_id")
	private Long merchantId;

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取姓名
	 *
	 * @return user_name - 姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置姓名
	 *
	 * @param userName
	 *            姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取手机
	 *
	 * @return user_tel - 手机
	 */
	public String getUserTel() {
		return userTel;
	}

	/**
	 * 设置手机
	 *
	 * @param userTel
	 *            手机
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	/**
	 * 获取邮箱
	 *
	 * @return user_email - 邮箱
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * 设置邮箱
	 *
	 * @param userEmail
	 *            邮箱
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 获取性别，1男 0女
	 *
	 * @return user_sex - 性别，1男 0女
	 */
	public String getUserSex() {
		return userSex;
	}

	/**
	 * 设置性别，1男 0女
	 *
	 * @param userSex
	 *            性别，1男 0女
	 */
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	/**
	 * 获取登陆名
	 *
	 * @return user_login - 登陆名
	 */
	public String getUserLogin() {
		return userLogin;
	}

	/**
	 * 设置登陆名
	 *
	 * @param userLogin
	 *            登陆名
	 */
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	/**
	 * 获取密码
	 *
	 * @return user_pwd - 密码
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * 设置密码
	 *
	 * @param userPwd
	 *            密码
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * 获取用户类型;0-系统，1-商户
	 *
	 * @return user_type - 用户类型;0-系统，1-商户
	 */
	public Byte getUserType() {
		return userType;
	}

	/**
	 * 设置用户类型;0-系统，1-商户
	 *
	 * @param userType
	 *            用户类型;0-系统，1-商户
	 */
	public void setUserType(Byte userType) {
		this.userType = userType;
	}

	/**
	 * 获取所属机构id
	 *
	 * @return org_id - 所属机构id
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * 设置所属机构id
	 *
	 * @param orgId
	 *            所属机构id
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	/**
	 * 获取创建日期
	 *
	 * @return create_time - 创建日期
	 */
	public Integer getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建日期
	 *
	 * @param createTime
	 *            创建日期
	 */
	public void setCreateTime(Integer createTime) {
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
			return DateUtil.formatDateFromSecs("yyyy-MM-dd HH:mm", Long.valueOf(createTime.intValue()));
		}
		return "";
	}

	public void setCreateTimeOutput(String createTimeOutput) {
		this.createTimeOutput = createTimeOutput;
	}

	public SysOrg getSysOrg() {
		return sysOrg;
	}

	public void setSysOrg(SysOrg sysOrg) {
		this.sysOrg = sysOrg;
	}

	public String getUserSexName() {
		EnumUserSex enumSex = EnumUserSex.getEnum(Integer.valueOf(userSex));
		if (enumSex != null) {
			return enumSex.getName();
		}
		return "";
	}

	public void setUserSexName(String userSexName) {
		this.userSexName = userSexName;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

}