package com.twshop.vo.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.mvc.vo.IBaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.twshop.entity.base.BaseArea;

/**
 * @classname: AreaTreeNodeVO
 * @description: 后端地区数
 * @author java
 *
 */
@JsonInclude(Include.NON_NULL)
public class AreaTreeNodeVO implements IBaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -724927539757742751L;

	private static final Long ROOT_ID = 0L;

	//// id=&code=
	private static final String URI = "/area/list?";
	private String name;
	private Boolean spread;
	private String href;
	private Long id;
	private Long parentId;
	private String code;
	private List<AreaTreeNodeVO> children;

	public static List<AreaTreeNodeVO> buildTree(Map<Long, BaseArea> dataMap) {
		/// 一级结果缓存
		List<AreaTreeNodeVO> result = new ArrayList<>();
		/// 临时缓存
		Map<Long, AreaTreeNodeVO> map = new HashMap<>();

		BaseArea classfiy = null;
		for (Map.Entry<Long, BaseArea> set : dataMap.entrySet()) {
			classfiy = set.getValue();
			buildChild(classfiy, map, dataMap, result);
		}

		return result;
	}

	public static void buildChild(BaseArea area, Map<Long, AreaTreeNodeVO> map, Map<Long, BaseArea> dataMap,
			List<AreaTreeNodeVO> result) {
		AreaTreeNodeVO cur = null;

		if (map.containsKey(area.getId())) {
			// 节点已处理过
			return;
		}
		do {
			if (area.getParentId() == ROOT_ID) {
				/// 一级节点
				cur = buildDataInfo(area);
				result.add(cur);
				break;
			}

			if (map.containsKey(area.getParentId())) {
				/// 父级节点已处理
				AreaTreeNodeVO parent = map.get(area.getParentId());
				cur = buildDataInfo(area);
				parent.addChild(cur);
			} else {
				// 父节点未处理
				BaseArea parentArea = dataMap.get(area.getParentId());
				/// 创建父级节点
				buildChild(parentArea, map, dataMap, result);

				/// 父节点已建立
				AreaTreeNodeVO parent = map.get(area.getParentId());
				cur = buildDataInfo(area);
				parent.addChild(cur);
			}
		} while (false);
		map.put(cur.getId(), cur);
	}

	public static AreaTreeNodeVO buildDataInfo(BaseArea area) {
		AreaTreeNodeVO vo = new AreaTreeNodeVO();
		if (null != area) {
			vo.setId(area.getId());
			vo.setName(area.getAreaName());
			vo.setParentId(area.getParentId());
			if (area.getAreaType() < 3) {
				StringBuilder sb = new StringBuilder(URI);
				sb.append("id=").append(area.getId()).append("&");
				sb.append("code=").append(area.getAreaCode()).append("&");
				sb.append("type=").append(area.getAreaType());
				vo.setHref(sb.toString());
			}

		}
		return vo;
	}

	public void addChild(AreaTreeNodeVO vo) {
		if (children == null) {
			children = new ArrayList<>();
		}
		children.add(vo);
	}

	public List<AreaTreeNodeVO> getChildren() {
		return children;
	}

	public void setChildren(List<AreaTreeNodeVO> children) {
		this.children = children;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static String getUri() {
		return URI;
	}

}
