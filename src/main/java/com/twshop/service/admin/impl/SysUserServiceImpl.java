package com.twshop.service.admin.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.auth.shiro.ShiroKit;
import com.base.auth.usercontext.SysCurrentUserContext;
import com.base.exception.BizException;
import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.operationlog.LogManager;
import com.base.operationlog.LogTaskFactory;
import com.base.util.cipher.MD5Util;
import com.base.util.date.DateUtil;
import com.base.util.string.StringUtil;
import com.twshop.ExceptionMessage;
import com.twshop.entity.admin.SysMenu;
import com.twshop.entity.admin.SysRole;
import com.twshop.entity.admin.SysUser;
import com.twshop.service.admin.ISysMenuSerivce;
import com.twshop.service.admin.ISysOrgService;
import com.twshop.service.admin.ISysRoleUserService;
import com.twshop.service.admin.ISysUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

@Service("sysUserServiceImpl")
public class SysUserServiceImpl extends AbastractEntityService<SysUser> implements ISysUserService {
	private static String DEFAULT_PWD = "123456";
	@Resource
	private ISysOrgService sysOrgService;
	@Resource
	private ISysRoleUserService sysRoleUserService;
	@Resource
	private ISysMenuSerivce sysMenuService;

	protected SysUserServiceImpl() {
		super(SysUser.class);
	}

	@Override
	public PageModel<SysUser> listPageModel(SysUser entity, Integer pageNo, Integer pageSize) throws Exception {

		Builder builder = Example.builder(SysUser.class);
		if (entity.getOrgId() != null) {
			builder.andWhere(Sqls.custom().andEqualTo("orgId", entity.getOrgId()));
		}
		builder.orderByDesc("id");
		PageModel<SysUser> pm = super.listPageModelByExample(builder.build(), pageNo, pageSize);
		for (SysUser sysUser : pm.getList()) {
			sysUser.setSysOrg(sysOrgService.getById((long) sysUser.getOrgId().intValue()));
		}

		return pm;
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(SysUser entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void login(String userLogin, String userPwdMd5, Boolean rememberMe, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			Subject currentUser = ShiroKit.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(userLogin, userPwdMd5);
			if (null != rememberMe && rememberMe) {
				token.setRememberMe(true);
			}
			currentUser.login(token);
			LogManager.me().executeLog(LogTaskFactory.bussinessLog("用户登录成功", null, null));
		} catch (IncorrectCredentialsException e) {
			ShiroKit.getSubject().logout();
			throw new BizException(ExceptionMessage.USER_LOGIN_ERROR);
		}
	}

	@Override
	public void loginOut(Long sysUserId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ShiroKit.getSubject().logout();
	}

	@Override
	public void updateUserPwd(Long sysUserId, String oldPwd, String newPwd) throws Exception {
		SysUser entity = super.getById(sysUserId);
		if (!entity.getUserPwd().equals(oldPwd)) {
			throw new BizException(ExceptionMessage.USER_OLD_PWD_ERROR);
		}
		entity.setUserPwd(newPwd);
		super.update(entity);
	}

	@Transactional(readOnly = true)
	@Override
	public SysUser findSysUserByLoginName(String loginName) throws Exception {
		List<SysUser> listSysUser = getMapper().selectByExample(
				Example.builder(SysUser.class).where(Sqls.custom().andEqualTo("userLogin", loginName)).build());

		if (CollectionUtils.isEmpty(listSysUser)) {
			throw new BizException(ExceptionMessage.USER_LOGIN_ERROR);
		}

		return listSysUser.get(0);
	}

	@Override
	public List<SysUser> findListByOrgId(Long orgId) throws Exception {
		return super.listAllByExample(
				Example.builder(SysUser.class).where(Sqls.custom().andEqualTo("orgId", orgId)).build());
	}

	@Override
	public void save(SysUser entity) throws Exception {
		if (entity.getId() == null) {
			entity.setCreateTime(DateUtil.getCurrentTimeStamp());
			entity.setUserPwd(MD5Util.MD5Encode(DEFAULT_PWD));
			Long userId = insert(entity);
			insertSysRoleUser(userId, entity.getRoleIds());
		} else {
			update(entity);
		}
	}

	@Override
	public void update(SysUser entity) throws Exception {
		super.update(entity);
		sysRoleUserService.deleteBySysUserId(entity.getId().longValue());
		insertSysRoleUser(entity.getId().longValue(), entity.getRoleIds());
	}

	@Override
	public SysCurrentUserContext findSysCurrentUserFromCache(Long sysUserId) throws Exception {
		// try {
		// return redisCacheClient != null
		// ? (SysCurrentUserContext) redisCacheClient.get(Constants.CACHE_LOGIN_SYS_USER
		// + sysUserId)
		// : null;
		// } catch (Exception e) {
		// DebugLogger.getInstance().info(e.getMessage());
		// }
		return null;
	}

	@Override
	public void setSysCurrentUser2Cache(SysCurrentUserContext userContext) throws Exception {
		// try {
		// if (redisCacheClient != null) {
		// redisCacheClient.set(Constants.CACHE_LOGIN_SYS_USER +
		// userContext.getSysUserId(), userContext,
		// Constants.CACHE_LOGIN_EXPIRE);
		// }
		// } catch (Exception e) {
		// DebugLogger.getInstance().info(e.getMessage());
		// }

	}

	@Override
	@Transactional(readOnly = true)
	public List<SysRole> listSysRoleByUserId(Long userId) throws Exception {
		return sysRoleUserService.listSysRoleBySysUserId(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysMenu> listSysMenuByUserId(Long userId) throws Exception {
		return sysMenuService.findLoginUserMenus(userId);
	}

	@Override
	protected Map<Long, SysUser> list2Map(List<SysUser> list) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 插入系统角色下的用户
	 * 
	 * @param sysUserId
	 *            系统用户id
	 * @param roleIds
	 *            系统角色id
	 * @throws Exception
	 */

	private void insertSysRoleUser(Long sysUserId, String roleIds) throws Exception {
		if (StringUtil.isNotBlank(roleIds)) {
			for (String roleId : roleIds.split(",")) {
				sysRoleUserService.insert(sysUserId, Long.valueOf(roleId));
			}
		}
	}

}
