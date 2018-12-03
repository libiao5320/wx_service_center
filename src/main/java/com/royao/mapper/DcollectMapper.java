/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dcollect;
import com.royao.model.Dmember;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface DcollectMapper extends BaseDao<Dcollect> {

    public List queryStoreCollByUserAndType(Dcollect dcollect) throws SQLException;
    
    public List queryGoodCollByUserAndType(Dcollect dcollect) throws SQLException;
    
    public Map queryCountByUserId( Long memId) throws SQLException;
    
	public List<Dcollect> findList(Dcollect collect) throws SQLException;
}
