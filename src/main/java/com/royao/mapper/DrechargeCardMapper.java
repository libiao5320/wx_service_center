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
import com.royao.model.DrechargeCard;


public interface DrechargeCardMapper extends BaseDao<DrechargeCard> {
		
		DrechargeCard queryCard(String cardPassword);

		public List<DrechargeCard> listWithPageAndCondition(Map params);
		
		public int countWithCondition(Map params);
		
		public int getCountByRechargeSn(String rechargeSn);
		
		public int updateStatus(Map params);
}
