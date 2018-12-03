/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.commons.enums.RedpacketsStatus;
import com.royao.model.base.BaseEntity;
import com.royao.util.MoneyUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DredpacketsDistribute extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "DredpacketsDistribute";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_REDPACKETS_ID = "主红包ID";
	public static final String ALIAS_MEMBER_ID = "用户ID";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_MONEY = "红包金额";
	public static final String ALIAS_STATUS = "红包状态，unuse-未使用，used-已使用，expired-已过期";
	public static final String ALIAS_CREATE_TIME = "领取时间";
	public static final String ALIAS_UPDATE_TIME = "使用时间或过期时间";

	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	private Long id;

	private Long redpacketsId;

	private Long memberId;

	private String name;
	
	private Long money;
	
	private String moneyDollar;
	
	private Long goodsMoney;//订单金额
	
	private Date validTime;
	
	private String strValidTime;

	private RedpacketsStatus status;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Long storeId;

	private Long catchCount;  //分享红包领取数
	private Long packSouce;   //红包来源
	
	private String purpose;
	private String isBdRed;	//是否是贝多红包
	private String isPtRed;	//是否允许使用普通红包
	
	private String memberName;
	//columns END
	
	private Dredpackets redpackets;	//红包信息

	
	
	
	public String getIsPtRed() {
		return isPtRed;
	}

	public void setIsPtRed(String isPtRed) {
		this.isPtRed = isPtRed;
	}

	public String getIsBdRed() {
		return isBdRed;
	}

	public void setIsBdRed(String isBdRed) {
		this.isBdRed = isBdRed;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Dredpackets getRedpackets() {
		return redpackets;
	}

	public void setRedpackets(Dredpackets redpackets) {
		this.redpackets = redpackets;
	}

	public DredpacketsDistribute(){
	}

	public DredpacketsDistribute(
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
	public void setRedpacketsId(Long value) {
		this.redpacketsId = value;
	}
	
	public Long getRedpacketsId() {
		return this.redpacketsId;
	}
	public void setMemberId(Long value) {
		this.memberId = value;
	}
	
	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public String getStrValidTime() {
		if(validTime != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			strValidTime = sdf.format(validTime);
		}
		
		return strValidTime;
	}

	public void setStrValidTime(String strValidTime) {
		this.strValidTime = strValidTime;
	}

	public Long getMemberId() {
		return this.memberId;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public Long getGoodsMoney() {
		return goodsMoney;
	}

	public void setGoodsMoney(Long goodsMoney) {
		this.goodsMoney = goodsMoney;
	}

	public String getName() {
		return this.name;
	}
	public void setMoney(Long value) {
		this.money = value;
	}
	
	public Long getMoney() {
		if (this.money == null && this.moneyDollar != null) {
            this.money = MoneyUtil.getDollarToCent(this.moneyDollar);
        }
		return this.money;
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

	public void setStatus(RedpacketsStatus status) {
		this.status = status;
	}
	
	public RedpacketsStatus getStatus() {
		return this.status;
	}

	
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}

	
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Long getPackSouce() {
		return packSouce;
	}

	public void setPackSouce(Long packSouce) {
		this.packSouce = packSouce;
	}

	public Long getCatchCount() {
		return catchCount;
	}

	public void setCatchCount(Long catchCount) {
		this.catchCount = catchCount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}

