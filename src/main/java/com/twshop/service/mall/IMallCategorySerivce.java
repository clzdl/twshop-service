package com.twshop.service.mall;

import java.util.List;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.mall.MallCategory;
import com.twshop.vo.admin.ZTreeNodeVO;

public interface IMallCategorySerivce extends IEntityService<MallCategory> {
	/**
	 * 父节点孩子数
	 * 
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	Integer countByParentId(Long parentId) throws Exception;

	/**
	 * 获取商户的分类列表
	 * 
	 * @param merchantId
	 * @return
	 * @throws Exception
	 */
	List<ZTreeNodeVO> listZTreeNodeVo(Long merchantId) throws Exception;
}
