package com.twshop.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;

@Table(name = "sys_org")
public class SysOrg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 名称
	 */
	@Column(name = "org_name")
	private String orgName;

	/**
	 * 父节点id
	 */
	@Column(name = "parent_id")
	private Long parentId;

	/**
	 * 创建日期
	 */
	@Column(name = "create_time", updatable = false)
	private Integer createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	@Transient
	private Integer level;

	@Transient
	private String sdecorate;

	@Transient
	private String createTimeOutput;

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
	 * @return org_name - 名称
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * 设置名称
	 *
	 * @param orgName
	 *            名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * 获取父节点id
	 *
	 * @return parent_id - 父节点id
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置父节点id
	 *
	 * @param parentId
	 *            父节点id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getSdecorate() {
		return sdecorate;
	}

	public void setSdecorate(String sdecorate) {
		this.sdecorate = sdecorate;
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
}