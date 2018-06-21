package com.twshop.service.admin.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.util.date.DateUtil;
import com.twshop.entity.admin.SysRole;
import com.twshop.entity.admin.SysRoleUser;
import com.twshop.service.admin.ISysRoleMenuService;
import com.twshop.service.admin.ISysRoleService;
import com.twshop.service.admin.ISysRoleUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

@Service
public class SysRoleUserServiceImpl extends AbastractEntityService<SysRoleUser> implements ISysRoleUserService {

	@Resource
	private ISysRoleService sysRoleService;
	@Resource
	private ISysRoleMenuService sysRoleMenuService;

	protected SysRoleUserServiceImpl() {
		super(SysRoleUser.class);
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(SysRoleUser entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SysRole> findListBySysUserId(Long sysUserId) throws Exception {
		List<SysRole> listSysRole = sysRoleService.listAll();
		if (null != sysUserId) {
			List<SysRoleUser> listRoleUser = super.listAllByExample(
					Example.builder(SysRoleUser.class).where(Sqls.custom().andEqualTo("sysUserId", sysUserId)).build());

			if (CollectionUtils.isNotEmpty(listSysRole) && CollectionUtils.isNotEmpty(listRoleUser)) {
				for (SysRole sysRole : listSysRole) {
					for (SysRoleUser sysRoleUser : listRoleUser) {
						if (sysRoleUser.getSysRoleId().equals(sysRole.getId())) {
							sysRole.setChecked(true);
							break;
						}
					}
				}
			}

		}

		return listSysRole;
	}

	@Override
	@Transactional
	public List<SysRole> listSysRoleBySysUserId(Long sysUserId) throws Exception {
		List<SysRoleUser> listRoleUser = super.listAllByExample(
				Example.builder(SysRoleUser.class).where(Sqls.custom().andEqualTo("sysUserId", sysUserId)).build());

		List<Long> ids = new ArrayList<>();
		List<SysRole> listResult = new ArrayList<>();
		if (CollectionUtils.isEmpty(listRoleUser)) {
			return listResult;
		}

		for (SysRoleUser sysRoleUser : listRoleUser) {
			ids.add(sysRoleUser.getSysRoleId().longValue());
		}

		return sysRoleService.listByIds(ids);
	}

	@Override
	public void deleteBySysUserId(Long sysUserId) throws Exception {
		getMapper().deleteByExample(
				Example.builder(SysRoleUser.class).where(Sqls.custom().andEqualTo("sysUserId", sysUserId)).build());

	}

	@Override
	public void insert(Long sysUserId, Long roleId) throws Exception {
		SysRoleUser entity = new SysRoleUser();
		entity.setSysUserId(sysUserId);
		entity.setSysRoleId(roleId);
		entity.setCreateTime(DateUtil.getCurrentTimeStamp());
		super.insert(entity);

	}

	@Override
	protected Map<Long, SysRoleUser> list2Map(List<SysRoleUser> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
