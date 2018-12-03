/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DcollectMapper;
import com.royao.model.Dcollect;
import com.royao.model.Dmember;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DcollectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Service("collectService")
public class DcollectServiceImpl extends BaseServiceImpl<Dcollect> implements DcollectService {

    @Autowired
    private DcollectMapper dcollectMapper;


    public int save(Dcollect dcollect) throws Exception {
        return dcollectMapper.save(dcollect);
    }

    public int update(Dcollect dcollect) throws Exception {
        return dcollectMapper.update(dcollect);
    }

    public int delete(Long id) throws Exception {
        return dcollectMapper.delete(id);
    }

    public Dcollect queryById(Long id) throws Exception {
        return dcollectMapper.queryById(id);
    }

    public List<Dcollect> queryByCondtion(Map map) throws Exception {
        return dcollectMapper.queryByCondtion(map);
    }

    public List<Dcollect> queryAll() throws Exception {
        return dcollectMapper.queryAll();
    }

    public List<Dcollect> listWithPage(Dcollect t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Cacheable(value = "myCache", key = "#dmember")
    public List queryStoreCollByUserAndType(Dcollect dcollect) throws Exception {
        return dcollectMapper.queryStoreCollByUserAndType(dcollect);
    }

    @Cacheable(value = "myCache", key = "#dmember")
    public List queryGoodCollByUserAndType(Dcollect dcollect) throws Exception {
        return dcollectMapper.queryGoodCollByUserAndType(dcollect);
    }



    public Map queryCountByUserId(Long memId) throws Exception {
        return dcollectMapper.queryCountByUserId(memId);
    }

	public Dcollect insert(Dcollect collect) throws SQLException {
		dcollectMapper.save(collect);
		return collect;
	}

	public List<Dcollect> findList(Dcollect collect) throws SQLException{
		return this.dcollectMapper.findList(collect);
	}
}