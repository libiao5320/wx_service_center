/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.model;

import java.text.SimpleDateFormat;
import java.util.List;

import com.royao.commons.enums.YN;
import com.royao.model.base.BaseEntity;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DtechieEvaluate extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "DtechieEvaluate";
	public static final String ALIAS_ID = "主键id";
	public static final String ALIAS_TECHIE_ID = "技师id";
	public static final String ALIAS_MEMBER_ID = "会员id";
	public static final String ALIAS_GOODS_ID = "商品id";
	public static final String ALIAS_ORDER_ID = "订单id";
	public static final String ALIAS_GRADE = "评价等级";
	public static final String ALIAS_DETAIL = "评价详情";
	public static final String ALIAS_IS_SHOW = "是否显示";
	public static final String ALIAS_CREATE_TIME = "评价时间";
	public static final String ALIAS_UPDATE_TIME = "修改评价时间";
	public static final String ALIAS_UPDATE_BY = "修改人";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Long id;
	
	private java.lang.Long techieId;
	
	private java.lang.Long memberId;
	
	private java.lang.Long goodsId;
	
	private java.lang.Long orderId;
	
	private java.lang.Integer grade;
	
	private java.lang.String detail;
	
	private YN isShow;
	
	private java.util.Date createTime;
	
	private String createTimeStr;
	
	private java.util.Date updateTime;
	
	private String updateBy;
	//columns END

	private Dmember member;
	
	private List<DtechieEvaluateImage> evaluateImageList;
	
	public Dmember getMember() {
		return member;
	}

	public void setMember(Dmember member) {
		this.member = member;
	}

	public List<DtechieEvaluateImage> getEvaluateImageList() {
		return evaluateImageList;
	}

	public void setEvaluateImageList(List<DtechieEvaluateImage> evaluateImageList) {
		this.evaluateImageList = evaluateImageList;
	}

	public DtechieEvaluate(){
	}

	public DtechieEvaluate(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setTechieId(java.lang.Long value) {
		this.techieId = value;
	}
	
	public java.lang.Long getTechieId() {
		return this.techieId;
	}
	public void setMemberId(java.lang.Long value) {
		this.memberId = value;
	}
	
	public java.lang.Long getMemberId() {
		return this.memberId;
	}
	public void setGoodsId(java.lang.Long value) {
		this.goodsId = value;
	}
	
	public java.lang.Long getGoodsId() {
		return this.goodsId;
	}
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}
	public void setGrade(java.lang.Integer value) {
		this.grade = value;
	}
	
	public java.lang.Integer getGrade() {
		return this.grade;
	}
	public void setDetail(java.lang.String value) {
		this.detail = value;
	}
	
	public java.lang.String getDetail() {
		return this.detail;
	}
	public void setIsShow(YN isShow) {
		this.isShow = isShow;
	}
	
	public YN getIsShow() {
		return this.isShow;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public String getCreateTimeStr() {
		if(createTime != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			createTimeStr = sdf.format(createTime);
		}
		
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	public String getUpdateBy() {
		return this.updateBy;
	}
}

