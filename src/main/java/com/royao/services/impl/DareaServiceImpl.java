/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DareaMapper;
import com.royao.model.Darea;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("areaService")
public class DareaServiceImpl extends BaseServiceImpl<Darea> implements DareaService {

    @Autowired
    private DareaMapper dareaMapper;


    public int save(Darea darea) throws Exception {
//        return dareaMapper.save(darea);
        return 0;
    }

    public int update(Darea darea) throws Exception {
//        return dareaMapper.update(darea);
        return 0;
    }

    public int delete(Long id) throws Exception {
//       return dareaMapper.delete(id);
        return 0;
    }

    public Darea queryById(Long id) throws Exception {

        return this.dareaMapper.queryById(id);
        //			 return null;
    }

    public List<Darea> queryByCondtion(Map map) throws Exception {
//        return dareaMapper.queryByCondtion(map);
        return null;
    }

    public List<Darea> queryAll() throws Exception {
        return dareaMapper.queryAll();
    }

    public List<Darea> listWithPage(Darea darea) throws Exception {
        return dareaMapper.listWithPage(darea);
    }


    public List queryByDeep(Integer deep) throws Exception {
        return dareaMapper.queryByDeep(deep);
    }

	public List<Integer> getByName(String name) throws Exception {
		return this.dareaMapper.getByName(name);
	}

	public List<Darea> queryByAreaParentId(int id) {
		return this.dareaMapper.queryByAreaParentId(id);
	}
}