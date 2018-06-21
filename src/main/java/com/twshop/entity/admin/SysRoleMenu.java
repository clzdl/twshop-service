package com.twshop.entity.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.util.date.DateUtil;

@Table(name = "sys_role_menu")
public class SysRoleMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 角色id
	 */
	@Column(name = "sys_role_id")
	private Long sysRoleId;

	/**
	 * 菜单id
	 */
	@Column(name = "sys_menu_id")
	private Long sysMenuId;

	/**
	 * 创建日期
	 */
	@Column(name = "create_time", updatable = false)
	private Integer createTime;

	@Column(name = "modify_time")
	private Date modifyTime;

	@Transient
	private SysMenu sysMenu;

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
	 * 获取角色id
	 *
	 * @return sys_role_id - 角色id
	 */
	public Long getSysRoleId() {
		return sysRoleId;
	}

	/**
	 * 设置角色id
	 *
	 * @param sysRoleId
	 *            角色id
	 */
	public void setSysRoleId(Long sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	/**
	 * 获取菜单id
	 *
	 * @return sys_menu_id - 菜单id
	 */
	public Long getSysMenuId() {
		return sysMenuId;
	}

	/**
	 * 设置菜单id
	 *
	 * @param sysMenuId
	 *            菜单id
	 */
	public void setSysMenuId(Long sysMenuId) {
		this.sysMenuId = sysMenuId;
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

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
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