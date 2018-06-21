package com.twshop.service.admin.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.util.date.DateUtil;
import com.twshop.entity.admin.SysRole;
import com.twshop.service.admin.ISysRoleMenuService;
import com.twshop.service.admin.ISysRoleService;

@Service
public class SysRoleServiceImpl extends AbastractEntityService<SysRole> implements ISysRoleService {

	@Resource
	private ISysRoleMenuService sysRoleMenuService;

	protected SysRoleServiceImpl() {
		super(SysRole.class);
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(SysRole entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insert(SysRole entity, List<Long> menuIds) throws Exception {
		entity.setCreateTime(DateUtil.getCurrentTimeStamp());
		Long sys_role_id = super.insert(entity);
		if (CollectionUtils.isNotEmpty(menuIds)) {
			for (Long menu_id : menuIds) {
				sysRoleMenuService.insert(sys_role_id, menu_id);
			}
		}
		return sys_role_id;
	}

	@Override
	public void update(SysRole entity, List<Long> menuIds) throws Exception {
		super.update(entity);

		sysRoleMenuService.deleteBySysRoleId(Long.valueOf(entity.getId().intValue()));
		if (CollectionUtils.isNotEmpty(menuIds)) {
			for (Long menu_id : menuIds) {
				sysRoleMenuService.insert(Long.valueOf(entity.getId().intValue()), menu_id);
			}
		}
	}

	@Override
	protected Map<Long, SysRole> list2Map(List<SysRole> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
