package com.twshop.vo.mall;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.base.mvc.vo.IBaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.twshop.entity.mall.MallCategory;

/**
 * @classname: CategoryTreeVO
 * @description: 管理端分类树
 * @author java
 *
 */
@JsonInclude(Include.NON_NULL)
public class CategoryTreeVO implements IBaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -724927539757742751L;

	private static final Long ROOT_ID = 0L;

	private static final String URI = "/mall/category/list?parentId=";

	private String name;

	private Boolean spread;

	private String href;

	private Long id;

	private Long parentId;

	private List<CategoryTreeVO> children;

	public CategoryTreeVO(MallCategory category) {

		this.name = category.getName();

		this.spread = true;

		this.id = category.getId();

		this.parentId = category.getParentId();

		this.href = URI + category.getId();

		this.children = null;
	}

	public static List<CategoryTreeVO> build(List<MallCategory> list) {

		List<CategoryTreeVO> ret = new ArrayList<CategoryTreeVO>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (MallCategory entity : list) {
				if (ROOT_ID.equals(entity.getParentId())) {
					CategoryTreeVO orgForm = new CategoryTreeVO(entity);
					buildNode(orgForm, list);
					ret.add(orgForm);
				}
			}
		}
		return ret;
	}

	public static void buildNode(CategoryTreeVO parent, List<MallCategory> list) {
		/// build child
		if (CollectionUtils.isNotEmpty(list)) {
			for (MallCategory entity : list) {
				if (entity.getParentId().equals(parent.getId())) {
					// create child node
					CategoryTreeVO childForm = new CategoryTreeVO(entity);
					parent.addChild(childForm);
					buildNode(childForm, list);
				}
			}
		}
	}

	public void addChild(CategoryTreeVO e) {
		if (null == children) {
			children = new ArrayList<CategoryTreeVO>();
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

	public List<CategoryTreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryTreeVO> children) {
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
