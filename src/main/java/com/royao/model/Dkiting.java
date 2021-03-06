package com.royao.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.royao.commons.enums.KitingStatus;
import com.royao.model.base.BaseEntity;
import com.royao.util.MoneyUtil;

public class Dkiting extends BaseEntity implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		 //alias
	    public static final String TABLE_ALIAS = "Dkiting";
	    public static final String ALIAS_ID = "id";
	    public static final String ALIAS_MEMBER_ID = "会员id";
	    public static final String ALIAS_MONEY = "提现金额";
	    public static final String ALIAS_BEFORE_MONEY = "提现前的用户余额";
	    public static final String ALIAS_AFTER_MONEY = "提现后的用户余额";
	    public static final String ALIAS_STATUS = "状态";
	    public static final String ALIAS_CREATED_TIME = "提交时间";
	    public static final String ALIAS_UPDATE_TIME = "处理成功时间";
	    public static final String ALIAS_UPDATE_BY = "处理人";
	    public static final String ALIAS_NAME = "姓名";
	    public static final String ALIAS_PHONE = "电话";
	    public static final String ALIAS_BANK_NAME = "开户行名称";    
	    public static final String ALIAS_BANK_CARD = "银行卡号";
	    public static final String ALIAS_NOTE="备注";
	    
		///
		private Long id;
		
		private Long memberId;
		
		private Long money;
		
		private String moneyDollar;
		
		private Long actualMoney;
		
		private String actualMoneyDollar;
		
		private Long beforeMoney;
		
		private Long afterMoney;
		
		private KitingStatus status;
		
		private Date createdTime;
		
		private String strCreatedTime;
		
		private Date updateTime;
		
		private String updateBy;
		
		private String name;
		
		private String phone;
		
		private String bankName;
		
		private String bankCard;
		
		private String note;
		
		private String type;

		private Dmember member;
		
		public Dmember getMember() {
			return member;
		}

		public void setMember(Dmember member) {
			this.member = member;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getMemberId() {
			return memberId;
		}

		public void setMemberId(Long memberId) {
			this.memberId = memberId;
		}

		public String getMoneyDollar() {
			if (this.moneyDollar == null && this.money != null) {
	            this.moneyDollar = MoneyUtil.getCentToDollar(this.money);
	        }
			return moneyDollar;
		}

		public void setMoneyDollar(String moneyDollar) {
			this.moneyDollar = moneyDollar;
		}

		public Long getMoney() {
			if (this.money == null && this.moneyDollar != null) {
	            this.money = MoneyUtil.getDollarToCent(this.moneyDollar);
	        }
			return money;
		}

		public void setMoney(Long money) {
			this.money = money;
		}

		public Long getActualMoney() {
			if (this.actualMoney == null && this.actualMoneyDollar != null) {
	            this.actualMoney = MoneyUtil.getDollarToCent(this.actualMoneyDollar);
	        }
			return actualMoney;
		}

		public void setActualMoney(Long actualMoney) {
			this.actualMoney = actualMoney;
		}

		public String getActualMoneyDollar() {
			if (this.actualMoneyDollar == null && this.actualMoney != null) {
	            this.actualMoneyDollar = MoneyUtil.getCentToDollar(this.actualMoney);
	        }
			return actualMoneyDollar;
		}

		public void setActualMoneyDollar(String actualMoneyDollar) {
			this.actualMoneyDollar = actualMoneyDollar;
		}

		public Long getBeforeMoney() {
			return beforeMoney;
		}

		public void setBeforeMoney(Long beforeMoney) {
			this.beforeMoney = beforeMoney;
		}

		public Long getAfterMoney() {
			return afterMoney;
		}

		public void setAfterMoney(Long afterMoney) {
			this.afterMoney = afterMoney;
		}

		public KitingStatus getStatus() {
			return status;
		}

		public void setStatus(KitingStatus status) {
			this.status = status;
		}

		public Date getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}

		public String getStrCreatedTime() {
			if(createdTime != null){
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				strCreatedTime = sd.format(createdTime);
			}
			
			return strCreatedTime;
		}

		public void setStrCreatedTime(String strCreatedTime) {
			this.strCreatedTime = strCreatedTime;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getBankCard() {
			return bankCard;
		}

		public void setBankCard(String bankCard) {
			this.bankCard = bankCard;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
}
