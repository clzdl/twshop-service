package com.twshop.service.admin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.twshop.dao.admin.SysRoleMapper;
import com.twshop.dao.admin.SysRoleMenuMapper;
import com.twshop.dao.admin.SysRoleUserMapper;
import com.twshop.entity.admin.SysMenu;
import com.twshop.entity.admin.SysRoleMenu;
import com.twshop.entity.admin.SysRoleUser;
import com.twshop.enums.admin.EnumSysMenuLevelType;
import com.twshop.service.admin.ISysMenuSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

@Service
public class SysMenuServiceImpl extends AbastractEntityService<SysMenu> implements ISysMenuSerivce {
	private static final Long FIRST_LEVEL_PARENT_ID = 0L;
	@Resource
	private SysRoleUserMapper sysRoleUserMapper;
	@Resource
	private SysRoleMenuMapper sysRoleMenuMapper;
	@Resource
	private SysRoleMapper sysRoleMapper;

	protected SysMenuServiceImpl() {
		super(SysMenu.class);
	}

	@Override
	public PageModel<SysMenu> listPageModel(SysMenu entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(SysMenu.class);
		if (entity.getLevel() != null) {
			switch (EnumSysMenuLevelType.getEnum(entity.getLevel())) {
			case FIRST:
				builder.where(Sqls.custom().andEqualTo("parentId", FIRST_LEVEL_PARENT_ID));
				break;
			case SECOND:
				builder.where(Sqls.custom().andGreaterThan("parentId", FIRST_LEVEL_PARENT_ID));
				break;
			}
		}
		builder.orderByDesc("id");
		PageModel<SysMenu> pm = super.listPageModelByExample(builder.build(), pageNo, pageSize);
		for (SysMenu sysMenu : pm.getList()) {
			if (sysMenu.getParentId() > FIRST_LEVEL_PARENT_ID) {
				sysMenu.setLevel(EnumSysMenuLevelType.SECOND.getCode());
			} else {
				sysMenu.setLevel(EnumSysMenuLevelType.FIRST.getCode());
			}
		}

		return pm;
	}

	@Override
	public List<SysMenu> findDecorateMenus() throws Exception {
		Example example = Example.builder(SysMenu.class).orderByAsc("sortNo").build();
		List<SysMenu> list = super.listAllByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return SysMenuDecorater.decorate(list);
		}
		return null;
	}

	@Override
	public List<SysMenu> findLoginUserMenus(Long sysUserId) throws Exception {
		Set<SysMenu> menuSet = new HashSet<SysMenu>();
		List<SysRoleUser> sysRoleUsers = sysRoleUserMapper.selectByExample(
				Example.builder(SysRoleUser.class).where(Sqls.custom().andEqualTo("sysUserId", sysUserId)).build());
		if (CollectionUtils.isNotEmpty(sysRoleUsers)) {
			for (SysRoleUser sysRoleUser : sysRoleUsers) {
				List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectByExample(Example.builder(SysRoleMenu.class)
						.where(Sqls.custom().andEqualTo("sysRoleId", sysRoleUser.getSysRoleId())).build());
				if (CollectionUtils.isNotEmpty(sysRoleMenus)) {
					for (SysRoleMenu sysRoleMenu : sysRoleMenus) {
						SysMenu sysMenu = getById((long) sysRoleMenu.getSysMenuId().intValue());
						menuSet.add(sysMenu);
					}
				}
			}
		}
		List<SysMenu> list = new ArrayList<SysMenu>();
		list.addAll(menuSet);
		Collections.sort(list, new Comparator<SysMenu>() {
			@Override
			public int compare(SysMenu o1, SysMenu o2) {
				// 倒序
				if (o1.getSortNo() > o2.getSortNo()) {
					return 1;
				} else if (o1.getSortNo() < o2.getSortNo()) {
					return -1;
				}
				return 0;
			}
		});
		return list;
	}

	@Override
	public List<SysMenu> findMenuByParent(Long parentId) throws Exception {
		return listAllByExample(Example.builder(SysMenu.class).where(Sqls.custom().andEqualTo("parentId", parentId))
				.orderByDesc("sortNo").build());
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(SysMenu entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, SysMenu> list2Map(List<SysMenu> list) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @ClassName: SysMenuDecorater
	 * @Description: 菜单修饰类
	 * @author kingmxj
	 * @date 2015-4-10 上午9:42:35
	 * 
	 */
	public static class SysMenuDecorater {
		/**
		 * 对输入的List类型的菜单列表信息进行修饰
		 * 
		 * @param source
		 * @return
		 * @preserve
		 */
		public static List<SysMenu> decorate(List<SysMenu> source) {
			List<SysMenu> listfirstlevel = SysMenuSorter.get1stLevel(source);

			List<SysMenu> listIndented = SysMenuSorter.start(listfirstlevel, source);

			List<SysMenu> rt = doDecorate(listIndented);
			return rt;
		}

		/**
		 * 以8个空格为单位进行缩进
		 * 
		 * @param listIndented
		 * @return
		 */
		private static List<SysMenu> doDecorate(List<SysMenu> listIndented) {
			SysMenu m = new SysMenu();
			List<SysMenu> rt = new Vector<SysMenu>();
			for (int xi = 0; xi < listIndented.size(); xi++) {
				m = (SysMenu) listIndented.get(xi);
				int in = m.getLevel();
				m.setSdecorate("");
				for (int yi = 1; yi < in; yi++) {
					m.setSdecorate(m.getSdecorate() + "&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				rt.add(m);
				m = null;
			}
			return rt;
		}
	}

	/**
	 * @ClassName: SysMenuSorter
	 * @Description: 菜单排序类
	 * @author kingmxj
	 * @date 2015-4-10 上午9:42:53
	 * 
	 */
	public static class SysMenuSorter {
		/**
		 * 获取一级
		 * 
		 * @preserve
		 */
		public static List<SysMenu> get1stLevel(List<SysMenu> li) {
			List<SysMenu> list = new Vector<SysMenu>();
			for (int xi = 0; xi < li.size(); xi++) {
				SysMenu model = (SysMenu) li.get(xi);

				if (model.getParentId().intValue() == 0) {
					list.add(model);
				}
			}
			return list;
		}

		/**
		 * 
		 * @param l
		 *            未排序的一级部门列表
		 * @param ro
		 *            原所有部门列表
		 * @return
		 * @preserve
		 */
		public static List<SysMenu> start(List<SysMenu> l, List<SysMenu> ro) {
			int level = 1;
			List<SysMenu> r = new Vector<SysMenu>();
			for (int i = 0; i < l.size(); i++) {
				SysMenu c = new SysMenu();
				c = (SysMenu) l.get(i);
				c.setLevel(level);
				r.add(c);
				r = run(ro, r, c, level + 1);
			}
			return r;
		}

		/**
		 * 递规 返回节点cr下所有部门列表
		 * 
		 * @param l
		 *            原是所有部门列表
		 * @param r
		 *            存放结果的容器
		 * @param cr
		 *            当前的根节点
		 * @return
		 */
		private static List<SysMenu> run(List<SysMenu> l, List<SysMenu> r, SysMenu cr, int level) {
			for (int xi = 0; xi < l.size(); xi++) {
				SysMenu c = new SysMenu();
				c = (SysMenu) l.get(xi);
				if (c.getParentId().intValue() != 0) {
					if (c.getParentId().intValue() == cr.getId().intValue()) {
						c.setLevel(level);
						r.add(c);
						r = run(l, r, c, level + 1);
					}
				}
			}
			return r;
		}

	}
}
