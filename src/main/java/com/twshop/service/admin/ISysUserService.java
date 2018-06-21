package com.twshop.service.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.auth.usercontext.SysCurrentUserContext;
import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.admin.SysMenu;
import com.twshop.entity.admin.SysRole;
import com.twshop.entity.admin.SysUser;

public interface ISysUserService extends IEntityService<SysUser> {

	/**
	 * 后台用户登录
	 * 
	 * @param userLogin
	 *            用户名称
	 * @param userPwdMd5
	 *            md5加密的用户密码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	void login(String userLogin, String userPwdMd5, Boolean rememberMe, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	void loginOut(Long sysUserId, HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * 修改用户密码
	 * 
	 * @param sysUserId
	 *            用户id
	 * @param oldPwd
	 *            用户旧密码
	 * @param newPwd
	 *            用户新密码
	 * @throws Exception
	 */
	void updateUserPwd(Long sysUserId, String oldPwd, String newPwd) throws Exception;

	/**
	 * 根据机构id获取用户列表
	 * 
	 * @param orgId
	 *            机构id
	 * @return
	 * @throws Exception
	 */
	List<SysUser> findListByOrgId(Long orgId) throws Exception;

	/**
	 * 从缓存中获取登录用户信息
	 * 
	 * @param sysUserId
	 * @return
	 * @throws Exception
	 */
	SysCurrentUserContext findSysCurrentUserFromCache(Long sysUserId) throws Exception;

	/**
	 * 把登录用户放入缓存中
	 * 
	 * @param userContext
	 * @throws Exception
	 */
	void setSysCurrentUser2Cache(SysCurrentUserContext userContext) throws Exception;

	/**
	 * 根据登录名成获取用户
	 * 
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	SysUser findSysUserByLoginName(String loginName) throws Exception;

	/**
	 * 根据userId查找用户角色
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<SysRole> listSysRoleByUserId(Long userId) throws Exception;

	/**
	 * 根据userId获取用户权限
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<SysMenu> listSysMenuByUserId(Long userId) throws Exception;
}
