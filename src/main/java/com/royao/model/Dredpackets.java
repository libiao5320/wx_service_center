/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.model.base.BaseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Dredpackets extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "Dredpackets";
    public static final String ALIAS_ID = "主键ID";
    public static final String ALIAS_NAME = "红包名称";
    public static final String ALIAS_TYPE = "红包类型,quota-定额红包，random-随机红包";
    public static final String ALIAS_QUANTITY = "红包数量(个)";
    public static final String ALIAS_SINGLE_AMOUNT = "单个红包金额";
    public static final String ALIAS_AMOUNT = "红包总金额";
    public static final String ALIAS_VALIDITY_TIME = "红包过期时间";
    public static final String ALIAS_MOUNTING_TIME = "上架时间";
    public static final String ALIAS_REDUCE_TIME = "下架时间";
    public static final String ALIAS_STATUS = "状态，on-上架，off-下架，如果该红包已经开始派发，那么在红包下架的时候要将该红包下的所有未使用的子红包进行过期状态的更改";
    public static final String ALIAS_ORDER_BY = "排序,值越小越靠前";
    public static final String ALIAS_REMARK = "红包说明";
    public static final String ALIAS_RECEIVE = "每人领取次数";
    public static final String ALIAS_CREATE_TIME = "创建时间";
    public static final String ALIAS_CREATE_BY = "创建人";
    public static final String ALIAS_UPDATE_TIME = "updateTime";
    public static final String ALIAS_UPDATE_BY = "更新人";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private String name;

    private String type;

    private Integer quantity;

    private Long singleAmount;

    private Long amount;

    private Date validityTime;
    private String strValidityTime;
    
    private Integer sonValidityTime;

    private Date mountingTime;

    private Date reduceTime;

    private String status;

    private Integer orderBy;

    private String remark;

    private Integer receive;
    
    private Integer receiveNumber;
    
    private Integer alreadyUsed;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;
    
    private String purpose;

    private Long  minAmount;
    private Long  maxAmount;
    
    private String storeName;
    //columns END

    public Dredpackets() {
    }

    public Dredpackets(
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

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getType() {
        return this.type;
    }

    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setSingleAmount(Long value) {
        this.singleAmount = value;
    }

    public Long getSingleAmount() {
        return this.singleAmount;
    }

    public void setAmount(Long value) {
        this.amount = value;
    }

    public Long getAmount() {
        return this.amount;
    }

    public Integer getSonValidityTime() {
		return sonValidityTime;
	}

	public void setSonValidityTime(Integer sonValidityTime) {
		this.sonValidityTime = sonValidityTime;
	}

	public void setValidityTime(Date value) {
        this.validityTime = value;
    }

    public Date getValidityTime() {
        return this.validityTime;
    }


    public String getStrValidityTime() {
    	if(validityTime != null){
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		strValidityTime = sdf.format(validityTime);
    	}
    	
		return strValidityTime;
	}

	public void setStrValidityTime(String strValidityTime) {
		this.strValidityTime = strValidityTime;
	}

	public void setMountingTime(Date value) {
        this.mountingTime = value;
    }

    public Date getMountingTime() {
        return this.mountingTime;
    }


    public void setReduceTime(Date value) {
        this.reduceTime = value;
    }

    public Date getReduceTime() {
        return this.reduceTime;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public String getStatus() {
        return this.status;
    }

    public void setOrderBy(Integer value) {
        this.orderBy = value;
    }

    public Integer getOrderBy() {
        return this.orderBy;
    }

    public void setRemark(String value) {
        this.remark = value;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setReceive(Integer value) {
        this.receive = value;
    }

    public Integer getReceive() {
        return this.receive;
    }

    public Integer getReceiveNumber() {
		return receiveNumber;
	}

	public void setReceiveNumber(Integer receiveNumber) {
		this.receiveNumber = receiveNumber;
	}

	public Integer getAlreadyUsed() {
		return alreadyUsed;
	}

	public void setAlreadyUsed(Integer alreadyUsed) {
		this.alreadyUsed = alreadyUsed;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}

