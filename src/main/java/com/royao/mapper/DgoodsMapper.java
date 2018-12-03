/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dgoods;
import com.royao.model.GoodImg;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface DgoodsMapper extends BaseDao<Dgoods> {


    public List search(Dgoods dgoods) throws SQLException;

    public List getBestEvalGoods( Map positionMap ) throws SQLException;
    
    public Dgoods queryByIdByDetail(long goodsId) throws SQLException;

    public List queryByClass( Long classId) throws SQLException;

    public List listWithPageAndConditon(Map params) throws SQLException;
    
    public List<Dgoods> listWithPageBy(Map params) throws SQLException;
    
    public int queryCountBy(Map params) throws SQLException;

    public void updateGoodsSalenumJia(Dgoods dgoods) throws SQLException;


    public int addImg(GoodImg goodImg) throws SQLException;

	public List getImgsById(long parseLong);

	public int deleteImgByGoodId(Integer goodsId);

	public int countByStoreAnd(Map params);

	public List<Map> queryByStoreAnd(Map params);




}
