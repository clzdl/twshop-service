package com.twshop.service.mall.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.twshop.entity.mall.MallSkuImg;
import com.twshop.service.mall.IMallSkuImgSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: MallSkuImgServiceImpl
 * @description: 商品SKU图片信息
 * @author java
 *
 */
@Service
public class MallSkuImgServiceImpl extends AbastractEntityService<MallSkuImg> implements IMallSkuImgSerivce {

	protected MallSkuImgServiceImpl() {
		super(MallSkuImg.class);
	}

	@Override
	@Transactional(readOnly = true)
	public PageModel<MallSkuImg> listPageModel(MallSkuImg entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(MallSkuImg.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (null != entity.getSkuId()) {
			builder.where(Sqls.custom().andEqualTo("skuId", entity.getSkuId()));
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
	public boolean fakeDeleteEntity(MallSkuImg entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, MallSkuImg> list2Map(List<MallSkuImg> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
