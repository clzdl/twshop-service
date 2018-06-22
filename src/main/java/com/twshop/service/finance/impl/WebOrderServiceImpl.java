package com.twshop.service.finance.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.twshop.entity.finance.WebOrder;
import com.twshop.service.finance.IWebOrderSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: WebOrderServiceImpl
 * @description: 支付订单信息
 * @author java
 *
 */
@Service
public class WebOrderServiceImpl extends AbastractEntityService<WebOrder> implements IWebOrderSerivce {

	protected WebOrderServiceImpl() {
		super(WebOrder.class);
	}

	@Override
	public PageModel<WebOrder> listPageModel(WebOrder entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(WebOrder.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (null != entity.getMerchantId()) {
			builder.where(Sqls.custom().andEqualTo("merchantId", entity.getMerchantId()));
		}
		if (null != entity.getPayStatus()) {
			builder.where(Sqls.custom().andEqualTo("payStatus", entity.getPayStatus()));
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
	public boolean fakeDeleteEntity(WebOrder entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, WebOrder> list2Map(List<WebOrder> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
