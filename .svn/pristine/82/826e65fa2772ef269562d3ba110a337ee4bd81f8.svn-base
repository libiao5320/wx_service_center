/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DvipMapper;
import com.royao.model.Dvip;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DvipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("vipServiceImpl")
public class DvipServiceImpl extends BaseServiceImpl<Dvip> implements DvipService {

    @Autowired
    private DvipMapper dvipMapper;


    public int save(Dvip dvip) throws Exception {
        return dvipMapper.save(dvip);
    }

    public int update(Dvip dvip) throws Exception {
        return dvipMapper.update(dvip);
    }

    public int delete(Long id) throws Exception {
        return dvipMapper.delete(id);
    }

    public Dvip queryById(Long id) throws Exception {
        return dvipMapper.queryById(id);
    }

    public List<Dvip> queryByCondtion(Map map) throws Exception {
        return dvipMapper.queryByCondtion(map);
    }

    public List<Dvip> queryAll() throws Exception {
        return dvipMapper.queryAll();
    }

    public List<Dvip> listWithPage(Dvip t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


    public Dvip queryByGreade(int greadeId) throws Exception {
        return dvipMapper.queryByGreade(greadeId);
    }

	public int updateRequireById(Dvip vip) {
		return dvipMapper.updateRequireById(vip);
	}
}