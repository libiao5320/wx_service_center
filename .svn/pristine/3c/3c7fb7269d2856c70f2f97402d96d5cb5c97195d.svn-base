package com.royao.services.impl;

import com.royao.mapper.DclearMapper;
import com.royao.model.Dclear;
import com.royao.model.Dorder;
import com.royao.model.Dstore;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DclearService;
import com.royao.services.inface.DkitingService;
import com.royao.services.inface.DorderService;
import com.royao.services.inface.DstoreService;
import com.royao.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by libia on 2016/2/23.
 */
@Service("DclearServiceImpl")
public class DclearServiceImpl extends BaseServiceImpl<Dclear> implements DclearService {

    @Autowired
    private DclearMapper dclearMapper;

    @Autowired
    private DkitingService dkitingService;
    @Autowired
    private DstoreService dstoreService;

    @Autowired
    private DorderService dorderService;

    public int save(Dclear dclear) throws Exception {
        return dclearMapper.save(dclear);
    }

    public int update(Dclear dclear) throws Exception {
        return dclearMapper.update(dclear);
    }

    public int delete(Long id) throws Exception {
        return dclearMapper.delete(id);
    }

    public Dclear queryById(Long id) throws Exception {
        return dclearMapper.queryById(id);
    }

    public List<Dclear> queryByCondtion(Map map) throws Exception {
        return dclearMapper.queryByCondtion(map);
    }

    public List<Dclear> queryAll() throws Exception {
        return dclearMapper.queryAll();
    }

    public List<Dclear> listWithPage(Dclear dclear) throws Exception {
        return dclearMapper.listWithPage(dclear);
    }


    /**
     * 添加
     * @param params
     * @return
     * @throws Exception
     */
    public boolean addClear(Map params) throws Exception {


        boolean flag = false;
        if ( null !=  params.get("storeId")) {
            String storeId = (String) params.get("storeId");
            String clearUser = null;

            String cycleTime = null;

            if ( null != params.get("clearUser") )
                clearUser = (String) params.get("clearUser");



            if ( null != params.get("cycleTime") )
                cycleTime = (String) params.get("cycleTime");

            Dstore dstore  =  dstoreService.queryDetailById(Long.valueOf(storeId));
            List  l  =  dkitingService.queryClear(params);

            if( null != l && l.size() > 0 ) {
                Dclear dclear = new Dclear();

                Map m = (Map) l.get(0);
                dclear.setStoreId(dstore.getStoreId());
                dclear.setStoreName(dstore.getStoreName());
                dclear.setClearUser(Long.valueOf(clearUser));
                dclear.setStoreConfirm(0);
                dclear.setClearState(-1);
                dclear.setCycleTime(cycleTime);
                dclear.setCreateTime(DateUtil.format("yyyy-MM-dd"));
                dclear.setSaleFee(Long.valueOf(Double.valueOf("" + m.get("salePrice")).longValue()));
                dclear.setClearFee(Long.valueOf(Double.valueOf("" + m.get("unClear")).longValue()));
                dclear.setSeriNo(Long.valueOf(getDclearNum()));
                if ( dclearMapper.save(dclear) > 0 )
                {

                    List ll = dkitingService.queryClearDetailByStoreId(params);


                    for( int i = 0  ; i< ll.size() ; i++ )
                    {

                        Map mm = (Map) ll.get(i);

                        Integer orderId = (Integer) mm.get("orderId");


                        Dorder dorder  =dorderService.queryById(Long.valueOf(orderId));

                        dorder.setSettlementState(1);

                        dorderService.updateSettlementState(dorder);

                        Map addMap = new HashMap();
                        addMap.put("orderId",orderId);
                        addMap.put("clearId",dclear.getId());
                        dclearMapper.addClearOrder(addMap);

                    }

                    flag = true;

                }
            }



        }

         return flag;
    }

    private String getDclearNum() {
        int r1 = (int) (Math.random() * (10));// 产生2个0-9的随机数
        int r2 = (int) (Math.random() * (10));
        long now = System.currentTimeMillis();// 一个13位的时间戳
        String paymentID = String.valueOf(r1) + String.valueOf(r2) + String.valueOf(now);// 订单ID
        return paymentID;

    }


    public List queryClear(Map map) throws Exception {
        return dclearMapper.queryClear(map);
    }

    public Dclear dealClear(Map map) throws Exception {
        return dclearMapper.dealClear(map);
    }

    public Integer queryClearCount(Map map) throws Exception {
        return dclearMapper.queryClearCount(map);
    }

	public Integer listWithPageCount(Dclear clear) {
		return this.dclearMapper.listWithPageCount(clear);
	}

	public Integer countUnClear(Dclear clear) {
		return this.dclearMapper.countUnClear(clear);
	}

    public List queryClearOrder(Map params) throws Exception {
        return dclearMapper.queryClearOrder(params);
    }

    public Integer queryClearOrderCount(Map params) throws Exception
    {
        return dclearMapper.queryClearOrderCount(params);
    }

    public boolean saveDealClear(Dclear dclear) throws Exception {
        boolean flag = false;

        if ( dclear .getClearState() ==  1) {
            Map params = new HashMap();
            params.put("clearId",dclear.getId());
            List  l   =  dclearMapper.queryClearOrder(params);


            Date clearTime = new Date();
            if ( null !=  l && l.size() > 0 )
            {
                for (int i = 0 ; i < l.size() ; i++)
                {
                    Map m  = (Map) l .get(i);
                    Map mm = new HashMap();
                    mm.put("orderId" , m.get("orderId"));
                    mm.put("clearTime" , clearTime);
                    this.dorderService.clearOrder(mm);
                }


            }

        }

        flag = dclearMapper.saveDealClear(dclear) > 0;
        return flag;
    }


}
