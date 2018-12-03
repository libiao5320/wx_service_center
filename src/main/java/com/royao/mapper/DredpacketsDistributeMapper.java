/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dmember;
import com.royao.model.DredpacketsDistribute;

import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;


public interface DredpacketsDistributeMapper extends BaseDao<DredpacketsDistribute> {

    public List queryByUser(Dmember dmember) throws SQLException;
	public Integer queryCountByUserId (Long memId) throws SQLException;
	List<DredpacketsDistribute> queryByredpacketsId(DredpacketsDistribute red);

	List<DredpacketsDistribute> queryByredIdAndMemberId(DredpacketsDistribute red);

	List<DredpacketsDistribute> queryByMemberId(DredpacketsDistribute red);
	
	
	List<DredpacketsDistribute> queryBymemberIdAndKy(DredpacketsDistribute red);

	public Integer validPack( Long packId )throws SQLException ;
	public Integer querySourceRedPackCount( Long packId ) throws SQLException ;
	
	public DredpacketsDistribute queryIsShare(DredpacketsDistribute red) throws SQLException ;
	public List<DredpacketsDistribute> getRedpacketsUseList(
			DredpacketsDistribute paramRedpackets);
	public long countRedpacketsUseList(DredpacketsDistribute paramRedpackets);
	public Integer redPacketsOverdue();
}
