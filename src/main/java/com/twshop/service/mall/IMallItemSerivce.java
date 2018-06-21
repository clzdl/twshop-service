package com.twshop.service.mall;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.mall.MallItem;

public interface IMallItemSerivce extends IEntityService<MallItem> {
	/**
	 * 修改商品上架状态
	 * 
	 * @param itemId
	 * @throws Exception
	 */
	void changeShelve(Long itemId) throws Exception;
}
