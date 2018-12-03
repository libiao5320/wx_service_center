/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import com.royao.model.Dconsumption;
import com.royao.model.Dmember;
import com.royao.services.base.BaseService;

import java.util.List;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DconsumptionService extends BaseService<Dconsumption> {

    public List queryByUser(Dmember dmember) throws Exception;
    public Integer queryCountByUserId( Long memId) throws Exception;
    
    public List<Dconsumption> getByGoodsvalidityTime(Dconsumption t);
    
    public List<Dconsumption> queryByCondition_s(Dconsumption t);
}