package com.twshop.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;

@Table(name = "sys_operation_log")
public class SysOperationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 用户id
	 */
	@Column(name = "sys_user_id")
	private Long sysUserId;

	/**
	 * 日志
	 */
	private String contents;

	/**
	 * 创建日期
	 */
	@Column(name = "create_time", updatable = false)
	private Integer createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

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
	 * 获取用户id
	 *
	 * @return sys_user_id - 用户id
	 */
	public Long getSysUserId() {
		return sysUserId;
	}

	/**
	 * 设置用户id
	 *
	 * @param sysUserId
	 *            用户id
	 */
	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	/**
	 * 获取日志
	 *
	 * @return contents - 日志
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * 设置日志
	 *
	 * @param contents
	 *            日志
	 */
	public void setContents(String contents) {
		this.contents = contents;
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
}