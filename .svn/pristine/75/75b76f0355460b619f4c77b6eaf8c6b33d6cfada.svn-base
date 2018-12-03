/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import java.sql.SQLException;
import java.util.List;

import com.royao.model.DbalanceLogs;
import com.royao.model.Order;
import com.royao.services.base.BaseService;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DbalanceLogsService extends BaseService<DbalanceLogs> {

    public DbalanceLogs querySn(String sn) throws Exception;

	public List<DbalanceLogs> queryUserBalancelogs(DbalanceLogs logs) throws Exception;

	public Long countStored() throws Exception;
	
	
	List<DbalanceLogs> queryLogs(Order or) throws SQLException;
	
	Long queryLogsCount(Order or) throws SQLException;


}