/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DevaluateMapper;
import com.royao.model.Devaluate;
import com.royao.model.DevaluateImage;
import com.royao.model.Order;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DevaluateImageService;
import com.royao.services.inface.DevaluateService;

import com.royao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("evaluateService")
public class DevaluateServiceImpl extends BaseServiceImpl<Devaluate> implements DevaluateService {

    @Autowired
    private DevaluateMapper devaluateMapper;

    @Autowired
    private DevaluateImageService devaluateImageService;


    public int save(Devaluate devaluate) throws Exception {
        return devaluateMapper.save(devaluate);
    }

    public int update(Devaluate devaluate) throws Exception {
        return devaluateMapper.update(devaluate);
    }

    public int delete(Long id) throws Exception {
        return devaluateMapper.delete(id);
    }

    public Devaluate queryById(Long id) throws Exception {
        return devaluateMapper.queryById(id);
    }

    public List<Devaluate> queryByCondtion(Map map) throws Exception {
        return devaluateMapper.queryByCondtion(map);
    }

    public List<Devaluate> queryAll() throws Exception {
        return devaluateMapper.queryAll();
    }

    public List<Devaluate> listWithPage(Devaluate t) throws Exception {
        return devaluateMapper.listWithPage(t);
    }

	public List<Devaluate> query(Order or) throws SQLException {
		return this.devaluateMapper.query(or);
	}

	public Long queryCount(Order or) throws SQLException {
		return this.devaluateMapper.queryCount(or);
	}

    public List<Devaluate> queryByGoodId(Integer goodId) throws SQLException {
        return this.devaluateMapper.queryByGoodsIdList(goodId);
    }

    public Devaluate queryByOrderId(Integer orderId) throws SQLException {

        return this.devaluateMapper.queryByOrderId(orderId);

    }


}