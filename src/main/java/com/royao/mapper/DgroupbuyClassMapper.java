/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.DgroupbuyClass;
import com.royao.model.DredpacketsGroupbuy;

import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface DgroupbuyClassMapper extends BaseDao<DgroupbuyClass> {

    public List queryHomeGoodsClass() throws SQLException;

	public List<DgroupbuyClass> findAll(DgroupbuyClass groupbuy);
	public List<DgroupbuyClass> listGoodsClassBy(DgroupbuyClass groupbuy);

    //查询出产品分类的一级类别
    public List queryGoodClassOne() throws Exception;
    //查询出产品分类的二级类别
    public List queryGoodClassTwo() throws Exception;

	public List<DgroupbuyClass> getGroupbuyByParentId(Long classId);

	public Long saveRedpacketsGroupClass(DredpacketsGroupbuy dg);

	public Integer queryAllGoodsClassCount(DgroupbuyClass groupbuy);

	public List queryAllGoodsClass(DgroupbuyClass groupbuy);
    
    
}
