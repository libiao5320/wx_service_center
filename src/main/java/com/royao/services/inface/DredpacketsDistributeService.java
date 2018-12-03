/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import com.royao.model.Dmember;


import com.royao.model.DredpacketsDistribute;
import com.royao.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DredpacketsDistributeService extends BaseService<DredpacketsDistribute> {

    public List queryByUser(Dmember dmember) throws Exception;
	public Integer queryCountByUserId( Long memId) throws Exception;

	List<DredpacketsDistribute> queryByredpacketsId(DredpacketsDistribute red);

	List<DredpacketsDistribute> queryByredIdAndMemberId(DredpacketsDistribute red);

	List<DredpacketsDistribute> queryByMemberId(DredpacketsDistribute red);
	
	//订单使用
	List<DredpacketsDistribute> queryBymemberIdAndKy(DredpacketsDistribute red);


	public DredpacketsDistribute makeRedPack(DredpacketsDistribute red ,int type) throws Exception;

	public boolean shareRedPack(Long packId) throws Exception ;
	
	//查询用户是否已经有分享红包
	public DredpacketsDistribute queryIsShare(DredpacketsDistribute red) throws SQLException ;
	
	public List getRedpacketsUseList(
			DredpacketsDistribute paramRedpackets);
	public long countRedpacketsUseList(DredpacketsDistribute paramRedpackets);
	
	public Integer redPacketsOverdue();
	   
	
}