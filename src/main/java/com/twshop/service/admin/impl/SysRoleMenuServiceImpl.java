package com.twshop.service.admin.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.util.date.DateUtil;
import com.twshop.entity.admin.SysRoleMenu;
import com.twshop.service.admin.ISysMenuSerivce;
import com.twshop.service.admin.ISysRoleMenuService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

@Service
public class SysRoleMenuServiceImpl extends AbastractEntityService<SysRoleMenu> implements ISysRoleMenuService {

	@Resource
	private ISysMenuSerivce sysMenuService;

	protected SysRoleMenuServiceImpl() {
		super(SysRoleMenu.class);
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(SysRoleMenu entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long insert(Long sysRoleId, Long sysMenuId) throws Exception {
		SysRoleMenu sysRoleMenu = new SysRoleMenu();
		sysRoleMenu.setSysRoleId(sysRoleId);
		sysRoleMenu.setSysMenuId(sysMenuId);
		sysRoleMenu.setCreateTime(DateUtil.getCurrentTimeStamp());
		return super.insert(sysRoleMenu);
	}

	@Override
	protected Map<Long, SysRoleMenu> list2Map(List<SysRoleMenu> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBySysRoleId(Long sysRoleId) throws Exception {
		getMapper().deleteByExample(
				Example.builder(SysRoleMenu.class).where(Sqls.custom().andEqualTo("sysRoleId", sysRoleId)).build());

	}

	@Override
	public List<SysRoleMenu> findSysRoleMenusBySysRoleId(Long sysRoleId) throws Exception {
		List<SysRoleMenu> list = super.listAllByExample(
				Example.builder(SysRoleMenu.class).where(Sqls.custom().andEqualTo("sysRoleId", sysRoleId)).build());

		for (SysRoleMenu sysRoleMenu : list) {
			sysRoleMenu.setSysMenu(sysMenuService.getById((long) sysRoleMenu.getSysMenuId().intValue()));
		}

		return list;
	}

}
