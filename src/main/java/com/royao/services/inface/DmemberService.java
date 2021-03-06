/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.royao.model.Dmember;
import com.royao.model.Order;
import com.royao.services.base.BaseService;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DmemberService extends BaseService<Dmember> {


    public boolean register (Dmember dmember ) throws  Exception;

    public Dmember queryByWxCode(String wxCode) throws Exception;
    
    public String setJianAccountUtil(int type,Map<String,Object> map) throws Exception;

	public Dmember queryDetailById(Long memberId) throws SQLException;

	public Integer listWithPageCount(Dmember member);
	
	List<Dmember> queryBySaveings(Order or) throws SQLException;
    
	Long queryBySaveingsCount(Order or) throws SQLException;

}