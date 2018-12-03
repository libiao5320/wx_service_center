/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;

import java.util.List;
import java.util.Map;

import com.royao.db.BaseDao;
import com.royao.model.Dstore;
import com.royao.model.Order;

public interface DstoreMapper extends BaseDao<Dstore> {

	Dstore queryDetailById(Long id);

	@SuppressWarnings("rawtypes")
	List<Dstore> getNearbyStore(Map positionMap);

	List<Object> getStoreListByName(Dstore store);

	List<Object> getStoreByName(Dstore store);
	
	List<Map<?,?>> indexList(Order or);
	
	Long queryCount();
	
	Dstore queryDetail(Long storeId);
	
	List<Dstore> queryAlls(Map<String,Object> state);
	
	Long queryAllsCount(Map<String,Object> state);
	Dstore queryByLoginPhone(String phone);

	void insert(Dstore store);

	void updateByMap(Map<String, String> map);

	Map getStoreDetailById(Long id);

	long countSalesById(long storeId);

	long countAccountById(long storeId);

}
