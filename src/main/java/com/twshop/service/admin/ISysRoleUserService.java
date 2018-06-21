package com.twshop.service.admin;

import java.util.List;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.admin.SysRole;
import com.twshop.entity.admin.SysRoleUser;

public interface ISysRoleUserService extends IEntityService<SysRoleUser> {

	/**
	 * 获取所有角色，设置用户已有角色
	 * 
	 * @param sysUserId
	 * @return
	 * @throws Exception
	 */
	List<SysRole> findListBySysUserId(Long sysUserId) throws Exception;

	/**
	 * 获取用户已具有的所有角色
	 * 
	 * @param sysUserId
	 * @return
	 * @throws Exception
	 */
	List<SysRole> listSysRoleBySysUserId(Long sysUserId) throws Exception;

	/**
	 * 删除用户角色
	 * 
	 * @param sysUserId
	 * @throws Exception
	 */
	void deleteBySysUserId(Long sysUserId) throws Exception;

	/**
	 * 插入用户角色
	 * 
	 * @param sysUserId
	 * @param roleId
	 * @throws Exception
	 */
	void insert(Long sysUserId, Long roleId) throws Exception;

}
