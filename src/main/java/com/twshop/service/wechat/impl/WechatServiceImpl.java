package com.twshop.service.wechat.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.twshop.entity.wechat.WechatAccount;
import com.twshop.service.wechat.IWechatAccountSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: WechatServiceImpl
 * @description: 微信公众号信息
 * @author java
 *
 */
@Service
public class WechatServiceImpl extends AbastractEntityService<WechatAccount> implements IWechatAccountSerivce {

	protected WechatServiceImpl() {
		super(WechatAccount.class);
	}

	@Override
	public PageModel<WechatAccount> listPageModel(WechatAccount entity, Integer pageNo, Integer pageSize)
			throws Exception {
		Builder builder = Example.builder(WechatAccount.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (null != entity.getMerchantId()) {
			builder.where(Sqls.custom().andEqualTo("merchantId", entity.getMerchantId()));
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
	public boolean fakeDeleteEntity(WechatAccount entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, WechatAccount> list2Map(List<WechatAccount> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
