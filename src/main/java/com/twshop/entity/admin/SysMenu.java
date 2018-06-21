package com.twshop.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;
import com.twshop.enums.admin.EnumSysMenuLevelType;

@Table(name = "sys_menu")
public class SysMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 菜单名称
	 */
	private String name;

	/**
	 * 菜单链接地址
	 */
	private String href;

	/**
	 * 父节点id
	 */
	@Column(name = "parent_id")
	private Integer parentId;

	/**
	 * 菜单icon
	 */
	private String icon;

	/**
	 * 排序号
	 */
	@Column(name = "sort_no")
	private Integer sortNo;

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
	private String levelOutput;

	@Transient
	private String sdecorate;

	@Transient
	protected String createTimeOutput;

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
	 * 获取菜单名称
	 *
	 * @return name - 菜单名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置菜单名称
	 *
	 * @param name
	 *            菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取菜单链接地址
	 *
	 * @return href - 菜单链接地址
	 */
	public String getHref() {
		return href;
	}

	/**
	 * 设置菜单链接地址
	 *
	 * @param href
	 *            菜单链接地址
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * 获取父节点id
	 *
	 * @return parent_id - 父节点id
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 设置父节点id
	 *
	 * @param parentId
	 *            父节点id
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取菜单icon
	 *
	 * @return icon - 菜单icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置菜单icon
	 *
	 * @param icon
	 *            菜单icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 获取排序号
	 *
	 * @return sort_no - 排序号
	 */
	public Integer getSortNo() {
		return sortNo;
	}

	/**
	 * 设置排序号
	 *
	 * @param sortNo
	 *            排序号
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
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

	public String getLevelOutput() {
		return EnumSysMenuLevelType.getEnum(level).getName();
	}

	public void setLevelOutput(String levelOutput) {
		this.levelOutput = levelOutput;
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