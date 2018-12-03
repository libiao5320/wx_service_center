/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import java.util.List;
import java.util.Map;

import com.royao.model.DrechargeCard;
import com.royao.services.base.BaseService;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DrechargeCardService extends BaseService<DrechargeCard> {
	DrechargeCard queryCard(String cardPassword);
	
	public List<DrechargeCard> listWithPageAndCondition(Map params);
	
	public int countWithCondition(Map params);
	
	public int getCountByRechargeSn(String rechargeSn);
	
	public int updateStatus(Map params);
}