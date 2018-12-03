/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.model.base.BaseEntity;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Dcomplain extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "Dcomplain";
    public static final String ALIAS_ID = "id";
    public static final String ALIAS_ORDER_ID = "订单ID";
    public static final String ALIAS_MEMBER_ID = "用户ID";
    public static final String ALIAS_REASON = "申请原由";
    public static final String ALIAS_STATUS = "状态，handled-已解决，handling-处理中";
    public static final String ALIAS_REPLY = "回复买家（买家、商家可见）";
    public static final String ALIAS_HANDLE = "处理详情：（商家可见）";
    public static final String ALIAS_REMARK = "备注";
    public static final String ALIAS_CREATE_TIME = "申请时间";
    public static final String ALIAS_UPDATE_TIME = "处理时间";
    public static final String ALIAS_UPDATE_BY = "updateBy";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private Long orderId;

    private Long memberId;

    private String reason;

    private String status;

    private String reply;

    private String handle;

    private String remark;

    private Date createTime;
    private String createTimeStr;

    private Date updateTime;
    private String updateTimeStr;

    private String updateBy;
    //columns END
    
    private Long storeId;
    
    //投诉对应的订单
    private Dorder order;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getCreateTimeStr() {
		if(createTime != null){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			createTimeStr = sd.format(createTime);
		}
    	return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getUpdateTimeStr() {
		if(updateTime != null){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			updateTimeStr = sd.format(updateTime);
		}
    	return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public Dcomplain() {
    }

    public Dcomplain(
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

    public void setOrderId(Long value) {
        this.orderId = value;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setMemberId(Long value) {
        this.memberId = value;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setReason(String value) {
        this.reason = value;
    }

    public String getReason() {
        return this.reason;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public String getStatus() {
        return this.status;
    }

    public void setReply(String value) {
        this.reply = value;
    }

    public String getReply() {
        return this.reply;
    }

    public void setHandle(String value) {
        this.handle = value;
    }

    public String getHandle() {
        return this.handle;
    }

    public void setRemark(String value) {
        this.remark = value;
    }

    public String getRemark() {
        return this.remark;
    }


    public void setCreateTime(Date value) {
        this.createTime = value;
    }

    public Date getCreateTime() {
        return this.createTime;
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

    public Dorder getOrder() {
		return order;
	}

	public void setOrder(Dorder order) {
		this.order = order;
	}

}

