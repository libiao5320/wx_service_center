/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import java.util.List;
import java.util.Map;

import com.royao.model.Dstore;
import com.royao.model.Order;
import com.royao.services.base.BaseService;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DstoreService extends BaseService<Dstore> {

	Dstore queryDetailById(Long id);

	List<Dstore> getNearbyStore(Double x, Double y,Map<?, ?> params);

	List<Object> getStoreListByName(Dstore store);

	List<Object> getStoreByName(Dstore paramEvent);
	
	List<Map<?,?>> indexList(Order or);
	
	Long queryCount();
	
	Dstore queryDetail(Long storeId);
	
	List<Dstore> queryAlls(Map<String,Object> state);
	
	Long queryAllsCount(Map<String,Object> state);
	Dstore queryByLoginPhone(String phone);

	Long insert(Dstore store);

	void updateByMap(Map<String, String> map);

	Map getStoreDetailById(Long id);

	long countSalesById(long storeId);

	long countAccountById(long storeId);
}