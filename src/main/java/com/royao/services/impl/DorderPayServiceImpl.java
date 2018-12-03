/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DorderPayMapper;
import com.royao.model.DorderPay;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DorderPayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("orderPayServiceImpl")
public class DorderPayServiceImpl extends BaseServiceImpl<DorderPay> implements DorderPayService {

    @Autowired
    private DorderPayMapper dorderPayMapper;


    public int save(DorderPay dorderPay) throws Exception {
        return dorderPayMapper.save(dorderPay);
    }

    public int update(DorderPay dorderPay) throws Exception {
        return dorderPayMapper.update(dorderPay);
    }

    public int delete(Long id) throws Exception {
        return dorderPayMapper.delete(id);
    }

    public DorderPay queryById(Long id) throws Exception {
        return dorderPayMapper.queryById(id);
    }

    public List<DorderPay> queryByCondtion(Map map) throws Exception {
        return dorderPayMapper.queryByCondtion(map);
    }

    public List<DorderPay> queryAll() throws Exception {
        return dorderPayMapper.queryAll();
    }

    public List<DorderPay> listWithPage(DorderPay t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}