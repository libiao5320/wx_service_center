/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import com.royao.model.Dcollect;
import com.royao.model.Dmember;
import com.royao.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DcollectService extends BaseService<Dcollect> {

    public List queryStoreCollByUserAndType(Dcollect dcollect) throws Exception;
    
    public List queryGoodCollByUserAndType(Dcollect dcollect) throws Exception;
    
    public Map queryCountByUserId( Long memId) throws Exception;
    
	public Dcollect insert(Dcollect collect) throws SQLException;
	
	public List<Dcollect> findList(Dcollect collect) throws SQLException;

}