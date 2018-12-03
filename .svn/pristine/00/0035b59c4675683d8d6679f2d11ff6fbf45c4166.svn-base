package com.royao.model;

import java.io.Serializable;
import java.util.Date;

import com.royao.model.base.BaseEntity;

import cc.yiwang.commons.utils.MoneyUtil;
import cc.yiwang.commons.utils.Validate;

public class TechieClearing extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	private Long techieId;
	
	private String techieName;
	
	private Long money;
	
	private String moneyDouble;
	
	private Date createdTime;
	
	private String clearingName;

	/***/
	
	private String typeName;
	
	private String typeValue;
	
	private Date start;
	
	private Date end;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTechieId() {
		return techieId;
	}

	public void setTechieId(Long techieId) {
		this.techieId = techieId;
	}

	public String getTechieName() {
		return techieName;
	}

	public void setTechieName(String techieName) {
		this.techieName = techieName;
	}

	public Long getMoney() {
		if(!Validate.isEmpty(this.moneyDouble) && this.money == null){
			this.money = MoneyUtil.getDollarToCent(this.moneyDouble);
		}
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public String getMoneyDouble() {
		if(Validate.isEmpty(this.moneyDouble) && this.money != null){
			this.moneyDouble = MoneyUtil.getCentToDollar(this.money);
		}
		return moneyDouble;
	}

	public void setMoneyDouble(String moneyDouble) {
		this.moneyDouble = moneyDouble;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getClearingName() {
		return clearingName;
	}

	public void setClearingName(String clearingName) {
		this.clearingName = clearingName;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
}
