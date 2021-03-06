/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.royao.model.base.BaseEntity;




import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Devaluate extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "Devaluate";
    public static final String ALIAS_ID = "id";
    public static final String ALIAS_MEMBER_ID = "用户ID";
    public static final String ALIAS_GOODS_ID = "商品ＩＤ";
    public static final String ALIAS_ORDER_ID = "订单ID";
    public static final String ALIAS_GRADE = "评价等级";
    public static final String ALIAS_DETAIL = "评价详情";
    public static final String ALIAS_IS_SHOW = "是否显示，Y-显示，N-不显示";
    public static final String ALIAS_CREATE_TIME = "评价时间";
    public static final String ALIAS_UPDATE_TIME = "updateTime";
    public static final String ALIAS_UPDATE_BY = "updateBy";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private String evaluateType;
    
    private Long memberId;

    private Long goodsId;

    private Long orderId;
    
    private Long storeId;

    private Integer grade;

    private String detail;

    private String isShow;
    private String isAnonymous;

    private Date createTime;
    
    private String strCreateTime;

    private Date updateTime;
    
    private String strUpdateTime;


    private String updateBy;
    //columns END



    private Dmember member;	//评价的用户信息
    
    List<DevaluateImage> imageList;//评论的图片列表
    
    private Dorder order;
    

	public Dorder getOrder() {
		return order;
	}

	public void setOrder(Dorder order) {
		this.order = order;
	}

	public Dmember getMember() {
		return member;
	}

	public void setMember(Dmember member) {
		this.member = member;
	}

	public List<DevaluateImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<DevaluateImage> imageList) {
		this.imageList = imageList;
	}

	public Devaluate() {
    }

    public Devaluate(
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

    public void setMemberId(Long value) {
        this.memberId = value;
    }

    public Long getMemberId() {
        return this.memberId;
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

    public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public void setGrade(Integer value) {
        this.grade = value;
    }

    public Integer getGrade() {
        return this.grade;
    }

    public void setDetail(String value) {
        this.detail = value;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setIsShow(String value) {
        this.isShow = value;
    }

    public String getIsShow() {
        return this.isShow;
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

	public String getStrCreateTime() {
		if(createTime != null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			strCreateTime=sdf.format(createTime); 
		}
		return strCreateTime;
	}

	public void setStrCreateTime(String strCreateTime) {
		this.strCreateTime = strCreateTime;
	}

	public String getStrUpdateTime() {
		if(updateTime != null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			strUpdateTime=sdf.format(updateTime); 
		}
		return strUpdateTime;
	}

	public void setStrUpdateTime(String strUpdateTime) {
		this.strUpdateTime = strUpdateTime;
	}

	public String getEvaluateType() {
		return evaluateType;
	}

	public void setEvaluateType(String evaluateType) {
		this.evaluateType = evaluateType;
	}

    public String getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(String isAnonymous) {
        this.isAnonymous = isAnonymous;
    }
}

