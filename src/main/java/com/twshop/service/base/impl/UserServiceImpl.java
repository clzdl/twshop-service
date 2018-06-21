package com.twshop.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.util.string.StringUtil;
import com.twshop.entity.base.BaseUser;
import com.twshop.enums.common.EnumYesOrNo;
import com.twshop.service.base.IUserSerivce;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: UserServiceImpl
 * @description: 用户信息
 * @author java
 *
 */
@Service
public class UserServiceImpl extends AbastractEntityService<BaseUser> implements IUserSerivce {

	protected UserServiceImpl() {
		super(BaseUser.class);
	}

	@Override
	@Transactional(readOnly = true)
	public PageModel<BaseUser> listPageModel(BaseUser entity, Integer pageNo, Integer pageSize) throws Exception {
		Builder builder = Example.builder(BaseUser.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (null != entity.getMerchantId()) {
			builder.where(Sqls.custom().andEqualTo("merchantId", entity.getMerchantId()));
		}
		if (StringUtil.isNotBlank(entity.getNickName())) {
			builder.where(Sqls.custom().andLike("nickName", "%" + entity.getNickName() + "%"));
		}
		builder.orderByDesc("id");
		return super.listPageModelByExample(builder.build(), pageNo, pageSize);
	}

	@Override
	public void changeGrant(Long userId) throws Exception {
		BaseUser entity = super.getById(userId);
		Integer grantTag = EnumYesOrNo.getEnum(entity.getGrantDistributeTag().intValue()) == EnumYesOrNo.YES
				? EnumYesOrNo.NO.getCode()
				: EnumYesOrNo.YES.getCode();
		entity.setGrantDistributeTag(grantTag.byteValue());
		super.update(entity);
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(BaseUser entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, BaseUser> list2Map(List<BaseUser> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
