/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import com.royao.model.Dgoods;
import com.royao.model.DgoodsSet;
import com.royao.model.GoodImg;
import com.royao.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DgoodsService extends BaseService<Dgoods> {

    public List search(Dgoods dgoods) throws Exception;

    public List getBestEvalGoods(double x ,double y) throws Exception;
    
    public Dgoods queryByIdByDetail(Long goodsId) throws SQLException;

    public List queryByClass(Long classId) throws Exception;

    public List listWithPageAndConditon(Map params) throws Exception;
    
    public List<Dgoods> listWithPageBy(Map params) throws Exception;
    
    public int queryCountBy(Map params) throws Exception;

    public int batchAddGood(List list ,List<String> imgs, DgoodsSet dgoodSet) throws Exception;


    public boolean updateGoodsSalenumJia(Dgoods dgoods);

	public int updateGood(List goodList);

	public List getImgsById(long parseLong);

	public int deleteImgByGoodId(Integer goodsId);

	public int addImg(GoodImg goodImg);

	public int countByStoreAnd(Map params);

	public List<Map> queryByStoreAnd(Map params);
}