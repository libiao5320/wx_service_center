/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dconsumption;
import com.royao.model.Dmember;

import java.sql.SQLException;
import java.util.List;


public interface DconsumptionMapper extends BaseDao<Dconsumption> {

    public List queryByUser(Dmember dmember) throws SQLException;
    
    public Integer queryCountByUserId (Long memId) throws SQLException;
    
    public List<Dconsumption> getByGoodsvalidityTime(Dconsumption t);
    
    public List<Dconsumption> queryByCondition_s(Dconsumption t);
}
