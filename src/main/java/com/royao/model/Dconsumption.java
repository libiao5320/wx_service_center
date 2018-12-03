/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.model.base.BaseEntity;


import java.util.*;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Dconsumption extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "Dconsumption";
    public static final String ALIAS_ID = "id";
    public static final String ALIAS_GOODS_ID = "商品ID";
    public static final String ALIAS_ORDER_ID = "订单ID";
    public static final String ALIAS_CODE = "券码";
    public static final String ALIAS_VALIDITY_TIME = "过期时间";
    public static final String ALIAS_STATUS = "状态,unuse-未使用，used-已使用，expired-已过期";
    public static final String ALIAS_CREATE_TIME = "createTime";
    public static final String ALIAS_CREATE_BY = "createBy";
    public static final String ALIAS_UPDATE_TIME = "如果状态为已使用，则为使用时间，如果状态为已过期，则为过期时间";
    public static final String ALIAS_UPDATE_BY = "updateBy";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private Long goodsId;

    private Long orderId;

    private String code;

    private Date validityTime;

    private String status;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;
    
    private Long memberId;
    
    private Dgoods  goods;
    //columns END

    public Dconsumption() {
    }

    public Dconsumption(
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

    public void setGoodsId(Long value) {
        this.goodsId = value;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public void setOrderId(Long value) {
        this.orderId = value;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getCode() {
        return this.code;
    }


    public void setValidityTime(Date value) {
        this.validityTime = value;
    }

    public Date getValidityTime() {
        return this.validityTime;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public String getStatus() {
        return this.status;
    }


    public void setCreateTime(Date value) {
        this.createTime = value;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateBy(String value) {
        this.createBy = value;
    }

    public String getCreateBy() {
        return this.createBy;
    }


    public void setUpdateTime(Date value) {
        this.updateTime = value;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateBy(String value) {
        this.updateBy = value;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

	public Dgoods getGoods() {
		return goods;
	}

	public void setGoods(Dgoods goods) {
		this.goods = goods;
	}
}

