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
import com.royao.model.Dcomplain;


public interface DcomplainMapper extends BaseDao<Dcomplain> {
	
	//订单投诉信息查询
	public List<Dcomplain> listWithPageAndCondition(Map params);
	//在某些查询条件下数据的总条数
	public int countWithCondition(Map params);
	public int bcountWithCondition(Map params);
	public List<Map> blistWithPageAndCondition(Map params);
	public Integer countUnhandleComplain(Dcomplain complain);

}
