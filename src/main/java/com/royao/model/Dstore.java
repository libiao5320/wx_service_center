/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.model;


import java.util.Date;
import java.util.List;

import com.royao.commons.enums.StoreStatus;
import com.royao.model.base.BaseEntity;



/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Dstore extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Dstore";
	public static final String ALIAS_STORE_ID = "店铺索引id";
	public static final String ALIAS_STORE_NAME = "店铺名称";
	public static final String ALIAS_GRADE_ID = "店铺等级";
	public static final String ALIAS_SELLER_NAME = "店主卖家用户名";
	public static final String ALIAS_STORE_LOGIN_PHONE = "商家登录电话";
	public static final String ALIAS_SC_ID = "店铺分类";
	public static final String ALIAS_STORE_COMPANY_NAME = "店铺公司名称";
	public static final String ALIAS_PROVINCE_ID = "店铺所在省份ID";
	public static final String ALIAS_CITY_ID = "城市编号";
	public static final String ALIAS_AREA_INFO = "地区内容，冗余数据";
	public static final String ALIAS_STORE_ADDRESS = "详细地区";
	public static final String ALIAS_STORE_ZIP = "邮政编码";
	public static final String ALIAS_STORE_STATE = "店铺状态，0关闭，1开启，2审核中";
	public static final String ALIAS_STORE_SORT = "店铺排序 C端商家排序规则，填写正整数，数字越小越靠前";
	public static final String ALIAS_STORE_TIME = "店铺开通时间";
	public static final String ALIAS_STORE_DESCRIBE = "店铺介绍 图文编辑器，用于C端展示";
	public static final String ALIAS_STORE_LABEL = "店铺logo 用于前端显示";
	public static final String ALIAS_PACT_IMG = "上传图片，仅后台可见";
	public static final String ALIAS_STORE_PHONE = "商家电话显示用";
	public static final String ALIAS_STORE_ZY = "主营商品";
	public static final String ALIAS_STORE_SERVICECREDIT = "服务态度分数";
	public static final String ALIAS_STORE_COLLECT = "店铺收藏数量";
	public static final String ALIAS_STORE_WORKINGTIME = "营业时间 用于C端显示";
	public static final String ALIAS_STORE_SALES_GROSS = "销售总额";
	public static final String ALIAS_STORE_SALES = "店铺销量";
	public static final String ALIAS_SORT = "排序";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_LBSX = "当前位置X坐标";
	public static final String ALIAS_LBSY = "当前位置Y坐标";
	public static final String ALIAS_STATUS = "状态，normal-正常，delete-逻辑删除";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Long storeId;
	private java.lang.String storeName;
	private java.lang.Long gradeId;
	private java.lang.String sellerName;
	private java.lang.String storeLoginPhone;
	private java.lang.String storePasswd;
	private java.lang.String storeSecret;
	private java.lang.Long scId;
	private java.lang.String storeCompanyName;
	private java.lang.Integer provinceId;
	
	private java.lang.Integer cityId;
	private java.lang.Integer areaId;
	private java.lang.String areaInfo;
	private java.lang.String fjLandmark;
	private java.lang.String storeAddress;
	private java.lang.String storeZip;
	private java.lang.Integer storeState;
	private java.lang.Integer storeSort;
	private Date storeTime;
	private java.lang.String storeDescribe;
	private java.lang.String storeLabel;
	private java.lang.String pactImg;
	private java.lang.String storePhone;
	private java.lang.String storeZy;
	private java.lang.Float storeServicecredit;
	private java.lang.Integer storeCollect;
	private java.lang.String storeWorkingtime;
	
	private java.lang.Long storeSalesGross;
	private java.lang.Integer storeSales;
	private java.lang.Integer sort;
	private java.lang.String remark;
	private java.lang.String lbsX;
	private java.lang.String lbsY;
	private StoreStatus status;
	private Integer evaluationStoreProbability;//店铺好评率
	//columns END
	
	private DgroupbuyClass groupbuy;//店铺分类
	
	private Integer goodsCount;	//统计商品数量
	
	private Integer evaluateCount;//统计评论数
	
	private List<Dgoods> goodsList;	//商品列表
	
	private List<Devaluate> evaluateList;//商品评价列表
	
	private List<Devent> eventList;	//活动列表
	
	private String search;	//用户模糊搜索
	
	private String distance;	//距离
	
	/*****/
	private DstoreExtend extend;
	
	private DstoreManager manager;
	
	private DstoreText text;
	
	
	public DstoreExtend getExtend() {
		return extend;
	}

	public void setExtend(DstoreExtend extend) {
		this.extend = extend;
	}

	public DstoreManager getManager() {
		return manager;
	}

	public void setManager(DstoreManager manager) {
		this.manager = manager;
	}

	public DstoreText getText() {
		return text;
	}

	public void setText(DstoreText text) {
		this.text = text;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Devent> getEventList() {
		return eventList;
	}

	public void setEventList(List<Devent> eventList) {
		this.eventList = eventList;
	}

	public Integer getEvaluateCount() {
		return evaluateCount;
	}

	public void setEvaluateCount(Integer evaluateCount) {
		this.evaluateCount = evaluateCount;
	}

	public DgroupbuyClass getGroupbuy() {
		return groupbuy;
	}

	public void setGroupbuy(DgroupbuyClass groupbuy) {
		this.groupbuy = groupbuy;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public List<Dgoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Dgoods> goodsList) {
		this.goodsList = goodsList;
	}

	public List<Devaluate> getEvaluateList() {
		return evaluateList;
	}

	public void setEvaluateList(List<Devaluate> evaluateList) {
		this.evaluateList = evaluateList;
	}

	public Dstore(){
	}

	public Dstore(Long storeId){
		this.storeId = storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	
	public Long getStoreId() {
		return this.storeId;
	}
	public void setStoreName(java.lang.String value) {
		this.storeName = value;
	}
	
	public java.lang.String getStoreName() {
		return this.storeName;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	
	public Long getGradeId() {
		return this.gradeId;
	}
	public void setSellerName(java.lang.String value) {
		this.sellerName = value;
	}
	
	public java.lang.String getStoreSecret() {
		return storeSecret;
	}

	public void setStoreSecret(java.lang.String storeSecret) {
		this.storeSecret = storeSecret;
	}

	public java.lang.String getSellerName() {
		return this.sellerName;
	}
	public void setStoreLoginPhone(java.lang.String value) {
		this.storeLoginPhone = value;
	}
	
	public java.lang.String getStoreLoginPhone() {
		return this.storeLoginPhone;
	}
	public java.lang.String getStorePasswd() {
		return storePasswd;
	}

	public void setStorePasswd(java.lang.String storePasswd) {
		this.storePasswd = storePasswd;
	}

	public void setScId(java.lang.Long value) {
		this.scId = value;
	}
	
	public java.lang.Long getScId() {
		return this.scId;
	}
	public void setStoreCompanyName(java.lang.String value) {
		this.storeCompanyName = value;
	}
	
	public java.lang.String getStoreCompanyName() {
		return this.storeCompanyName;
	}
	public void setProvinceId(java.lang.Integer value) {
		this.provinceId = value;
	}
	
	public java.lang.Integer getProvinceId() {
		return this.provinceId;
	}
	public void setCityId(java.lang.Integer value) {
		this.cityId = value;
	}
	
	public java.lang.Integer getCityId() {
		return this.cityId;
	}
	public java.lang.Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(java.lang.Integer areaId) {
		this.areaId = areaId;
	}

	public java.lang.String getFjLandmark() {
		return fjLandmark;
	}

	public void setFjLandmark(java.lang.String fjLandmark) {
		this.fjLandmark = fjLandmark;
	}

	public void setAreaInfo(java.lang.String value) {
		this.areaInfo = value;
	}
	
	public java.lang.String getAreaInfo() {
		return this.areaInfo;
	}
	public void setStoreAddress(java.lang.String value) {
		this.storeAddress = value;
	}
	
	public java.lang.String getStoreAddress() {
		return this.storeAddress;
	}
	public void setStoreZip(java.lang.String value) {
		this.storeZip = value;
	}
	
	public java.lang.String getStoreZip() {
		return this.storeZip;
	}
	public void setStoreState(Integer value) {
		this.storeState = value;
	}
	
	public Integer getStoreState() {
		return this.storeState;
	}
	public void setStoreSort(java.lang.Integer value) {
		this.storeSort = value;
	}
	
	public java.lang.Integer getStoreSort() {
		return this.storeSort;
	}
	public void setStoreTime(Date value) {
		this.storeTime = value;
	}
	
	public Date getStoreTime() {
		return this.storeTime;
	}
	public void setStoreDescribe(java.lang.String value) {
		this.storeDescribe = value;
	}
	
	public java.lang.String getStoreDescribe() {
		return this.storeDescribe;
	}
	public void setStoreLabel(java.lang.String value) {
		this.storeLabel = value;
	}
	
	public java.lang.String getStoreLabel() {
		return this.storeLabel;
	}
	public void setPactImg(java.lang.String value) {
		this.pactImg = value;
	}
	
	public java.lang.String getPactImg() {
		return this.pactImg;
	}
	public void setStorePhone(java.lang.String value) {
		this.storePhone = value;
	}
	
	public java.lang.String getStorePhone() {
		return this.storePhone;
	}
	public void setStoreZy(java.lang.String value) {
		this.storeZy = value;
	}
	
	public java.lang.String getStoreZy() {
		return this.storeZy;
	}
	public void setStoreServicecredit(java.lang.Float value) {
		this.storeServicecredit = value;
	}
	
	public java.lang.Float getStoreServicecredit() {
		return this.storeServicecredit;
	}
	public void setStoreCollect(java.lang.Integer value) {
		this.storeCollect = value;
	}
	
	public java.lang.Integer getStoreCollect() {
		return this.storeCollect;
	}
	public void setStoreWorkingtime(java.lang.String value) {
		this.storeWorkingtime = value;
	}
	
	public java.lang.String getStoreWorkingtime() {
		return this.storeWorkingtime;
	}
	public void setStoreSalesGross(java.lang.Long value) {
		this.storeSalesGross = value;
	}
	
	public java.lang.Long getStoreSalesGross() {
		return this.storeSalesGross;
	}
	public void setStoreSales(java.lang.Integer value) {
		this.storeSales = value;
	}
	
	public java.lang.Integer getStoreSales() {
		return this.storeSales;
	}
	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}
	
	public java.lang.Integer getSort() {
		return this.sort;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public java.lang.String getLbsX() {
		return lbsX;
	}

	public void setLbsX(java.lang.String lbsX) {
		this.lbsX = lbsX;
	}

	public java.lang.String getLbsY() {
		return lbsY;
	}

	public void setLbsY(java.lang.String lbsY) {
		this.lbsY = lbsY;
	}

	public void setStatus(StoreStatus status) {
		this.status = status;
	}
	
	public StoreStatus getStatus() {
		return this.status;
	}

	public Integer getEvaluationStoreProbability() {
		return evaluationStoreProbability;
	}

	public void setEvaluationStoreProbability(Integer evaluationStoreProbability) {
		this.evaluationStoreProbability = evaluationStoreProbability;
	}
	

}

