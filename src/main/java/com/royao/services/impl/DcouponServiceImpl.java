/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DcouponMapper;
import com.royao.model.Dcoupon;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DcouponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("couponService")
public class DcouponServiceImpl extends BaseServiceImpl<Dcoupon> implements DcouponService {

    @Autowired
    private DcouponMapper dcouponMapper;


    public int save(Dcoupon dcoupon) throws Exception {
        return dcouponMapper.save(dcoupon);
    }

    public int update(Dcoupon dcoupon) throws Exception {
        return dcouponMapper.update(dcoupon);
    }

    public int delete(Long id) throws Exception {
        return dcouponMapper.delete(id);
    }

    public Dcoupon queryById(Long id) throws Exception {
        return dcouponMapper.queryById(id);
    }

    public List<Dcoupon> queryByCondtion(Map map) throws Exception {
        return dcouponMapper.queryByCondtion(map);
    }

    public List<Dcoupon> queryAll() throws Exception {
        return dcouponMapper.queryAll();
    }

    public List<Dcoupon> listWithPage(Dcoupon t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}