/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.Dclear;
import com.royao.model.Dorder;
import com.royao.model.Order;

import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface DorderMapper extends BaseDao<Dorder> {


    public List queryByUser(Dorder dmember) throws SQLException;
    public Integer queryOrderCountByUserId(Long memId) throws SQLException;
    public Map queryDifferentStatusOrderCountByUserId(Long memId) throws SQLException;
    void setOrderStatus(Dorder dorder)throws SQLException;
    
    public List<Dorder> queryByPaySn(Integer orderState,Long paySn)throws SQLException;
    
    public List<Dorder> getByGoodsdelaytime(Dorder or) throws SQLException;
    
    public List<Dorder> getByTimeId(Dorder or) throws SQLException;
    
    public List<Dorder> getCountByConsumptionCode(String consumptionCode);
    
    public List<Dorder> queryAllOrderBy(Order or) throws SQLException;
    
    public Long queryAllOrderByCount(Order or) throws SQLException;
    
	//查出用户常用分类
	 public List queryMostClass(Long memId) throws SQLException;
	 
	 
	 //查询未付余款
	 public Long DqueryAllOrderByCount(Dorder or)throws SQLException;
	 public List<Dorder> DqueryAllOrderBy(Dorder or) throws SQLException;
	 
	 //退款申请
	 public Long TqueryAllOrderByCount(Dorder or)throws SQLException;
	 public List<Dorder>TqueryAllOrderBy(Dorder or)throws SQLException;
	 
	 //处理退款申请
	 public List<Map> RqueryAllOrderByCount(Dorder or)throws SQLException;


    public int updateOrderStateByOrderId(Dorder dorder) throws SQLException;
	public Integer orderOverdue(Integer overdueTime);
	public Integer listWithPageCount(Dorder order);
	 
    public Integer finishOrder (Dorder dorder) throws SQLException ;
	public Dorder queryByIdTob(Long id);
	public List<Map<?,?>> orderByClearPage(Dclear clear);
	public Integer orderByClearPageCount(Dclear clear);
	public Integer countUnconsumeOrder(Dorder order);


    public Integer clearOrder(Map params) throws SQLException;



}
