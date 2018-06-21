package com.twshop.service.base.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.exception.BizException;
import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.util.string.StringUtil;
import com.twshop.ExceptionMessage;
import com.twshop.entity.base.BaseArea;
import com.twshop.enums.base.EnumAreaType;
import com.twshop.service.base.IAreaSerivce;
import com.twshop.vo.base.AreaFeTreeNodeVO;
import com.twshop.vo.base.AreaTreeNodeVO;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: AreaServiceImpl
 * @description: 地区服务
 * @author java
 *
 */
@Service
public class AreaServiceImpl extends AbastractEntityService<BaseArea> implements IAreaSerivce {

	private final static Integer _SPECPROVICE = 0;/// 直辖市
	private final static Integer _PROVICE = 1;
	private final static Integer _CITY = 2;
	private final static Integer _COUNTY = 3;
	private final static String _FIRST_NO = "1";
	private final static String _DEFAULT_CODE = "000000";
	private final static Integer _DEFAULT_TYPE = 1;
	private final static Integer _MAX_TYPE = 3;
	private Map<String, BaseArea> cacheMap = null;

	protected AreaServiceImpl() {
		super(BaseArea.class);
	}

	@Override
	@Transactional(readOnly = true)
	public PageModel<BaseArea> listPageModel(BaseArea entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(BaseArea.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}

		if (null != entity.getParentId()) {
			builder.where(Sqls.custom().andEqualTo("parentId", entity.getParentId()));
		}

		if (StringUtil.isNotBlank(entity.getAreaName())) {
			builder.where(Sqls.custom().andLike("areaName", "%" + entity.getAreaName() + "%"));
		}

		if (null != entity.getAreaType()) {
			builder.where(Sqls.custom().andEqualTo("areaType", entity.getAreaType()));
		}

		builder.orderByDesc("id");
		return super.listPageModelByExample(builder.build(), pageNo, pageSize);
	}

	@Override
	public List<AreaTreeNodeVO> buildTree() throws Exception {
		List<BaseArea> list = super.listAll();
		Map<Long, BaseArea> dataMap = new HashMap<>();
		for (BaseArea area : list) {
			dataMap.put(area.getId(), area);
		}
		return AreaTreeNodeVO.buildTree(dataMap);
	}

	@Override
	public List<AreaFeTreeNodeVO> buildFeTree() throws Exception {
		Map<String, BaseArea> cache = getCache();
		return AreaFeTreeNodeVO.buildTree(cache);
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, BaseArea> getMapByCodes(Collection<String> codes) throws Exception {
		Map<String, BaseArea> result = new HashMap<>();
		Map<String, BaseArea> cache = getCache();
		for (String code : codes) {
			result.put(code, cache.get(code));
		}
		return result;
	}

	@Override
	public void save(BaseArea entity) throws Exception {
		if (null != entity.getId()) {/// 更新
			super.update(entity);
		} else {
			if (null == entity.getParentId()) {
				throw new BizException(ExceptionMessage.PARAMS_ERROR);
			}
			/// 添加
			Integer type = entity.getAreaType() == null ? _DEFAULT_TYPE : entity.getAreaType(); // 默认省份
			String parentCode = _DEFAULT_CODE;
			Long parentId = entity.getParentId();
			if (parentId > 0) {
				BaseArea parentArea = super.getById(parentId);
				if (null == parentArea) {
					throw new BizException(ExceptionMessage.NO_DATA_ERROR);
				}
				if (EnumAreaType.SPEC_PROVINCE == EnumAreaType.getEnum(parentArea.getAreaType())) {
					/// 父级为直辖市
					type = EnumAreaType.COUNTY.getCode();
					parentCode = parentArea.getAreaCode().substring(0, 2) + "0100";
				} else {
					type = parentArea.getAreaType() + 1;
					parentCode = parentArea.getAreaCode();
				}
			}
			if (type > _MAX_TYPE) {
				throw new BizException(ExceptionMessage.NO_RIGHT_ERROR);
			}
			/// 生成编码，类型
			String code = generateCode(type, parentId, parentCode);
			entity.setAreaCode(code);
			entity.setAreaType(type);
			super.insert(entity);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<BaseArea> listByParentCodeAndType(String parentCode, Integer type) throws Exception {
		return super.listAllByExample(Example.builder(BaseArea.class)
				.where(Sqls.custom().andEqualTo("parentCode", parentCode).andEqualTo("areaType", type)).build());
	}

	@Override
	public void removeCache() throws Exception {
		synchronized (this) {
			cacheMap = null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> cityList() throws Exception {
		List<BaseArea> list = super.listAll();
		Map<String, String> result = new HashMap<>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (BaseArea area : list) {
				result.put(area.getAreaCode(), area.getAreaName());
			}
		}
		return result;
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(BaseArea entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, BaseArea> list2Map(List<BaseArea> list) {
		Map<Long, BaseArea> map = new HashMap<>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (BaseArea area : list) {
				map.put(area.getId(), area);
			}
		}
		return map;
	}

	private Map<String, BaseArea> getCache() throws Exception {
		if (null == cacheMap) {
			synchronized (this) {
				List<BaseArea> list = super.listAll();
				cacheMap = new HashMap<String, BaseArea>();
				for (BaseArea area : list) {
					cacheMap.put(area.getAreaCode(), area);
				}
			}
		}

		return cacheMap;
	}

	@Transactional(readOnly = true)
	private String generateCode(Integer type, Long parentId, String parentCode) throws Exception {
		List<BaseArea> child = super.listAllByExample(
				Example.builder(BaseArea.class).where(Sqls.custom().andEqualTo("parentId", parentId)).build());
		if (CollectionUtils.isEmpty(child)) {
			// 无孩子
			return hopeCodeString(parentCode, type, _FIRST_NO);
		} else {
			String hopeNO = calcChildNo(child, type);
			return hopeCodeString(parentCode, type, hopeNO);
		}
	}

	private String hopeCodeString(String parentCode, Integer type, String cur) throws Exception {
		if (_PROVICE.equals(type) || _SPECPROVICE.equals(type)) {
			return StringUtils.leftPad(cur, 2, "0") + "0000";
		} else if (_CITY.equals(type)) {
			return parentCode.substring(0, 2) + StringUtils.leftPad(cur, 2, "0") + "00";
		} else if (_COUNTY.equals(type)) {
			return parentCode.substring(0, 4) + StringUtils.leftPad(cur, 2, "0");
		}

		throw new BizException(ExceptionMessage.PARAMS_ERROR);
	}

	private String calcChildNo(List<BaseArea> child, Integer type) {
		Set<Integer> set = new HashSet<>();
		Integer no = null;
		for (BaseArea area : child) {
			if (_PROVICE.equals(type) || _SPECPROVICE.equals(type)) {
				no = Integer.valueOf(area.getAreaCode().substring(0, 2));
			} else if (_CITY.equals(type)) {
				no = Integer.valueOf(area.getAreaCode().substring(2, 4));
			} else if (_COUNTY.equals(type)) {
				no = Integer.valueOf(area.getAreaCode().substring(4, 6));
			}
			set.add(no);
		}

		Integer hopeNo = 1;
		for (Integer cur : set) {
			if (!hopeNo.equals(cur)) {
				return hopeNo.toString();
			}
			++hopeNo;
		}
		return hopeNo.toString();
	}

}
