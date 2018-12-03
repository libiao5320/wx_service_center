/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DtopmanMapper;
import com.royao.model.Dtopman;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DtopmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("topmanServiceImpl")
public class DtopmanServiceImpl extends BaseServiceImpl<Dtopman> implements DtopmanService {

    @Autowired
    private DtopmanMapper dtopmanMapper;


    public int save(Dtopman dtopman) throws Exception {
        return dtopmanMapper.save(dtopman);
    }

    public int update(Dtopman dtopman) throws Exception {
        return dtopmanMapper.update(dtopman);
    }

    public int delete(Long id) throws Exception {
        return dtopmanMapper.delete(id);
    }

    public Dtopman queryById(Long id) throws Exception {
        return dtopmanMapper.queryById(id);
    }

    public List<Dtopman> queryByCondtion(Map map) throws Exception {
        return dtopmanMapper.queryByCondtion(map);
    }

    public List<Dtopman> queryAll() throws Exception {
        return dtopmanMapper.queryAll();
    }

    public List<Dtopman> listWithPage(Dtopman t) throws Exception {
        return this.dtopmanMapper.listWithPage(t);
    }

	public Integer listWithPageCount(Dtopman topman) {
		return this.dtopmanMapper.listWithPageCount(topman);
	}


}