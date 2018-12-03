/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.mapper;

import com.royao.db.BaseDao;
import com.royao.model.Dtechie;
import com.royao.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface DtechieMapper extends BaseDao<Dtechie>{


    public List queryHomeBestTechie() throws SQLException;

	public Dtechie findById(Long id);
	
	public List<Dtechie> queryReward(Order or) throws SQLException;
	
	public Long queryRewardCount(Order or) throws SQLException;
}
