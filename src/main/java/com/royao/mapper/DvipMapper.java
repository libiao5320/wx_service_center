/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dvip;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


public interface DvipMapper extends BaseDao<Dvip> {

    public Dvip queryByGreade(int greadeId) throws SQLException;
    
    public int updateRequireById(Dvip vip);
}
