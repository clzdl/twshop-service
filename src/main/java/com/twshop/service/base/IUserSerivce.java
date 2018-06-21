package com.twshop.service.base;

import com.base.mvc.service.mybatis.IEntityService;
import com.twshop.entity.base.BaseUser;

public interface IUserSerivce extends IEntityService<BaseUser> {
	/**
	 * 修改分销权限
	 * 
	 * @param userId
	 * @throws Exception
	 */
	void changeGrant(Long userId) throws Exception;

}
