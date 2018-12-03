/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import java.sql.SQLException;
import java.util.List;
import com.royao.db.BaseDao;
import com.royao.model.Devent;

public interface DeventMapper extends BaseDao<Devent> {
	public List<Devent> pListWithPageAndCondition(Devent t);
	public long pCountWithPageAndCondition(Devent t);
	public Devent queryById(Long id);
	public Integer eventOverdue();
	
    public void updateEnrollNumJia(Devent devent) throws SQLException;
}
