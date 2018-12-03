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


public class DgoodsSet extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "DgoodsSet";
    public static final String ALIAS_SET_ID = "商品设置表id";
    public static final String ALIAS_GOODS_ID = "商品id";
    public static final String ALIAS_BEGIN_TIME = "销售开始时间";
    public static final String ALIAS_END_TIME = "销售结束时间";
    public static final String ALIAS_PERIOD_OF_VALIDITY = "有效期";
    public static final String ALIAS_STATE = "状态1待上架2已上架3已下架";
    public static final String ALIAS_TECHNICIAN_ID = "私人健康师";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Integer setId;

    private Integer goodsId;

    private Date beginTime;

    private Date endTime;

    private Date periodOfValidity;

    private Integer state;

    private Integer technicianId;
    //columns END

    public DgoodsSet() {
    }

    public DgoodsSet(
            Integer setId
    ) {
        this.setId = setId;
    }

    public void setSetId(Integer value) {
        this.setId = value;
    }

    public Integer getSetId() {
        return this.setId;
    }

    public void setGoodsId(Integer value) {
        this.goodsId = value;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public void setBeginTime(Date value) {
        this.beginTime = value;
    }

    public Date getBeginTime() {
        return this.beginTime;
    }

    public void setEndTime(Date value) {
        this.endTime = value;
    }

    public Date getEndTime() {
        return this.endTime;
    }


    public void setPeriodOfValidity(Date value) {
        this.periodOfValidity = value;
    }

    public Date getPeriodOfValidity() {
        return this.periodOfValidity;
    }

    public void setState(Integer value) {
        this.state = value;
    }

    public Integer getState() {
        return this.state;
    }

    public void setTechnicianId(Integer value) {
        this.technicianId = value;
    }

    public Integer getTechnicianId() {
        return this.technicianId;
    }


}

