package com.twshop.vo.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.base.mvc.vo.IBaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.twshop.entity.base.BaseArea;

/**
 * @classname: AreaFeTreeNodeVO
 * @description: 前端地区树
 * @author java
 *
 */
@JsonInclude(Include.NON_NULL)
public class AreaFeTreeNodeVO implements IBaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -724927539757742751L;
	private static final Long ROOT_ID = 0L;

	private String name;
	private Long id;
	private String parentCode;
	private String code;
	private Integer sortNo;
	private List<AreaFeTreeNodeVO> children;

	public static List<AreaFeTreeNodeVO> buildTree(Map<String, BaseArea> dataMap) {
		/// 一级结果缓存
		List<AreaFeTreeNodeVO> result = new ArrayList<>();
		/// 临时缓存
		Map<String, AreaFeTreeNodeVO> map = new HashMap<>();

		BaseArea classfiy = null;
		for (Map.Entry<String, BaseArea> set : dataMap.entrySet()) {
			classfiy = set.getValue();
			buildChild(classfiy, map, dataMap, result);
		}
		/// 按排序号排序
		for (AreaFeTreeNodeVO vo : result) {
			vo.sort();
		}

		return result;
	}

	public static void buildChild(BaseArea area, Map<String, AreaFeTreeNodeVO> map, Map<String, BaseArea> dataMap,
			List<AreaFeTreeNodeVO> result) {
		AreaFeTreeNodeVO cur = null;
		if (map.containsKey(area.getAreaCode())) {
			// 节点已处理过
			return;
		}
		do {
			if (ROOT_ID.equals(area.getParentCode())) {
				/// 一级节点
				cur = buildDataInfo(area);
				result.add(cur);
				break;
			}

			if (map.containsKey(area.getParentCode())) {
				/// 父级节点已处理
				AreaFeTreeNodeVO parent = map.get(area.getParentCode());
				cur = buildDataInfo(area);
				parent.addChild(cur);
			} else {
				// 父节点未处理
				BaseArea parentArea = dataMap.get(area.getParentCode());
				/// 创建父级节点
				buildChild(parentArea, map, dataMap, result);

				/// 父节点已建立
				AreaFeTreeNodeVO parent = map.get(area.getParentCode());
				cur = buildDataInfo(area);
				parent.addChild(cur);
			}
		} while (false);
		map.put(cur.getCode(), cur);
	}

	public static AreaFeTreeNodeVO buildDataInfo(BaseArea area) {
		AreaFeTreeNodeVO vo = new AreaFeTreeNodeVO();
		if (null != area) {
			vo.setId(area.getId());
			vo.setName(area.getAreaName());
			vo.setParentCode(area.getParentCode());
			vo.setCode(area.getAreaCode());
			vo.setSortNo(area.getSortNo());
		}
		return vo;
	}

	public void sort() {

		if (CollectionUtils.isNotEmpty(children)) {
			for (AreaFeTreeNodeVO vo : children) {
				vo.sort();
			}
			Collections.sort(children, new Comparator<AreaFeTreeNodeVO>() {
				// 升序排序
				public int compare(AreaFeTreeNodeVO o1, AreaFeTreeNodeVO o2) {
					return o1.getSortNo().compareTo(o2.getSortNo());
				}
			});
		}

	}

	public void addChild(AreaFeTreeNodeVO vo) {
		if (children == null) {
			children = new ArrayList<>();
		}
		children.add(vo);
	}

	public List<AreaFeTreeNodeVO> getChildren() {
		return children;
	}

	public void setChildren(List<AreaFeTreeNodeVO> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

}
