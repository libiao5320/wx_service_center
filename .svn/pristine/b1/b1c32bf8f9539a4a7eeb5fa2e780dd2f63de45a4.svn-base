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
import com.royao.model.Devaluate;
import com.royao.model.Order;

public interface DevaluateMapper extends BaseDao<Devaluate> {
	List<Devaluate> queryByGoodsIdList (int goods_id);
	
	List<Devaluate> query(Order or) throws SQLException;
	
	Long queryCount(Order or) throws SQLException;

	public Devaluate queryByOrderId(Integer orderId) throws SQLException ;


}
