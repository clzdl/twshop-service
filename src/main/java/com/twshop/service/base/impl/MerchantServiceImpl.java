package com.twshop.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.util.string.StringUtil;
import com.twshop.entity.base.BaseMerchant;
import com.twshop.service.base.IMerchantSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: MerchantServiceImpl
 * @description: 商户信息
 * @author java
 *
 */
@Service
public class MerchantServiceImpl extends AbastractEntityService<BaseMerchant> implements IMerchantSerivce {

	protected MerchantServiceImpl() {
		super(BaseMerchant.class);
	}

	@Override
	public PageModel<BaseMerchant> listPageModel(BaseMerchant entity, Integer pageNo, Integer pageSize)
			throws Exception {
		Builder builder = Example.builder(BaseMerchant.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (StringUtil.isNotBlank(entity.getName())) {
			builder.where(Sqls.custom().andLike("name", "%" + entity.getName() + "%"));
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
	public boolean fakeDeleteEntity(BaseMerchant entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, BaseMerchant> list2Map(List<BaseMerchant> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
