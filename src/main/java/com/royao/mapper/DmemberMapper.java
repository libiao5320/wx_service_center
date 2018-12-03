/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dmember;
import com.royao.model.Order;

import java.sql.SQLException;
import java.util.List;


public interface DmemberMapper extends BaseDao<Dmember> {

    public int register (Dmember dmember ) throws  SQLException;
    public Dmember queryByWxCode(String wxCode) throws SQLException;
    
    public int updateDmember(Dmember dmember) throws SQLException;
	public Dmember queryDetailById(Long memberId) throws SQLException;
	
	public Integer listWithPageCount(Dmember member);
	
	/**YX*/
	List<Dmember> queryBySaveings(Order or) throws SQLException;
    
	Long queryBySaveingsCount(Order or) throws SQLException;
}
