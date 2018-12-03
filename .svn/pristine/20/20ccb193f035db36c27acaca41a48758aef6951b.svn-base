package com.royao.model;

import java.io.Serializable;
import java.util.Date;

import cc.yiwang.commons.utils.MoneyUtil;
import cc.yiwang.commons.utils.Validate;

import com.royao.commons.enums.RewardStatus;
import com.royao.model.base.BaseEntity;

public class Dreward  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long techieId;
	
	private Long memberId;
	
	private String techieName;
	
	private String memberName;
	
	private Long money;
	
	private String moneyDouble;
	
	private Date createdTime;
	
	private RewardStatus rewardStatus;
	
	private Integer isClearing;
	
	private String clearingName;
	
	private Date clearingTime;

	
	/***/
	private String typeName;
	
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

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getTechieName() {
		return techieName;
	}

	public void setTechieName(String techieName) {
		this.techieName = techieName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public RewardStatus getRewardStatus() {
		return rewardStatus;
	}

	public void setRewardStatus(RewardStatus rewardStatus) {
		this.rewardStatus = rewardStatus;
	}

	public Integer getIsClearing() {
		return isClearing;
	}

	public void setIsClearing(Integer isClearing) {
		this.isClearing = isClearing;
	}

	public String getClearingName() {
		return clearingName;
	}

	public void setClearingName(String clearingName) {
		this.clearingName = clearingName;
	}

	public Date getClearingTime() {
		return clearingTime;
	}

	public void setClearingTime(Date clearingTime) {
		this.clearingTime = clearingTime;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
}
