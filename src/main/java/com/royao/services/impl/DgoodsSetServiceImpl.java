/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DgoodsSetMapper;
import com.royao.model.DgoodsSet;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DgoodsSetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodsSetService")
public class DgoodsSetServiceImpl extends BaseServiceImpl<DgoodsSet> implements DgoodsSetService {

    @Autowired
    private DgoodsSetMapper dgoodsSetMapper;


    public int save(DgoodsSet dgoodsSet) throws Exception {
        return dgoodsSetMapper.save(dgoodsSet);
    }

    public int update(DgoodsSet dgoodsSet) throws Exception {
        return dgoodsSetMapper.update(dgoodsSet);
    }

    public int delete(Long id) throws Exception {
        return dgoodsSetMapper.delete(id);
    }

    public DgoodsSet queryById(Long id) throws Exception {
        return dgoodsSetMapper.queryById(id);
    }

    public List<DgoodsSet> queryByCondtion(Map map) throws Exception {
        return dgoodsSetMapper.queryByCondtion(map);
    }

    public List<DgoodsSet> queryAll() throws Exception {
        return dgoodsSetMapper.queryAll();
    }

    public List<DgoodsSet> listWithPage(DgoodsSet t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

	public DgoodsSet queryByGoodId(long goodId) {
		return dgoodsSetMapper.queryByGoodId(goodId);
	}


}