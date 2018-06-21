package com.twshop.service.base;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.base.BaseArea;
import com.twshop.vo.base.AreaFeTreeNodeVO;
import com.twshop.vo.base.AreaTreeNodeVO;

public interface IAreaSerivce extends IEntityService<BaseArea> {

	/**
	 * 根据地区编码列表获取数据map
	 * 
	 * @param codes
	 * @return
	 * @throws Exception
	 */
	Map<String, BaseArea> getMapByCodes(Collection<String> codes) throws Exception;

	/**
	 * 后端界面树
	 * 
	 * @return
	 */
	List<AreaTreeNodeVO> buildTree() throws Exception;

	/**
	 * 前端界面树
	 * 
	 * @return
	 * @throws Exception
	 */
	List<AreaFeTreeNodeVO> buildFeTree() throws Exception;

	/**
	 * 根据父编码即类型获取列表
	 * 
	 * @param parentCode
	 * @param type
	 * @return
	 * @throws Exception
	 */
	List<BaseArea> listByParentCodeAndType(String parentCode, Integer type) throws Exception;

	/**
	 * 删除内存中的缓存
	 * 
	 * @throws Exception
	 */
	void removeCache() throws Exception;

	/**
	 * 城市选择器数据列表
	 * 
	 * @return
	 * @throws Exception
	 */
	Map<String, String> cityList() throws Exception;
}
