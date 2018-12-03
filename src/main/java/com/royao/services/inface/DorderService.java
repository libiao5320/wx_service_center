/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import com.royao.model.Dclear;
import com.royao.model.Dcomplain;
import com.royao.model.Devaluate;
import com.royao.model.Dorder;
import com.royao.model.Order;
import com.royao.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DorderService extends BaseService<Dorder> {

    public List queryByUser(Dorder dorder) throws Exception;
    public Integer queryOrderCountByUserId(Long memId) throws Exception;
    public Map queryDifferentStatusOrderCountByUserId(Long memId) throws Exception;
    void setOrderStatus(Integer  orderState,Long paySn,String paymentTime,String finnshedTime,Long orderId,Long pdAmount)throws SQLException;
    
    
    public List<Dorder> queryByPaySn(Integer orderState,Long paySn) throws SQLException;

    public List<Dorder> getByGoodsdelaytime(Dorder or) throws SQLException;
    
    public List<Dorder> getByTimeId(Dorder or) throws SQLException;
    
    public String commonOrder(Map<String,Object> map) throws SQLException;
    
    public String commonRedOrder(Dorder dorder) throws SQLException;
    
    public String getConsumptionCode();
    
    public List<Dorder> queryAllOrderBy(Order or) throws SQLException;
    
    public Long queryAllOrderByCount(Order or) throws SQLException;
    
    //查询未付余额
    public List<Dorder>DqueryAllOrderBy(Dorder or) throws SQLException; 
    public  Long DqueryAllOrderByCount(Dorder or)throws SQLException;
    
    //退款申请
    public List<Dorder>TqueryAllOrderBy(Dorder or)throws SQLException;
    public Long TqueryAllOrderByCount(Dorder or)throws SQLException;
    //根据id修改订单状态
    public int updateOrderStateByOrderId(Dorder or)throws SQLException;
    
    //处理退款请求
    public List<Map> RqueryAllOrderByCount(Dorder or)throws SQLException;


    //评论
    public boolean comment(Devaluate devaluate, List l) throws Exception;
    public boolean complain(Dcomplain dcomplain) throws Exception;
    
    //跑批过期
	public Integer orderOverdue(Integer overdueTime);
	public Integer listWithPageCount(Dorder order);

    public boolean updateSettlementState (Dorder dorder) throws Exception;
	public Dorder queryByIdTob(Long id);
	public List<Map<?,?>> orderByClearPage(Dclear clear);
	public Integer orderByClearPageCount(Dclear clear);
	public Integer countUnconsumeOrder(Dorder order);

    public boolean clearOrder(Map params) throws Exception;


}