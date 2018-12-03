/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.model;

import com.royao.model.base.BaseEntity;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DtechieEvaluateImage extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "DtechieEvaluateImage";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_EVALUATE_ID = "评价ID";
	public static final String ALIAS_IMG = "图片存放路径";
	public static final String ALIAS_IS_SHOW = "是否显示，Y-显示，N-不显示";
	public static final String ALIAS_CREATE_TIME = "上传时间";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Long id;
	 
	private java.lang.Long evaluateId;
	 
	private java.lang.String img;
	 
	private java.lang.String isShow;
	 
	private java.util.Date createTime;
	//columns END

	public DtechieEvaluateImage(){
	}

	public DtechieEvaluateImage(
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
	public void setEvaluateId(java.lang.Long value) {
		this.evaluateId = value;
	}
	
	public java.lang.Long getEvaluateId() {
		return this.evaluateId;
	}
	public void setImg(java.lang.String value) {
		this.img = value;
	}
	
	public java.lang.String getImg() {
		return this.img;
	}
	public void setIsShow(java.lang.String value) {
		this.isShow = value;
	}
	
	public java.lang.String getIsShow() {
		return this.isShow;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
}

