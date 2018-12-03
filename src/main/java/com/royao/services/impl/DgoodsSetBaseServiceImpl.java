/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DgoodsSetBaseMapper;
import com.royao.model.DgoodsSetBase;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DgoodsSetBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodsSetBaseServiceImpl")
public class DgoodsSetBaseServiceImpl extends BaseServiceImpl<DgoodsSetBase> implements DgoodsSetBaseService {

    @Autowired
    private DgoodsSetBaseMapper dgoodsSetBaseMapper;


    public int save(DgoodsSetBase dgoodsSetBase) throws Exception {
        return dgoodsSetBaseMapper.save(dgoodsSetBase);
    }

    public int update(DgoodsSetBase dgoodsSetBase) throws Exception {
        return dgoodsSetBaseMapper.update(dgoodsSetBase);
    }

    public int delete(Long id) throws Exception {
        return dgoodsSetBaseMapper.delete(id);
    }

    public DgoodsSetBase queryById(Long id) throws Exception {
        return dgoodsSetBaseMapper.queryById(id);
    }

    public List<DgoodsSetBase> queryByCondtion(Map map) throws Exception {
        return dgoodsSetBaseMapper.queryByCondtion(map);
    }

    public List<DgoodsSetBase> queryAll() throws Exception {
        return dgoodsSetBaseMapper.queryAll();
    }

    public List<DgoodsSetBase> listWithPage(DgoodsSetBase t)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}