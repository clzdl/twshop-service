package com.twshop.vo.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.base.mvc.vo.IBaseVO;
import com.base.util.other.NullUtil;
import com.base.util.string.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twshop.entity.admin.SysMenu;

/**
 * @classname: SysMenuForm
 * @description: 系统菜单
 * @author java
 *
 */
public class SysMenuVO implements IBaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 275424315610276507L;

	private String title;
	private String icon;
	private String href;
	private boolean spread;// 是否有子节点
	private List<SysMenuVO> children;
	@JsonIgnore
	private Long id;
	@JsonIgnore
	private Long parentId;

	public SysMenuVO(SysMenu entity) {
		this.title = entity.getName();
		this.href = entity.getHref();
		this.icon = NullUtil.null2Blank(entity.getIcon());
		this.spread = StringUtil.isBlank(entity.getHref());
		this.id = (long) entity.getId().intValue();
		this.parentId = (long) entity.getParentId().intValue();
	}

	public static List<SysMenuVO> build(List<SysMenu> list) {
		List<SysMenuVO> ret = new ArrayList<SysMenuVO>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (SysMenu entity : list) {
				ret.add(new SysMenuVO(entity));
			}
		}

		return treeMenuList(ret, 0L);
	}

	private static List<SysMenuVO> treeMenuList(List<SysMenuVO> menuList, Long parentId) {
		List<SysMenuVO> childMenu = new ArrayList<SysMenuVO>();
		for (SysMenuVO object : menuList) {
			Long menuId = object.getId();
			Long pid = object.getParentId();
			if (parentId.equals(pid)) {
				List<SysMenuVO> c_node = treeMenuList(menuList, menuId);
				object.setChildren(c_node);
				childMenu.add(object);
			}
		}
		return childMenu;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
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

	public List<SysMenuVO> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenuVO> children) {
		this.children = children;
	}

}
