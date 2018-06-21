package com.twshop.service.admin;

import java.util.List;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.admin.SysOrg;
import com.twshop.vo.admin.ZTreeNodeVO;

public interface ISysOrgService extends IEntityService<SysOrg> {

	/**
	 * 获取装饰后的机构列表
	 * 
	 * @return
	 * @throws Exception
	 */
	List<SysOrg> findDecorateOrgs() throws Exception;

	/**
	 * 获取ztree树节点
	 * 
	 * @return
	 * @throws Exception
	 */
	List<ZTreeNodeVO> tree() throws Exception;
}
