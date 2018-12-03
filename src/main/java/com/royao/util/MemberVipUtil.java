package com.royao.util;

import com.royao.model.Dgoods;

/**
 * 会员等级获取公共类
 * @author yangx
 * @className 
 * @date 2016年1月13日下午2:50:40
 */
public class MemberVipUtil {
	
    /**
     * 根据会员等级 获取会员产品金额
     * @param dollar
     * @return
     */
    public static Long getMemberGoodsvipPrice(Dgoods dgoods,int vipRankId) {

    	Long vipPrice=dgoods.getGoodsPrice();//基础价格
    	if(vipRankId==0){
    		vipPrice=dgoods.getGoodsVip0Price();
    	}else if (vipRankId==1){
    		vipPrice=dgoods.getGoodsVip1Price();
    	}else if (vipRankId==2){
    		vipPrice=dgoods.getGoodsVip2Price();
    	}else if (vipRankId==3){
    		vipPrice=dgoods.getGoodsVip3Price();
    	}else if(vipRankId==4){
    		vipPrice=dgoods.getGoodsVip4Price();
    	}
        return vipPrice;
    }

}
