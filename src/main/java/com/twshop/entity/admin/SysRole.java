package com.twshop.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;

@Table(name = "sys_role")
public class SysRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 名称
	 */
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 说明
	 */
	private String description;

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
	private boolean checked;

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
	 * 获取名称
	 *
	 * @return role_name - 名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置名称
	 *
	 * @param roleName
	 *            名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取说明
	 *
	 * @return description - 说明
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置说明
	 *
	 * @param description
	 *            说明
	 */
	public void setDescription(String description) {
		this.description = description;
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}