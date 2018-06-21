package com.twshop.vo.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.base.mvc.vo.IBaseVO;
import com.twshop.entity.admin.SysOrg;

/**
 * @classname: SysOrgForm
 * @description: 系统组织机构
 * @author java
 *
 */
public class SysOrgVO implements IBaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -724927539757742751L;

	private static final Long ROOT_ID = 0L;

	private static final String URI = "/sysorg/list?id=";

	private String name;

	private Boolean spread;

	private String href;

	private Long id;

	private Long parentId;

	private List<SysOrgVO> children;

	public SysOrgVO(SysOrg sysOrg) {

		this.name = sysOrg.getOrgName();

		this.spread = true;

		this.id = (long) sysOrg.getId().intValue();

		this.parentId = (long) sysOrg.getParentId().intValue();

		this.href = URI + sysOrg.getId().toString();

		this.children = null;
	}

	public static List<SysOrgVO> build(List<SysOrg> list) {

		List<SysOrgVO> ret = new ArrayList<SysOrgVO>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (SysOrg entity : list) {
				if (ROOT_ID.equals((long) entity.getParentId().intValue())) {
					SysOrgVO orgForm = new SysOrgVO(entity);
					buildNode(orgForm, list);
					ret.add(orgForm);
				}
			}
		}
		return ret;
	}

	public static void buildNode(SysOrgVO parent, List<SysOrg> list) {

		/// build child
		if (CollectionUtils.isNotEmpty(list)) {
			for (SysOrg entity : list) {
				if (entity.getParentId().equals(parent.getId().intValue())) {
					// create child node
					SysOrgVO childForm = new SysOrgVO(entity);
					parent.addChild(childForm);
					buildNode(childForm, list);
				}
			}
		}
	}

	public void addChild(SysOrgVO e) {
		if (null == children) {
			children = new ArrayList<SysOrgVO>();
		}
		children.add(e);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<SysOrgVO> getChildren() {
		return children;
	}

	public void setChildren(List<SysOrgVO> children) {
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
