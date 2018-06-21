package com.twshop.service.admin;

import java.util.List;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.admin.SysRole;

public interface ISysRoleService extends IEntityService<SysRole> {

	/**
	 * 插入角色及角色下菜单
	 * 
	 * @param entity
	 *            系统角色实体
	 * @param menuIds
	 *            角色的菜单列表
	 * @return
	 * @throws Exception
	 */
	long insert(SysRole entity, List<Long> menuIds) throws Exception;

	/**
	 * 更新角色、角色下的菜单
	 * 
	 * @param entity
	 *            系统角色实体
	 * @param menuIds
	 *            角色的菜单列表
	 * @throws Exception
	 */
	void update(SysRole entity, List<Long> menuIds) throws Exception;

}
