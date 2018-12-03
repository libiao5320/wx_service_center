/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import com.royao.model.DgroupbuyClass;
import com.royao.services.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DgroupbuyClassService extends BaseService<DgroupbuyClass> {

        public List queryHomeGoodsClass() throws Exception;
		public List<DgroupbuyClass> findAll(DgroupbuyClass groupbuy);
		//p端产品分类设置中查所有产品
		public List  queryAllGoodsClass(DgroupbuyClass groupbuy);
		//查出用户常用分类
		public List queryMostClass(Long memId) throws Exception;

		
		//查询出产品分类的一级类别
		public List queryGoodClassOne() throws Exception;
		//查询出产品分类的二级类别
		public List queryGoodClassTwo() throws Exception;
		public List<DgroupbuyClass> getGroupbuyByParentId(Long classId);
//		public DgroupbuyClass getGroupbuyByParentId (Long id) throws Exception;
		public Integer queryAllGoodsClassCount(DgroupbuyClass groupbuy) throws Exception;
		public List<DgroupbuyClass> listGoodsClassBy(DgroupbuyClass groupbuy);
}