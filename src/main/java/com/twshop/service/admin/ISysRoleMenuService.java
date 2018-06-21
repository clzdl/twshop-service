package com.twshop.service.admin;

import java.util.List;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.admin.SysRoleMenu;

public interface ISysRoleMenuService extends IEntityService<SysRoleMenu> {

	/**
	 * 插入权限菜单
	 * 
	 * @param sysRoleId
	 * @param sysMenuId
	 * @return
	 * @throws Exception
	 */
	Long insert(Long sysRoleId, Long sysMenuId) throws Exception;

	/**
	 * 删除指定角色菜单
	 * 
	 * @param sysRoleId
	 * @throws Exception
	 */
	void deleteBySysRoleId(Long sysRoleId) throws Exception;

	/**
	 * 获取角色下的菜单
	 * 
	 * @param sysRoleId
	 * @return
	 * @throws Exception
	 */
	List<SysRoleMenu> findSysRoleMenusBySysRoleId(Long sysRoleId) throws Exception;
}
