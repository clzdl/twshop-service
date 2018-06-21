package com.twshop.service.admin.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.exception.BizException;
import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.twshop.ExceptionMessage;
import com.twshop.entity.admin.SysOrg;
import com.twshop.service.admin.ISysOrgService;
import com.twshop.vo.admin.ZTreeNodeVO;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

@Service
public class SysOrgServiceImpl extends AbastractEntityService<SysOrg> implements ISysOrgService {

	protected SysOrgServiceImpl() {
		super(SysOrg.class);
	}

	@Override
	public PageModel<SysOrg> listPageModel(SysOrg entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(SysOrg.class);
		if (entity.getId() != null) {
			builder.andWhere(Sqls.custom().andEqualTo("parentId", entity.getId()));
		}
		builder.orderByDesc("id");
		return super.listPageModelByExample(builder.build(), pageNo, pageSize);
	}

	@Override
	public boolean deleteById(Long id) throws Exception {
		if (CollectionUtils.isNotEmpty(getChildRolesById(id))) {
			throw new BizException(ExceptionMessage.SYS_ORG_DELETE_ERROR);
		}
		super.deleteById(id);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysOrg> findDecorateOrgs() throws Exception {
		List<SysOrg> list = super.listAll();
		if (CollectionUtils.isNotEmpty(list)) {
			return SysOrgDecorater.decorate(list);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ZTreeNodeVO> tree() throws Exception {
		List<ZTreeNodeVO> listNode = new ArrayList<>();
		List<SysOrg> list = super.listAll();
		ZTreeNodeVO node = null;
		for (SysOrg org : list) {
			node = new ZTreeNodeVO();
			node.setId(org.getId());
			node.setpId(org.getParentId());
			node.setName(org.getOrgName());
			listNode.add(node);
		}
		return listNode;
	}

	/**
	 * @ClassName: OrgDecorater
	 * @Description: 机构修饰类
	 * @author kingmxj
	 * @date 2015-4-10 上午9:42:35
	 * 
	 */
	public static class SysOrgDecorater {
		/**
		 * 对输入的List类型的菜单列表信息进行修饰
		 * 
		 * @param source
		 * @return
		 * @preserve
		 */
		public static List<SysOrg> decorate(List<SysOrg> source) {
			List<SysOrg> listfirstlevel = SysOrgSorter.get1stLevel(source);

			List<SysOrg> listIndented = SysOrgSorter.start(listfirstlevel, source);

			List<SysOrg> rt = doDecorate(listIndented);
			return rt;
		}

		/**
		 * 以8个空格为单位进行缩进
		 * 
		 * @param listIndented
		 * @return
		 */
		private static List<SysOrg> doDecorate(List<SysOrg> listIndented) {
			SysOrg m = new SysOrg();
			List<SysOrg> rt = new Vector<SysOrg>();
			for (int xi = 0; xi < listIndented.size(); xi++) {
				m = (SysOrg) listIndented.get(xi);
				int in = m.getLevel();
				m.setSdecorate("");
				for (int yi = 1; yi < in; yi++) {
					m.setSdecorate(m.getSdecorate() + "----");
				}
				rt.add(m);
				m = null;
			}
			return rt;
		}
	}

	/**
	 * @ClassName: OrgSorter
	 * @Description: 机构排序类
	 * @author kingmxj
	 * @date 2015-4-10 上午9:42:53
	 * 
	 */
	public static class SysOrgSorter {
		/**
		 * 获取一级部门
		 * 
		 * @preserve
		 */
		public static List<SysOrg> get1stLevel(List<SysOrg> li) {
			List<SysOrg> list = new Vector<SysOrg>();
			for (int xi = 0; xi < li.size(); xi++) {
				SysOrg model = (SysOrg) li.get(xi);

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
		public static List<SysOrg> start(List<SysOrg> l, List<SysOrg> ro) {
			int level = 1;
			List<SysOrg> r = new Vector<SysOrg>();
			for (int i = 0; i < l.size(); i++) {
				SysOrg c = new SysOrg();
				c = (SysOrg) l.get(i);
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
		private static List<SysOrg> run(List<SysOrg> l, List<SysOrg> r, SysOrg cr, int level) {
			for (int xi = 0; xi < l.size(); xi++) {
				SysOrg c = new SysOrg();
				c = (SysOrg) l.get(xi);
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

	/**
	 * 获取父节点下的孩子结构列表
	 * 
	 * @param parentId
	 *            父结构的id
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	private List<SysOrg> getChildRolesById(Long parentId) throws Exception {
		return null;
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(SysOrg entity) throws Exception {
		return false;
	}

	@Override
	protected Map<Long, SysOrg> list2Map(List<SysOrg> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
