package com.twshop.service.mall.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.util.string.StringUtil;
import com.twshop.entity.mall.MallItem;
import com.twshop.enums.mall.EnumMallItemStatus;
import com.twshop.service.mall.IMallItemSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: MallItemServiceImpl
 * @description: 商品信息
 * @author java
 *
 */
@Service
public class MallItemServiceImpl extends AbastractEntityService<MallItem> implements IMallItemSerivce {

	protected MallItemServiceImpl() {
		super(MallItem.class);
	}

	@Override
	@Transactional(readOnly = true)
	public PageModel<MallItem> listPageModel(MallItem entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(MallItem.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (null != entity.getMerchantId()) {
			builder.where(Sqls.custom().andEqualTo("merchantId", entity.getMerchantId()));
		}
		if (null != entity.getCategoryId()) {
			builder.where(Sqls.custom().andEqualTo("categoryId", entity.getCategoryId()));
		}
		if (StringUtil.isNotBlank(entity.getName())) {
			builder.where(Sqls.custom().andLike("name", "%" + entity.getName() + "%"));
		}
		builder.orderByDesc("id");
		return super.listPageModelByExample(builder.build(), pageNo, pageSize);
	}

	@Override
	public void changeShelve(Long itemId) throws Exception {
		MallItem item = super.getById(itemId);
		if (EnumMallItemStatus.TOBESHELF == EnumMallItemStatus.getEnum(item.getStatus().intValue())) {
			item.setStatus(EnumMallItemStatus.SHELVED.getCode().byteValue());
			super.update(item);
		} else if (EnumMallItemStatus.SHELVED == EnumMallItemStatus.getEnum(item.getStatus().intValue())) {
			item.setStatus(EnumMallItemStatus.OUTSHELF.getCode().byteValue());
			super.update(item);
		}

	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(MallItem entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, MallItem> list2Map(List<MallItem> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
