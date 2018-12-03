/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.commons.enums.YN;
import com.royao.model.base.BaseEntity;

import java.util.*;



/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DeventCommentImage extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "DeventImage";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_EVENT_ID = "活动ID";
	public static final String ALIAS_IMG_PATH = "imgPath";
	public static final String ALIAS_IS_SHOW = "是否显示，Y-是，N-为否";
	public static final String ALIAS_CREATE_TIME = "上传时间";

	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;

	private Long eventCommentId;

	private String imgPath;

	private YN isShow;
	
	private Date createTime;
	//columns END

	public DeventCommentImage(){
	}

	public DeventCommentImage(
		Long id
	){
		this.id = id;
	}

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Long getEventCommentId() {
		return eventCommentId;
	}

	public void setEventCommentId(Long eventCommentId) {
		this.eventCommentId = eventCommentId;
	}

	public void setImgPath(String value) {
		this.imgPath = value;
	}
	
	public String getImgPath() {
		return this.imgPath;
	}
	
	public YN getIsShow() {
		return isShow;
	}

	public void setIsShow(YN isShow) {
		this.isShow = isShow;
	}

	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}


}

