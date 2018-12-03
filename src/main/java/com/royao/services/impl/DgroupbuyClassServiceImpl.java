/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DgroupbuyClassMapper;
import com.royao.mapper.DorderMapper;
import com.royao.model.DgroupbuyClass;
import com.royao.model.DredpacketsGroupbuy;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DgroupbuyClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("groupbuyClassServiceImpl")
public class DgroupbuyClassServiceImpl extends BaseServiceImpl<DgroupbuyClass> implements DgroupbuyClassService {

    @Autowired
    private DgroupbuyClassMapper dgroupbuyClassMapper;
    @Autowired
    private DorderMapper dorderMapper;

    public int save(DgroupbuyClass dgroupbuyClass) throws Exception {
        return dgroupbuyClassMapper.save(dgroupbuyClass);
    }

    public int update(DgroupbuyClass dgroupbuyClass) throws Exception {
        return dgroupbuyClassMapper.update(dgroupbuyClass);
    }

    public int delete(Long id) throws Exception {
        return dgroupbuyClassMapper.delete(id);
    }

    public DgroupbuyClass queryById(Long id) throws Exception {
        return dgroupbuyClassMapper.queryById(id);
    }

    public List<DgroupbuyClass> queryByCondtion(Map map) throws Exception {
        return dgroupbuyClassMapper.queryByCondtion(map);
    }

    public List<DgroupbuyClass> queryAll() throws Exception {
        return dgroupbuyClassMapper.queryAll();
    }

    public List<DgroupbuyClass> listWithPage(DgroupbuyClass t)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


    public List queryHomeGoodsClass() throws Exception {
        return dgroupbuyClassMapper.queryHomeGoodsClass();
    }

	public List<DgroupbuyClass> findAll(DgroupbuyClass groupbuy) {
		return dgroupbuyClassMapper.findAll(groupbuy);
	}
	public List queryMostClass(Long memId) throws Exception {
		return dorderMapper.queryMostClass(memId);
	}

    public List queryGoodClassOne() throws Exception {
        return dgroupbuyClassMapper.queryGoodClassOne();
    }

    public List queryGoodClassTwo() throws Exception {
        return dgroupbuyClassMapper.queryGoodClassTwo();
    }
    
    public List<DgroupbuyClass> listGoodsClassBy(DgroupbuyClass groupbuy) {
    	 return dgroupbuyClassMapper.listGoodsClassBy(groupbuy);
    }

	public List<DgroupbuyClass> getGroupbuyByParentId(Long classId) {
		return dgroupbuyClassMapper.getGroupbuyByParentId(classId);
	}

	public Long saveRedpacketsGroupClass(DredpacketsGroupbuy dg) {
		return dgroupbuyClassMapper.saveRedpacketsGroupClass(dg);
	}

	public Integer queryAllGoodsClassCount(DgroupbuyClass groupbuy)
			throws Exception {
		return this.dgroupbuyClassMapper.queryAllGoodsClassCount(groupbuy);
	}
	
	public List queryAllGoodsClass(DgroupbuyClass groupbuy) {
		return dgroupbuyClassMapper.queryAllGoodsClass(groupbuy);
	}

}