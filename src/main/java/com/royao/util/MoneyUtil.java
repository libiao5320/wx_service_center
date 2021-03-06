package com.royao.util;

import java.util.ArrayList;
import java.util.List;

import com.royao.model.Money;

/**
 * 
 */

/**
 * Created on 2014年12月22日
 * <p>Title:       智企云_[子平台名]_[模块名]/p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * <p>Copyright:   Copyright (c) 2014</p>
 * <p>Company:     长沙亿网电子商务有限公司</p>
 * @author        沈友军 me@joyphper.net
 * @version        1.0
*/
public class MoneyUtil {
    /**
     * 获取元到分
     * @param dollar
     * @return
     */
    public static Long getDollarToCent(String dollar) {
        if (dollar == null || dollar.equals("")) {
            dollar = "0.00";
        }
        Money money = new Money(dollar);
        return money.getCent();
    }

    /**
     * 获取分到元
     * @param dollar
     * @return
     */
    public static String getCentToDollar(Long cent) {
        if (cent == null) {
            cent = 0L;
        }
        Money m = new Money();
        m.setCent(cent);
        return m.toString();
    }
    
    public static List<Long> randomMoney(Long amount,int quantity) {
    	List<Long> moneys = new ArrayList<Long>();
		for(int i=0;i<quantity-1;i++){
			long t = (long) ((Math.random()*amount/(quantity-i)) +1);
			moneys.add(t);
			amount = amount-t;
		}
		moneys.add(amount);
		return moneys;
	}
    
    public static void main(String[] args) {
		System.out.println(MoneyUtil.randomMoney((long) 1000, 20));
	}
}
