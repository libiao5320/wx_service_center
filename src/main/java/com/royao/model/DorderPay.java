/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.model.base.BaseEntity;

import java.util.Date;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DorderPay extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "DorderPay";
    public static final String ALIAS_ID = "支付表id Sequence取值";
    public static final String ALIAS_PD_AMOUNT = "预存款支付金额";
    public static final String ALIAS_COUPON_AMOUNT = "优惠劵支付金额";
    public static final String ALIAS_REDPACKETS_AMOUNT = "红包支付金额";
    public static final String ALIAS_ADD_TIME = "支付时间";
    public static final String ALIAS_STATE = "状态1未支付 2 已支付";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private Long pdAmount;

    private Long couponAmount;

    private Long redpacketsAmount;

    private Date addTime;

    private Integer state;
    //columns END

    public DorderPay() {
    }

    public DorderPay(
            Long id
    ) {
        this.id = id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setPdAmount(Long value) {
        this.pdAmount = value;
    }

    public Long getPdAmount() {
        return this.pdAmount;
    }

    public void setCouponAmount(Long value) {
        this.couponAmount = value;
    }

    public Long getCouponAmount() {
        return this.couponAmount;
    }

    public void setRedpacketsAmount(Long value) {
        this.redpacketsAmount = value;
    }

    public Long getRedpacketsAmount() {
        return this.redpacketsAmount;
    }

    public void setAddTime(Date value) {
        this.addTime = value;
    }

    public Date getAddTime() {
        return this.addTime;
    }

    public void setState(Integer value) {
        this.state = value;
    }

    public Integer getState() {
        return this.state;
    }

}

