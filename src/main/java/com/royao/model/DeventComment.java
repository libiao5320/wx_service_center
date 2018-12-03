package com.royao.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.royao.commons.enums.YN;
import com.royao.model.base.BaseEntity;

public class DeventComment extends BaseEntity implements java.io.Serializable{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4569297709157097984L;
	//alias
	public static final String TABLE_ALIAS = "DeventComment";
	public static final String ID = "id";
	public static final String EVENT_ID = "活动ID";
	public static final String MEMBER_ID = "用户ID";
	public static final String CONTENT = "评论类容";
	public static final String GRADE = "评论等级";
	public static final String IS_SHOW = "是否显示，Y-显示，N-不显示";
	public static final String CREATE_TIME = "评论时间";
	
	private Long id;
	
	private Long eventId;
	
	private Long memberId;
	
	private String content;
	
	private Integer grade;
	
	private YN isShow;
	
	private Date createTime;
	
	private String strCreateTime;
	
	private List<DeventCommentImage> imageList;
	
	private Dmember member;
	
	public Dmember getMember() {
		return member;
	}

	public void setMember(Dmember member) {
		this.member = member;
	}

	public List<DeventCommentImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<DeventCommentImage> imageList) {
		this.imageList = imageList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public YN getIsShow() {
		return isShow;
	}

	public void setIsShow(YN isShow) {
		this.isShow = isShow;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
}
