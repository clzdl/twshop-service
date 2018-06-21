package com.twshop.service.mall.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.mvc.page.PageModel;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.twshop.entity.mall.MallCategory;
import com.twshop.service.mall.IMallCategorySerivce;
import com.twshop.vo.admin.ZTreeNodeVO;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Builder;
import tk.mybatis.mapper.util.Sqls;

/**
 * @classname: MallCategory
 * @description: 商品分类信息
 * @author java
 *
 */
@Service
public class MallCategoryServiceImpl extends AbastractEntityService<MallCategory> implements IMallCategorySerivce {

	protected MallCategoryServiceImpl() {
		super(MallCategory.class);
	}

	@Override
	@Transactional(readOnly = true)
	public PageModel<MallCategory> listPageModel(MallCategory entity, Integer pageNo, Integer pageSize)
			throws Exception {
		Builder builder = Example.builder(MallCategory.class);
		if (null != entity.getId()) {
			builder.where(Sqls.custom().andEqualTo("id", entity.getId()));
		}
		if (null != entity.getMerchantId()) {
			builder.where(Sqls.custom().andEqualTo("merchantId", entity.getMerchantId()));
		}
		if (null != entity.getParentId()) {
			builder.where(Sqls.custom().andEqualTo("parentId", entity.getParentId()));
		}

		builder.orderByDesc("id");
		return super.listPageModelByExample(builder.build(), pageNo, pageSize);
	}

	@Override
	public void save(MallCategory entity) throws Exception {
		MallCategory parentEntity = super.getById(entity.getParentId());
		if (null != parentEntity) {
			entity.setPathIds(parentEntity.getPathIds() + "," + parentEntity.getId());
			entity.setMerchantId(parentEntity.getMerchantId());
		} else {
			entity.setPathIds("0");
		}
		super.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countByParentId(Long parentId) throws Exception {
		return super.countByExample(
				Example.builder(MallCategory.class).where(Sqls.custom().andEqualTo("parentId", parentId)).build());
	}

	@Override
	@Transactional(readOnly = true)
	public List<ZTreeNodeVO> listZTreeNodeVo(Long merchantId) throws Exception {
		List<MallCategory> list = super.listAllByExample(
				Example.builder(MallCategory.class).where(Sqls.custom().andEqualTo("merchantId", merchantId)).build());

		List<ZTreeNodeVO> listNode = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(list)) {
			ZTreeNodeVO node = null;
			for (MallCategory category : list) {
				node = new ZTreeNodeVO();
				node.setId(category.getId());
				node.setpId(category.getParentId());
				node.setName(category.getName());
				listNode.add(node);
			}
		}
		return listNode;
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(MallCategory entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, MallCategory> list2Map(List<MallCategory> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
