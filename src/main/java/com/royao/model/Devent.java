/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.model.base.BaseEntity;
import com.royao.util.MoneyUtil;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Devent extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Devent";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_STORE_ID = "承办方ID";
	public static final String ALIAS_AREAID1 = "地区ID1";
	public static final String ALIAS_AREAID2 = "地区ID2";
	public static final String ALIAS_NAME = "活动名称";
	public static final String ALIAS_IMG = "活动缩略图";
	public static final String ALIAS_PROFILE = "活动简介";
	public static final String ALIAS_INTRODUCE = "活动介绍";
	public static final String ALIAS_QUOTA = "限额人数";
	public static final String ALIAS_ENROLL_START_TIME = "报名开始时间";
	public static final String ALIAS_ENROLL_END_TIME = "报名结束时间";
	public static final String ALIAS_ENROLL_OFF_TIME = "报名下架时间";
	public static final String ALIAS_EVENT_TIME = "eventTime";
	public static final String ALIAS_ADDRESS = "活动地点";
	public static final String ALIAS_LONGITUDE = "活动地点的具体经度信息";
	public static final String ALIAS_LATITUDE = "活动地点的具体纬度信息";
	public static final String ALIAS_STATUS = "活动状态，on-上架，off-下架";
	public static final String ALIAS_EXAMINE_STATUS = "审核状态，pass-通过，unpass-未通过，passing-待审核";
	public static final String ALIAS_EXAMINE_RESULT = "审核结果，一般在未通过审核的时候用";
	public static final String ALIAS_ENTRYFEE = "报名费";
	public static final String ALIAS_ORDER_BY = "排序，值越小越靠前";
	public static final String ALIAS_URL = "自定义跳转页";
	public static final String ALIAS_CREATE_TIME = "活动创建时间";
	public static final String ALIAS_CREATE_BY = "创建人";
	public static final String ALIAS_UPDATE_TIME = "活动更新时间";
	public static final String ALIAS_UPDATE_BY = "活动更新人";
	
    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private Long storeId;
    
    private String storeName;//店铺名称

	private String introduce;

    private Long areaid1;

    private Darea area1;

    private Long areaid2;

    private Darea area2;

    private String name;
    
    private String eventKey;

    private String img;

    private String profile;

    private Integer quota;
    
    private Integer enrollNum;//报名数量

    private Date enrollStartTime;

    private Date enrollEndTime;
	
	private String entryfeeDollar;

    private Date enrollOffTime;

    private Date eventTime;
    
    private String strEventTime;

    private String address;

    private String longitude;

	private List<DeventImage> imageList;//活动轮播图片
	
	private List<DeventComment> commentList;//活动评论
	
	private Long commentCount;	//评论数
	
	private Long enrollCount;	//报名数
	
	private DeventText text;
	
	private Dstore store;
	
    private String latitude;

    private String status;

    private String examineStatus;

    private String examineResult;

    private Long entryfee;

    private Integer orderBy;

    private String url;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;
    
    private String isPtRed;//是否能使用普通红包
    private String isDiyText;//是否需要DIV文本录入
    
    private String checkOutTime;//检查过期时间
    
    
    //columns END

    
    public Devent() {
    }

    
    public String getCheckOutTime() {
		return checkOutTime;
	}


	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}


	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getIsPtRed() {
		return isPtRed;
	}

	public void setIsPtRed(String isPtRed) {
		this.isPtRed = isPtRed;
	}

	public String getIsDiyText() {
		return isDiyText;
	}

	public void setIsDiyText(String isDiyText) {
		this.isDiyText = isDiyText;
	}

	public Devent(Long id) {
        this.id = id;
    }
    
    public void setEntryfee(Long entryfee){
    	this.entryfee = entryfee;
    }
    
	public Long getEntryfee() {
		if (this.entryfee == null && this.entryfeeDollar != null) {
            this.entryfee = MoneyUtil.getDollarToCent(this.entryfeeDollar);
        }
		return this.entryfee;
	}
	
	public void setEntryfeeDollar(String entryfeeDollar){
		this.entryfeeDollar =entryfeeDollar ;
	}
	
	public String getEntryfeeDollar() {
		if (this.entryfeeDollar == null && this.entryfee != null) {
            this.entryfeeDollar = MoneyUtil.getCentToDollar(this.entryfee);
        }
		return entryfeeDollar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Long getAreaid1() {
		return areaid1;
	}

	public void setAreaid1(Long areaid1) {
		this.areaid1 = areaid1;
	}

	public Darea getArea1() {
		return area1;
	}

	public void setArea1(Darea area1) {
		this.area1 = area1;
	}

	public Long getAreaid2() {
		return areaid2;
	}

	public void setAreaid2(Long areaid2) {
		this.areaid2 = areaid2;
	}

	public Darea getArea2() {
		return area2;
	}

	public void setArea2(Darea area2) {
		this.area2 = area2;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	public Date getEnrollStartTime() {
		return enrollStartTime;
	}

	public void setEnrollStartTime(Date enrollStartTime) {
		this.enrollStartTime = enrollStartTime;
	}

	public Date getEnrollEndTime() {
		return enrollEndTime;
	}

	public void setEnrollEndTime(Date enrollEndTime) {
		this.enrollEndTime = enrollEndTime;
	}

	public Date getEnrollOffTime() {
		return enrollOffTime;
	}

	public void setEnrollOffTime(Date enrollOffTime) {
		this.enrollOffTime = enrollOffTime;
	}

	public Date getEventTime() {
		
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getStrEventTime() {
		if(eventTime != null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			strEventTime=sdf.format(eventTime); 
		}
		return strEventTime;
	}


	public void setStrEventTime(String strEventTime) {
		this.strEventTime = strEventTime;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<DeventImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<DeventImage> imageList) {
		this.imageList = imageList;
	}

	public List<DeventComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<DeventComment> commentList) {
		this.commentList = commentList;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getEnrollCount() {
		return enrollCount;
	}

	public void setEnrollCount(Long enrollCount) {
		this.enrollCount = enrollCount;
	}

	public DeventText getText() {
		return text;
	}

	public void setText(DeventText text) {
		this.text = text;
	}

	public Dstore getStore() {
		return store;
	}

	public void setStore(Dstore store) {
		this.store = store;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getExamineResult() {
		return examineResult;
	}

	public void setExamineResult(String examineResult) {
		this.examineResult = examineResult;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getEnrollNum() {
		return enrollNum;
	}
	public void setEnrollNum(Integer enrollNum) {
		this.enrollNum = enrollNum;
	}
	
}

