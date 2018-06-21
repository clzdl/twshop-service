package com.twshop.service.admin;

import java.util.List;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.admin.SysMenu;

public interface ISysMenuSerivce extends IEntityService<SysMenu> {

	/**
	 * 生成修饰后菜单列表
	 * 
	 * @return
	 * @throws Exception
	 */
	List<SysMenu> findDecorateMenus() throws Exception;

	/**
	 * 获取用户的菜单列表
	 * 
	 * @param sysUserId
	 *            系统用户id
	 * @return
	 * @throws Exception
	 */
	List<SysMenu> findLoginUserMenus(Long sysUserId) throws Exception;

	/**
	 * 根据父菜单id，获取孩子菜单列表
	 * 
	 * @param parentId
	 *            父节点菜单的id
	 * @return
	 * @throws Exception
	 */
	List<SysMenu> findMenuByParent(Long parentId) throws Exception;
}
