/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import cc.yiwang.commons.utils.Validate;

import com.royao.model.base.BaseEntity;
import com.royao.util.DateUtil;
import com.royao.util.MoneyUtil;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

public class Dorder extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_ALIAS = "Dorder";
	public static final String ALIAS_ORDER_ID = "订单索引id";
	public static final String ALIAS_ORDER_SN = "订单编号";
	public static final String ALIAS_PAY_SN = "支付单号";
	public static final String ALIAS_STORE_ID = "卖家店铺id";
	public static final String ALIAS_STORE_NAME = "卖家店铺名称";
	public static final String ALIAS_BUYER_ID = "买家id";
	public static final String ALIAS_BUYER_NAME = "买家姓名";
	public static final String ALIAS_GOODS_ID = "产品id";
	public static final String ALIAS_GOODS_NAME = "产品名称";
	public static final String ALIAS_GOODS_NUM = "产品数量";
	public static final String ALIAS_ADD_TIME = "订单生成时间";
	public static final String ALIAS_PAYMENT_CODE = "支付方式名称代码";
	public static final String ALIAS_PAYMENT_TIME = "支付(付款)时间";
	public static final String ALIAS_FINNSHED_TIME = "订单完成时间";
	public static final String ALIAS_ORDER_AMOUNT = "订单价格";
	public static final String ALIAS_COUPON_ID = "优惠券id";
	public static final String ALIAS_COUPON_AMOUNT = "优惠券金额";
	public static final String ALIAS_RCB_ID = "rcbId";
	public static final String ALIAS_RCB_AMOUNT = "红包支付金额";
	public static final String ALIAS_GOODS_LITPIC = "产品图片";
	public static final String ALIAS_ORDER_STATE = "订单状态：";
	public static final String ALIAS_LOCK_STATE = "锁定状态:0是正常,大于0是锁定,默认是0";
	public static final String ALIAS_DELETE_STATE = "删除状态0未删除1放入回收站2彻底删除";
	public static final String ALIAS_REFUND_AMOUNT = "退款金额";
	public static final String ALIAS_DELAY_TIME = "延迟时间,默认为0";
	public static final String ALIAS_ORDER_FROM = "1WEB2mobile";
	public static final String ALIAS_ORDER_TYPE = "订单类型1普通订单(默认),2预定订单";
	public static final String ALIAS_REMARK = "备注";

	// 可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// columns START

	private java.lang.Integer vipRankId;
	private java.lang.Integer orderId;
	private java.lang.Long orderSn;

	private java.lang.Long paySn;

	private java.lang.Integer storeId;

	private java.lang.String storeName;

	private java.lang.Long memberId;

	private java.lang.String memberName;

	private java.lang.Long goodsId;

	private java.lang.String goodsName;

	private java.lang.Long goodsNum;

	private java.util.Date addTime;
	
	private String strAddTime;

	private java.lang.String paymentCode;

	private java.util.Date paymentTime;

	private java.util.Date finnshedTime;

	private java.lang.Long orderAmount;
	
	private String orderAmountDollar;
	
	private java.lang.Long pdAmount;//预存款支付金额
	private String pdAmountDollar;//预存款支付金额

	private java.lang.Long couponId;

	private java.lang.Long couponAmount;

	private java.lang.Long rcbId;//红包id

	private java.lang.Long rcbAmount;//红包支付金额
	
	private String rcbAmountDollar;//红包支付金额
	

	private String goodsLitpic;

	private Integer orderState;

	private Integer lockState;

	private Integer deleteState;

	private java.lang.Long refundAmount;
	
	private String refundAmountDollar;

	private java.util.Date delayTime;

	private Integer orderFrom;

	private Integer orderType;
	private String remark;

	private Long bookDownPayment;
	
	private String bookDownPaymentDollar;

	private Long bookFinalPayment;
	
	private String bookFinalPaymentDollar;

	private String qrCode;

	private Date verifyConsumptionTime;
	
	private String strVerifyConsumptionTime;//核销时间

	private String verifyConsumptionPerson;
	
	private String mTrueName;//'订单附加信息真实姓名',
	private String mMobile;//'订单附加信息电话',
	private String mDate;//'订单附加信息日期',
	private String mAddress;// '订单附加信息地址',

	private String consumptionCode;
	
	private Date refundTime;
	private Date complaintTime;
	// columns END

	private Dgoods goods;
	
	private String addTimeStr;
	
	private String paymentTimeStr;
	
	private String finnshedTimeStr;
	
	private String delayTimeStr;
	
	private String verifyConsumptionTimeStr;
	
	private String refundTimeStr;
	
	private String complaintTimeStr;

	private Integer settlementState;
	
	private Devaluate evaluate;
	
	/*****用于对账*****/
	private Integer grade;//评价等级
	private Long goodsPrice;//商品基础价格
	private String goodsPriceDollar;//商品基础价格
	private Integer serviceRatio;//标准服务费比例
	private Long serviceFee;//服务费
	private String serviceFeeDollar;//服务费
	private Date evaluateTime;//评论时间
	private String strEvaluateTime;//评论时间
	private Long settleAccount;//结算金额
	private String settleAccountDollar;//结算金额
	/*****用于对账*****/
	
	public Devaluate getEvaluate() {
		return evaluate;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Long getGoodsPrice() {
		if (this.goodsPrice == null && this.goodsPriceDollar != null) {
            this.goodsPrice = MoneyUtil.getDollarToCent(this.goodsPriceDollar);
        }
		return goodsPrice;
	}

	public void setGoodsPrice(Long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsPriceDollar() {
		if (this.goodsPriceDollar == null && this.goodsPrice != null) {
            this.goodsPriceDollar = MoneyUtil.getCentToDollar(this.goodsPrice);
        }
		return goodsPriceDollar;
	}

	public void setGoodsPriceDollar(String goodsPriceDollar) {
		this.goodsPriceDollar = goodsPriceDollar;
	}

	public Integer getServiceRatio() {
		return serviceRatio;
	}

	public void setServiceRatio(Integer serviceRatio) {
		this.serviceRatio = serviceRatio;
	}

	public Long getServiceFee() {
		if (this.serviceFee == null && this.serviceFeeDollar != null) {
            this.serviceFee = MoneyUtil.getDollarToCent(this.serviceFeeDollar);
        }
		return serviceFee;
	}

	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getServiceFeeDollar() {
		if (this.serviceFeeDollar == null && this.serviceFee != null) {
            this.serviceFeeDollar = MoneyUtil.getCentToDollar(this.serviceFee);
        }
		return serviceFeeDollar;
	}

	public void setServiceFeeDollar(String serviceFeeDollar) {
		this.serviceFeeDollar = serviceFeeDollar;
	}

	public Date getEvaluateTime() {
		return evaluateTime;
	}

	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}

	public String getStrEvaluateTime() {
		if(evaluateTime != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			strEvaluateTime = sdf.format(evaluateTime);
		}
		return strEvaluateTime;
	}

	public void setStrEvaluateTime(String strEvaluateTime) {
		this.strEvaluateTime = strEvaluateTime;
	}

	public Long getSettleAccount() {
		if (this.settleAccount == null && this.settleAccountDollar != null) {
            this.settleAccount = MoneyUtil.getDollarToCent(this.settleAccountDollar);
        }
		return settleAccount;
	}

	public void setSettleAccount(Long settleAccount) {
		this.settleAccount = settleAccount;
	}

	public String getSettleAccountDollar() {
		if (this.settleAccountDollar == null && this.settleAccount != null) {
            this.settleAccountDollar = MoneyUtil.getCentToDollar(this.settleAccount);
        }
		return settleAccountDollar;
	}

	public void setSettleAccountDollar(String settleAccountDollar) {
		this.settleAccountDollar = settleAccountDollar;
	}

	public void setEvaluate(Devaluate evaluate) {
		this.evaluate = evaluate;
	}

	public String getAddTimeStr() {
		if(this.addTime != null && Validate.isEmpty(addTimeStr)){
			this.addTimeStr = DateUtil.formatDatetime(this.addTime);
		}
		return addTimeStr;
	}

	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}

	public String getPaymentTimeStr() {
		if(this.paymentTime != null && Validate.isEmpty(paymentTimeStr)){
			this.paymentTimeStr = DateUtil.formatDatetime(this.paymentTime);
		}
		return paymentTimeStr;
	}

	public void setPaymentTimeStr(String paymentTimeStr) {
		this.paymentTimeStr = paymentTimeStr;
	}

	public String getFinnshedTimeStr() {
		if(this.finnshedTime != null && Validate.isEmpty(finnshedTimeStr)){
			this.finnshedTimeStr = DateUtil.formatDatetime(this.finnshedTime);
		}
		return finnshedTimeStr;
	}

	public void setFinnshedTimeStr(String finnshedTimeStr) {
		this.finnshedTimeStr = finnshedTimeStr;
	}

	public String getDelayTimeStr() {
		if(this.delayTime != null && Validate.isEmpty(delayTimeStr)){
			this.delayTimeStr = DateUtil.formatDatetime(this.delayTime);
		}
		return delayTimeStr;
	}

	public void setDelayTimeStr(String delayTimeStr) {
		this.delayTimeStr = delayTimeStr;
	}

	public String getVerifyConsumptionTimeStr() {
		if(this.verifyConsumptionTime != null && Validate.isEmpty(verifyConsumptionTimeStr)){
			this.verifyConsumptionTimeStr = DateUtil.formatDatetime(this.verifyConsumptionTime);
		}
		return verifyConsumptionTimeStr;
	}

	public void setVerifyConsumptionTimeStr(String verifyConsumptionTimeStr) {
		this.verifyConsumptionTimeStr = verifyConsumptionTimeStr;
	}

	public String getRefundTimeStr() {
		if(this.refundTime != null && Validate.isEmpty(refundTimeStr)){
			this.refundTimeStr = DateUtil.formatDatetime(this.refundTime);
		}
		return refundTimeStr;
	}

	public void setRefundTimeStr(String refundTimeStr) {
		this.refundTimeStr = refundTimeStr;
	}

	public String getComplaintTimeStr() {
		if(this.complaintTime != null && Validate.isEmpty(complaintTimeStr)){
			this.complaintTimeStr = DateUtil.formatDatetime(this.complaintTime);
		}
		return complaintTimeStr;
	}

	public void setComplaintTimeStr(String complaintTimeStr) {
		this.complaintTimeStr = complaintTimeStr;
	}

	/***/
	public java.lang.Integer getVipRankId() {
		return vipRankId;
	}

	public void setVipRankId(java.lang.Integer vipRankId) {
		this.vipRankId = vipRankId;
	}

	public Date getComplaintTime() {
		return complaintTime;
	}

	public void setComplaintTime(Date complaintTime) {
		this.complaintTime = complaintTime;
	}

	public Dgoods getGoods() {
		return goods;
	}

	public void setGoods(Dgoods goods) {
		this.goods = goods;
	}

	public java.lang.Long getPdAmount() {
		if (this.pdAmount == null && this.pdAmountDollar != null) {
            this.pdAmount = MoneyUtil.getDollarToCent(this.pdAmountDollar);
        }
		return pdAmount;
	}

	public String getPdAmountDollar() {
		if (this.pdAmountDollar == null && this.pdAmount != null) {
            this.pdAmountDollar = MoneyUtil.getCentToDollar(this.pdAmount);
        }
		return pdAmountDollar;
	}

	public void setPdAmountDollar(String pdAmountDollar) {
		this.pdAmountDollar = pdAmountDollar;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public String getConsumptionCode() {
		return consumptionCode;
	}

	public void setConsumptionCode(String consumptionCode) {
		this.consumptionCode = consumptionCode;
	}

	public void setPdAmount(java.lang.Long pdAmount) {
		this.pdAmount = pdAmount;
	}
	
	public Long getBookDownPayment() {
		if (this.bookDownPayment == null && this.bookDownPaymentDollar != null) {
            this.bookDownPayment = MoneyUtil.getDollarToCent(this.bookDownPaymentDollar);
        }
		return bookDownPayment;
	}

	public String getBookDownPaymentDollar() {
		if (this.bookDownPaymentDollar == null && this.bookDownPayment != null) {
            this.bookDownPaymentDollar = MoneyUtil.getCentToDollar(this.bookDownPayment);
        }
		return bookDownPaymentDollar;
	}

	public void setBookDownPaymentDollar(String bookDownPaymentDollar) {
		this.bookDownPaymentDollar = bookDownPaymentDollar;
	}

	public String getMTrueName() {
		return mTrueName;
	}

	public void setMTrueName(String mTrueName) {
		this.mTrueName = mTrueName;
	}

	public String getMMobile() {
		return mMobile;
	}

	public void setMMobile(String mMobile) {
		this.mMobile = mMobile;
	}

	public String getMDate() {
		return mDate;
	}

	public void setMDate(String mDate) {
		this.mDate = mDate;
	}

	public String getMAddress() {
		return mAddress;
	}

	public void setMAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public void setBookDownPayment(Long bookDownPayment) {
		this.bookDownPayment = bookDownPayment;
	}

	public Long getBookFinalPayment() {
		if (this.bookFinalPayment == null && this.bookFinalPaymentDollar != null) {
            this.bookFinalPayment = MoneyUtil.getDollarToCent(this.bookFinalPaymentDollar);
        }
		return bookFinalPayment;
	}

	public void setBookFinalPayment(Long bookFinalPayment) {
		this.bookFinalPayment = bookFinalPayment;
	}

	public String getBookFinalPaymentDollar() {
		if (this.bookFinalPaymentDollar == null && this.bookFinalPayment != null) {
            this.bookFinalPaymentDollar = MoneyUtil.getCentToDollar(this.bookFinalPayment);
        }
		return bookFinalPaymentDollar;
	}

	public void setBookFinalPaymentDollar(String bookFinalPaymentDollar) {
		this.bookFinalPaymentDollar = bookFinalPaymentDollar;
	}

	public Dorder() {
	}

	public Dorder(java.lang.Integer orderId) {
		this.orderId = orderId;
	}

	public void setOrderId(java.lang.Integer value) {
		this.orderId = value;
	}

	public java.lang.Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderSn(java.lang.Long value) {
		this.orderSn = value;
	}

	public java.lang.Long getOrderSn() {
		return this.orderSn;
	}

	public void setPaySn(java.lang.Long value) {
		this.paySn = value;
	}

	public java.lang.Long getPaySn() {
		return this.paySn;
	}

	public void setStoreId(java.lang.Integer value) {
		this.storeId = value;
	}

	public java.lang.Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreName(java.lang.String value) {
		this.storeName = value;
	}

	public java.lang.String getStoreName() {
		return this.storeName;
	}

	public java.lang.Long getMemberId() {
		return memberId;
	}

	public void setMemberId(java.lang.Long memberId) {
		this.memberId = memberId;
	}

	public java.lang.String getMemberName() {
		return memberName;
	}

	public void setMemberName(java.lang.String memberName) {
		this.memberName = memberName;
	}

	public void setGoodsId(java.lang.Long value) {
		this.goodsId = value;
	}

	public java.lang.Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsName(java.lang.String value) {
		this.goodsName = value;
	}

	public java.lang.String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsNum(java.lang.Long value) {
		this.goodsNum = value;
	}

	public java.lang.Long getGoodsNum() {
		return this.goodsNum;
	}

	public void setAddTime(java.util.Date value) {
		this.addTime = value;
	}

	public java.util.Date getAddTime() {
		return this.addTime;
	}

	public void setPaymentCode(java.lang.String value) {
		this.paymentCode = value;
	}

	public java.lang.String getPaymentCode() {
		return this.paymentCode;
	}

	public void setPaymentTime(java.util.Date value) {
		this.paymentTime = value;
	}

	public java.util.Date getPaymentTime() {
		return this.paymentTime;
	}

	public void setFinnshedTime(java.util.Date value) {
		this.finnshedTime = value;
	}

	public java.util.Date getFinnshedTime() {
		return this.finnshedTime;
	}

	public void setOrderAmount(java.lang.Long value) {
		this.orderAmount = value;
	}

	public java.lang.Long getOrderAmount() {
		if (this.orderAmount == null && this.orderAmountDollar != null) {
            this.orderAmount = MoneyUtil.getDollarToCent(this.orderAmountDollar);
        }
		return this.orderAmount;
	}

	public String getOrderAmountDollar() {
		if (this.orderAmountDollar == null && this.orderAmount != null) {
            this.orderAmountDollar = MoneyUtil.getCentToDollar(this.orderAmount);
        }
		return orderAmountDollar;
	}

	public void setOrderAmountDollar(String orderAmountDollar) {
		this.orderAmountDollar = orderAmountDollar;
	}

	public void setCouponId(java.lang.Long value) {
		this.couponId = value;
	}

	public java.lang.Long getCouponId() {
		return this.couponId;
	}

	public void setCouponAmount(java.lang.Long value) {
		this.couponAmount = value;
	}

	public java.lang.Long getCouponAmount() {
		return this.couponAmount;
	}

	public void setRcbId(java.lang.Long value) {
		this.rcbId = value;
	}

	public java.lang.Long getRcbId() {
		return this.rcbId;
	}

	public void setRcbAmount(java.lang.Long value) {
		this.rcbAmount = value;
	}

	public java.lang.Long getRcbAmount() {
		if (this.rcbAmount == null && this.rcbAmountDollar != null) {
            this.rcbAmount = MoneyUtil.getDollarToCent(this.rcbAmountDollar);
        }
		return this.rcbAmount;
	}

	public String getRcbAmountDollar() {
		if (this.rcbAmountDollar == null && this.rcbAmount != null) {
            this.rcbAmountDollar = MoneyUtil.getCentToDollar(this.rcbAmount);
        }
		return rcbAmountDollar;
	}

	public void setRcbAmountDollar(String rcbAmountDollar) {
		this.rcbAmountDollar = rcbAmountDollar;
	}

	public String getGoodsLitpic() {
		return goodsLitpic;
	}

	public void setGoodsLitpic(String goodsLitpic) {
		this.goodsLitpic = goodsLitpic;
	}

	public void setOrderState(Integer value) {
		this.orderState = value;
	}

	public Integer getOrderState() {
		return this.orderState;
	}

	public void setLockState(Integer value) {
		this.lockState = value;
	}

	public Integer getLockState() {
		return this.lockState;
	}

	public void setDeleteState(Integer value) {
		this.deleteState = value;
	}

	public Integer getDeleteState() {
		return this.deleteState;
	}

	public void setRefundAmount(java.lang.Long value) {
		this.refundAmount = value;
	}

	public java.lang.Long getRefundAmount() {
		if (this.refundAmount == null && this.refundAmountDollar != null) {
            this.refundAmount = MoneyUtil.getDollarToCent(this.refundAmountDollar);
        }
		return this.refundAmount;
	}

	public String getRefundAmountDollar() {
		if (this.refundAmountDollar == null && this.refundAmount != null) {
            this.refundAmountDollar = MoneyUtil.getCentToDollar(this.refundAmount);
        }
		return refundAmountDollar;
	}

	public void setRefundAmountDollar(String refundAmountDollar) {
		this.refundAmountDollar = refundAmountDollar;
	}

	public void setDelayTime(java.util.Date value) {
		this.delayTime = value;
	}

	public java.util.Date getDelayTime() {
		return this.delayTime;
	}

	public void setOrderFrom(Integer value) {
		this.orderFrom = value;
	}

	public Integer getOrderFrom() {
		return this.orderFrom;
	}

	public void setOrderType(Integer value) {
		this.orderType = value;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setRemark(java.lang.String value) {
		this.remark = value;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}

	public Integer getSettlementState() {
		return settlementState;
	}

	public void setSettlementState(Integer settlementState) {
		this.settlementState = settlementState;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Date getVerifyConsumptionTime() {
		return verifyConsumptionTime;
	}

	public void setVerifyConsumptionTime(Date verifyConsumptionTime) {
		this.verifyConsumptionTime = verifyConsumptionTime;
	}

	public String getVerifyConsumptionPerson() {
		return verifyConsumptionPerson;
	}

	public void setVerifyConsumptionPerson(String verifyConsumptionPerson) {
		this.verifyConsumptionPerson = verifyConsumptionPerson;
	}

	
	public String getStrVerifyConsumptionTime() {
		
		if(verifyConsumptionTime != null){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strVerifyConsumptionTime = sd.format(verifyConsumptionTime);
		}
		return strVerifyConsumptionTime;
	}

	public void setStrVerifyConsumptionTime(String strVerifyConsumptionTime) {
		this.strVerifyConsumptionTime = strVerifyConsumptionTime;
	}

	public String getStrAddTime() {
		if(addTime != null){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strAddTime = sd.format(addTime);
		}
		return strAddTime;
	}

	public void setStrAddTime(String strAddTime) {
		this.strAddTime = strAddTime;
	}

}
