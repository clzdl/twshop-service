package com.twshop.service.admin.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.base.auth.usercontext.BaseUserContext;
import com.base.auth.usercontext.SysCurrentUserContext;
import com.base.mvc.service.mybatis.AbastractEntityService;
import com.base.operationlog.LogTaskHandler;
import com.base.util.date.DateUtil;
import com.twshop.entity.admin.SysOperationLog;
import com.twshop.service.admin.ISysOperationLogService;

@Service("logTaskHandler")
public class SysOperationLogServiceImpl extends AbastractEntityService<SysOperationLog>
		implements ISysOperationLogService, LogTaskHandler {

	protected SysOperationLogServiceImpl() {
		super(SysOperationLog.class);
	}

	@Override
	public boolean fakeDeleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fakeDeleteEntity(SysOperationLog entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Map<Long, SysOperationLog> list2Map(List<SysOperationLog> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recordLog(Long userId, String bussinessName, String clazzName, String methodName) throws Exception {
		SysOperationLog sysOperationLog = new SysOperationLog();
		sysOperationLog.setSysUserId(userId);
		sysOperationLog.setContents(bussinessName);
		sysOperationLog.setCreateTime(DateUtil.getCurrentTimeStamp());
		super.insert(sysOperationLog);
	}

	@Override
	public Long getOperationUserId() {
		return getSysCurrentUserId();
	}

	private Long getSysCurrentUserId() {
		SysCurrentUserContext sysUserContext = (SysCurrentUserContext) BaseUserContext.getCurrentSysUserContext(true);
		if (sysUserContext != null) {
			return sysUserContext.getUserId();
		}
		return null;
	}

}
