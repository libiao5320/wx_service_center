/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import java.sql.SQLException;
import java.util.List;

import com.royao.model.Devaluate;
import com.royao.model.Order;
import com.royao.services.base.BaseService;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DevaluateService extends BaseService<Devaluate> {
	
	List<Devaluate> query(Order or) throws SQLException;
	
	Long queryCount(Order or) throws SQLException;

	List<Devaluate> queryByGoodId(Integer goodId) throws SQLException;
	Devaluate queryByOrderId(Integer orderId) throws SQLException;



}