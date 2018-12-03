/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */


package com.royao.services.inface;


import com.royao.model.Dtechie;
import com.royao.model.Order;
import com.royao.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */



public interface DtechieService extends BaseService<Dtechie> {
	
        public List queryHomeBestTechie() throws Exception;

		public Dtechie findById(Long id);
		
		public List<Dtechie> queryReward(Order or) throws SQLException;
		
		public Long queryRewardCount(Order or) throws SQLException;
}