/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DconsumptionMapper;
import com.royao.model.Dconsumption;
import com.royao.model.Dmember;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DconsumptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("consumptionService")
public class DconsumptionServiceImpl extends BaseServiceImpl<Dconsumption> implements DconsumptionService {

    @Autowired
    private DconsumptionMapper dconsumptionMapper;


    public int save(Dconsumption dconsumption) throws Exception {
        return dconsumptionMapper.save(dconsumption);
    }

    public int update(Dconsumption dconsumption) throws Exception {
        return dconsumptionMapper.update(dconsumption);
    }

    public int delete(Long id) throws Exception {
        return dconsumptionMapper.delete(id);
    }

    public Dconsumption queryById(Long id) throws Exception {
        return dconsumptionMapper.queryById(id);
    }

    public List<Dconsumption> queryByCondtion(Map map) throws Exception {
        return dconsumptionMapper.queryByCondtion(map);
    }

    public List<Dconsumption> queryAll() throws Exception {
        return dconsumptionMapper.queryAll();
    }

    public List<Dconsumption> listWithPage(Dconsumption t) throws Exception {
        return null;
    }

    @Cacheable(value = "myCache", key = "#dmember")
    public List queryByUser(Dmember dmember) throws Exception {
        return dconsumptionMapper.queryByUser(dmember);
    }

    public Integer queryCountByUserId(Long memId) throws Exception {
        return dconsumptionMapper.queryCountByUserId(memId);
    }

	public List<Dconsumption> getByGoodsvalidityTime(Dconsumption t) {
		return this.dconsumptionMapper.getByGoodsvalidityTime(t);
	}

	public List<Dconsumption> queryByCondition_s(Dconsumption t) {
		return this.dconsumptionMapper.queryByCondition_s(t);
	}
}