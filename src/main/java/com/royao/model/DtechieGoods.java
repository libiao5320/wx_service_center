/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.model;

import java.util.List;

import com.royao.model.base.BaseEntity;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DtechieGoods extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "DtechieGoods";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TECHIE_ID = "健康师id";
	public static final String ALIAS_GOODS_ID = "商品id";
	public static final String ALIAS_SORT = "排序 越小排越靠前";
	public static final String ALIAS_IS_COMMEND = "是否推荐 N不推荐 Y推荐";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private java.lang.Long id;
	 
	private java.lang.Long techieId;
	 
	private java.lang.Long goodsId;
	
	private java.lang.Long sort;
	
	private java.lang.String isCommend;
	
	private Dtechie dtechie;//健康师
	//columns END

	private List<Dgoods> goodsList;
	
	public List<Dgoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Dgoods> goodsList) {
		this.goodsList = goodsList;
	}

	public DtechieGoods(){
	}

	public Dtechie getDtechie() {
		return dtechie;
	}

	public void setDtechie(Dtechie dtechie) {
		this.dtechie = dtechie;
	}

	public DtechieGoods(
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
	public void setGoodsId(java.lang.Long value) {
		this.goodsId = value;
	}
	
	public java.lang.Long getGoodsId() {
		return this.goodsId;
	}
	public void setSort(java.lang.Long value) {
		this.sort = value;
	}
	
	public java.lang.Long getSort() {
		return this.sort;
	}
	public void setIsCommend(java.lang.String value) {
		this.isCommend = value;
	}
	
	public java.lang.String getIsCommend() {
		return this.isCommend;
	}
}

