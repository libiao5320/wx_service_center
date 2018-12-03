/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import java.sql.SQLException;
import java.util.List;

import com.royao.db.BaseDao;
import com.royao.model.DbalanceLogs;
import com.royao.model.Order;


public interface DbalanceLogsMapper extends BaseDao<DbalanceLogs> {

    public DbalanceLogs querySn(String sn);

	public List<DbalanceLogs> queryUserByBalanceList(DbalanceLogs logs);

	public Long countStored();
	
	/**YX*/
	List<DbalanceLogs> queryLogs(Order or) throws SQLException;
	
	Long queryLogsCount(Order or) throws SQLException;

}
