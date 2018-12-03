/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dmember;
import com.royao.model.Dredpackets;
import com.royao.model.DredpacketsDistribute;
import com.royao.model.DredpacketsGroupbuy;
import com.royao.model.DredpacketsStore;

import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface DredpacketsMapper extends BaseDao<Dredpackets> {

    public Dredpackets queryByType(String type) throws SQLException;
    
    public void updateAlreadyUsed(Dredpackets dredpackets);

	public List<Dredpackets> queryAvailable(Dredpackets dred);

	public long pCountWithPageAndCondition(Dredpackets paramRedpackets);

	public List pListWithPageAndCondition(
			Dredpackets paramRedpackets);

	public long saveRedpacketsStore(DredpacketsStore redpacketsStore);

	public Long saveRedpacketsGroupClass(DredpacketsGroupbuy dg);

	public List<Map> queryStoreByRedpacketsId(Long id);

	public Long updateRedpacketsStore(DredpacketsStore redpacketsStore);

	public Long deleteRedpacketsGroupClassByRedId(Long id);

	public long updateRedpackets(Dredpackets redpackets);

	public List<Map> queryGroupClassByRedpacketsId(Long id);

}
