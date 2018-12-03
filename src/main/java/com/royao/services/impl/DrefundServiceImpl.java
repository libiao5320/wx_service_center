/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DrefundMapper;
import com.royao.model.Drefund;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DrefundService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("refundService")
public class DrefundServiceImpl extends BaseServiceImpl<Drefund> implements DrefundService {

    @Autowired
    private DrefundMapper drefundMapper;


    public int save(Drefund drefund) throws Exception {
        return drefundMapper.save(drefund);
    }

    public int update(Drefund drefund) throws Exception {
        return drefundMapper.update(drefund);
    }

    public int delete(Long id) throws Exception {
        return drefundMapper.delete(id);
    }

    public Drefund queryById(Long id) throws Exception {
        return drefundMapper.queryById(id);
    }

    public List<Drefund> queryByCondtion(Map map) throws Exception {
        return drefundMapper.queryByCondtion(map);
    }

    public List<Drefund> queryAll() throws Exception {
        return drefundMapper.queryAll();
    }

    public List<Drefund> listWithPage(Drefund t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

	public List<Drefund> listWithPageAndCondition(Map params) {
		return drefundMapper.listWithPageAndCondition(params);
	}

	public int countWithCondition(Map params) {
		return drefundMapper.countWithCondition(params);
	}

	public Drefund queryDetailByOrderId(int orderId) {
		return drefundMapper.queryDetailByOrderId(orderId);
	}


}