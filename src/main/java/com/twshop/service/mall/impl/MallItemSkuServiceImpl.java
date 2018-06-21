package com.twshop.service.mall.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.twshop.entity.mall.MallItemSku;
import com.twshop.service.mall.IMallItemSkuSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: MallItemSkuServiceImpl
 * @description: 商品SKU信息
 * @author java
 *
 */
@Service
public class MallItemSkuServiceImpl extends AbastractEntityService<MallItemSku> implements IMallItemSkuSerivce {

	protected MallItemSkuServiceImpl() {
		super(MallItemSku.class);
	}

	@Override
	public PageModel<MallItemSku> listPageModel(MallItemSku entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(MallItemSku.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (null != entity.getItemId()) {
			builder.where(Sqls.custom().andEqualTo("itemId", entity.getItemId()));
		}
		builder.orderByDesc("id");
		return super.listPageModelByExample(builder.build(), pageNo, pageSize);
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(MallItemSku entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, MallItemSku> list2Map(List<MallItemSku> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
