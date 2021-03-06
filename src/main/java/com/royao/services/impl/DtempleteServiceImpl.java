/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DtempleteMapper;
import com.royao.model.Dtemplete;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DtempleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("templeteService")
public class DtempleteServiceImpl extends BaseServiceImpl<Dtemplete> implements DtempleteService {

    @Autowired
    private DtempleteMapper dtempleteMapper;


    public int save(Dtemplete dtemplete) throws Exception {
        return dtempleteMapper.save(dtemplete);
    }

    public int update(Dtemplete dtemplete) throws Exception {
        return dtempleteMapper.update(dtemplete);
    }

    public int delete(Long id) throws Exception {
        return dtempleteMapper.delete(id);
    }

    public Dtemplete queryById(Long id) throws Exception {
        return dtempleteMapper.queryById(id);
    }

    public List<Dtemplete> queryByCondtion(Map map) throws Exception {
        return dtempleteMapper.queryByCondtion(map);
    }

    public List<Dtemplete> queryAll() throws Exception {
        return dtempleteMapper.queryAll();
    }

    public List<Dtemplete> listWithPage(Dtemplete t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}