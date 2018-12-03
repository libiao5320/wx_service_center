/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.royao.model.base.BaseEntity;

import java.util.*;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class TuserConsult extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TuserConsult";
	public static final String ALIAS_VCONSULT_ID = "咨询ID";
	public static final String ALIAS_VDOCTOR_ID = "咨询对象（医生ID）";
	public static final String ALIAS_ICONSULT_WAY = "1=图文 2=语音留言 3=语音通话 4=视频";
	public static final String ALIAS_DCREATE_TIME = "发表时间";
	public static final String ALIAS_VCONTENT = "咨询内容";
	public static final String ALIAS_IREPLY_NUM = "回复数";
	public static final String ALIAS_DBEG_TIME = "处理开始时间";
	public static final String ALIAS_DEND_TIME = "处理结束时间";
	public static final String ALIAS_ISTATUS = "医生处理咨询的状态：0=待处理;1=处理中就是咨询中;2=医生申请结束;10=待评价(完成);11 已评价   12=医生无应答，转诊处理";
	public static final String ALIAS_ISTATUS_TIME = "状态时间";
	public static final String ALIAS_IRESULT = "评价结果: 1=满意, 0=待评价 ,2=不满意";
	public static final String ALIAS_VREASON = "不满意原因";
	public static final String ALIAS_IAUDIT_STATUS = "顾客不满意运营处理状态：1=待处理；2=已处理";
	public static final String ALIAS_VUSERID = "咨询的用户id";
	public static final String ALIAS_VPRODUCT_ID = "对应的产品套餐ID";
	public static final String ALIAS_VAUDIT_DEMO = "运营处理结果备注";
	public static final String ALIAS_VAUDIT_TIME = "运营处理结果时间";
	public static final String ALIAS_VCALL_ID = "该咨询正在拨号的ID";
	public static final String ALIAS_VCALL_STAFF = "如果是客服发起的拨号，则此字段存客服的ID";
	public static final String ALIAS_ISTATUS_STAFF = "客服处理咨询的状态：0=客服未参与咨询；1=待处理；2=处理中；3=已处理 4=关闭(不需要处理)的咨询";
	public static final String ALIAS_DSTATUS_STAFF = "客服处理咨询的时间";
	public static final String ALIAS_IS_FRIEND = "是否为好友咨询：1=好友咨询；0=套餐咨询;2=作废好友咨询";
	public static final String ALIAS_IRESULT_CONTENT = "评价内容";
	public static final String ALIAS_CREATOR_TYPE = "creatorType";
	public static final String ALIAS_FROM_SYS = "fromSys";
	public static final String ALIAS_PATIENT_SEX = "patientSex";
	public static final String ALIAS_PATIENT_AGE = "patientAge";
	public static final String ALIAS_RECEIVE_TIME = "receiveTime";
	public static final String ALIAS_REVIEW_TIME = "评价时间";
	public static final String ALIAS_REVIEW_CHECK = "评价审核1=通过2=拒绝";
	public static final String ALIAS_USER_REPLY_TIME = "用户最后回复时间";
	public static final String ALIAS_DOCTOR_REPLY_TIME = "医生最后回复时间";
	
	private TconsultAttas tconsultAttas;
	
	public TconsultAttas getTconsultAttas() {
		return tconsultAttas;
	}

	public void setTconsultAttas(TconsultAttas tconsultAttas) {
		this.tconsultAttas = tconsultAttas;
	}

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 咨询ID       db_column: v_consult_id 
     */	
	
	private java.lang.Integer vconsultId;
    /**
     * 咨询对象（医生ID）       db_column: v_doctor_id 
     */	

	private java.lang.String vdoctorId;
    /**
     * 1=图文 2=语音留言 3=语音通话 4=视频       db_column: i_consult_way 
     */	
	
	private java.lang.Integer iconsultWay;
    /**
     * 发表时间       db_column: d_create_time 
     */	

	private java.lang.String dcreateTime;
    /**
     * 咨询内容       db_column: v_content 
     */	

	private java.lang.String vcontent;
    /**
     * 回复数       db_column: i_reply_num 
     */	
	
	private java.lang.Integer ireplyNum;
    /**
     * 处理开始时间       db_column: d_beg_time 
     */	

	private java.lang.String dbegTime;
    /**
     * 处理结束时间       db_column: d_end_time 
     */	

	private java.lang.String dendTime;
    /**
     * 医生处理咨询的状态：0=待处理;1=处理中就是咨询中;2=医生申请结束;10=待评价(完成);11 已评价   12=医生无应答，转诊处理       db_column: i_status 
     */	
	
	private java.lang.Integer istatus;
    /**
     * 状态时间       db_column: i_status_time 
     */	

	private java.lang.String istatusTime;
    /**
     * 评价结果: 1=满意, 0=待评价 ,2=不满意       db_column: i_result 
     */	

	private Integer iresult;
    /**
     * 不满意原因       db_column: v_reason 
     */	

	private java.lang.String vreason;
    /**
     * 顾客不满意运营处理状态：1=待处理；2=已处理       db_column: i_audit_status 
     */	
	
	private java.lang.Integer iauditStatus;
    /**
     * 咨询的用户id       db_column: v_userid 
     */	

	private java.lang.String vuserid;
    /**
     * 对应的产品套餐ID       db_column: v_product_id 
     */	
	
	private java.lang.String vproductId;
    /**
     * 运营处理结果备注       db_column: v_audit_demo 
     */	
	
	private java.lang.String vauditDemo;
    /**
     * 运营处理结果时间       db_column: v_audit_time 
     */	
	private java.lang.String vauditTime;
    /**
     * 该咨询正在拨号的ID       db_column: v_call_id 
     */	
	private java.lang.String vcallId;
    /**
     * 如果是客服发起的拨号，则此字段存客服的ID       db_column: v_call_staff 
     */	
	private java.lang.String vcallStaff;
    /**
     * 客服处理咨询的状态：0=客服未参与咨询；1=待处理；2=处理中；3=已处理 4=关闭(不需要处理)的咨询       db_column: i_status_staff 
     */	
	
	private java.lang.Integer istatusStaff;
    /**
     * 客服处理咨询的时间       db_column: d_status_staff 
     */	
	private java.lang.String dstatusStaff;
    /**
     * 是否为好友咨询：1=好友咨询；0=套餐咨询;2=作废好友咨询       db_column: is_friend 
     */	
	private Integer isFriend;
    /**
     * 评价内容       db_column: i_result_content 
     */	
	private java.lang.String iresultContent;
    /**
     * creatorType       db_column: creator_type 
     */	
	
	private java.lang.Integer creatorType;
    /**
     * fromSys       db_column: from_sys 
     */	
	private Integer fromSys;
    /**
     * patientSex       db_column: patient_sex 
     */	
	
	private java.lang.Integer patientSex;
    /**
     * patientAge       db_column: patient_age 
     */	
	
	private java.lang.Integer patientAge;
    /**
     * receiveTime       db_column: receive_time 
     */	
	private java.lang.Long receiveTime;
    /**
     * 评价时间       db_column: review_time 
     */	
	
	private java.util.Date reviewTime;
    /**
     * 评价审核1=通过2=拒绝       db_column: review_check 
     */	
	private java.lang.Integer reviewCheck;
    /**
     * 用户最后回复时间       db_column: user_reply_time 
     */	
	
	private java.util.Date userReplyTime;
    /**
     * 医生最后回复时间       db_column: doctor_reply_time 
     */	
	
	private java.util.Date doctorReplyTime;
	//columns END

	public TuserConsult(){
	}

	public TuserConsult(
		java.lang.Integer vconsultId
	){
		this.vconsultId = vconsultId;
	}

	public void setVconsultId(java.lang.Integer value) {
		this.vconsultId = value;
	}
	
	public java.lang.Integer getVconsultId() {
		return this.vconsultId;
	}
	public void setVdoctorId(java.lang.String value) {
		this.vdoctorId = value;
	}
	
	public java.lang.String getVdoctorId() {
		return this.vdoctorId;
	}
	public void setIconsultWay(java.lang.Integer value) {
		this.iconsultWay = value;
	}
	
	public java.lang.Integer getIconsultWay() {
		return this.iconsultWay;
	}
	public void setDcreateTime(java.lang.String value) {
		this.dcreateTime = value;
	}
	
	public java.lang.String getDcreateTime() {
		return this.dcreateTime;
	}
	public void setVcontent(java.lang.String value) {
		this.vcontent = value;
	}
	
	public java.lang.String getVcontent() {
		return this.vcontent;
	}
	public void setIreplyNum(java.lang.Integer value) {
		this.ireplyNum = value;
	}
	
	public java.lang.Integer getIreplyNum() {
		return this.ireplyNum;
	}
	public void setDbegTime(java.lang.String value) {
		this.dbegTime = value;
	}
	
	public java.lang.String getDbegTime() {
		return this.dbegTime;
	}
	public void setDendTime(java.lang.String value) {
		this.dendTime = value;
	}
	
	public java.lang.String getDendTime() {
		return this.dendTime;
	}
	public void setIstatus(java.lang.Integer value) {
		this.istatus = value;
	}
	
	public java.lang.Integer getIstatus() {
		return this.istatus;
	}
	public void setIstatusTime(java.lang.String value) {
		this.istatusTime = value;
	}
	
	public java.lang.String getIstatusTime() {
		return this.istatusTime;
	}
	public void setIresult(Integer value) {
		this.iresult = value;
	}
	
	public Integer getIresult() {
		return this.iresult;
	}
	public void setVreason(java.lang.String value) {
		this.vreason = value;
	}
	
	public java.lang.String getVreason() {
		return this.vreason;
	}
	public void setIauditStatus(java.lang.Integer value) {
		this.iauditStatus = value;
	}
	
	public java.lang.Integer getIauditStatus() {
		return this.iauditStatus;
	}
	public void setVuserid(java.lang.String value) {
		this.vuserid = value;
	}
	
	public java.lang.String getVuserid() {
		return this.vuserid;
	}
	public void setVproductId(java.lang.String value) {
		this.vproductId = value;
	}
	
	public java.lang.String getVproductId() {
		return this.vproductId;
	}
	public void setVauditDemo(java.lang.String value) {
		this.vauditDemo = value;
	}
	
	public java.lang.String getVauditDemo() {
		return this.vauditDemo;
	}
	public void setVauditTime(java.lang.String value) {
		this.vauditTime = value;
	}
	
	public java.lang.String getVauditTime() {
		return this.vauditTime;
	}
	public void setVcallId(java.lang.String value) {
		this.vcallId = value;
	}
	
	public java.lang.String getVcallId() {
		return this.vcallId;
	}
	public void setVcallStaff(java.lang.String value) {
		this.vcallStaff = value;
	}
	
	public java.lang.String getVcallStaff() {
		return this.vcallStaff;
	}
	public void setIstatusStaff(java.lang.Integer value) {
		this.istatusStaff = value;
	}
	
	public java.lang.Integer getIstatusStaff() {
		return this.istatusStaff;
	}
	public void setDstatusStaff(java.lang.String value) {
		this.dstatusStaff = value;
	}
	
	public java.lang.String getDstatusStaff() {
		return this.dstatusStaff;
	}
	public void setIsFriend(Integer value) {
		this.isFriend = value;
	}
	
	public Integer getIsFriend() {
		return this.isFriend;
	}
	public void setIresultContent(java.lang.String value) {
		this.iresultContent = value;
	}
	
	public java.lang.String getIresultContent() {
		return this.iresultContent;
	}
	public void setCreatorType(java.lang.Integer value) {
		this.creatorType = value;
	}
	
	public java.lang.Integer getCreatorType() {
		return this.creatorType;
	}
	public void setFromSys(Integer value) {
		this.fromSys = value;
	}
	
	public Integer getFromSys() {
		return this.fromSys;
	}
	public void setPatientSex(java.lang.Integer value) {
		this.patientSex = value;
	}
	
	public java.lang.Integer getPatientSex() {
		return this.patientSex;
	}
	public void setPatientAge(java.lang.Integer value) {
		this.patientAge = value;
	}
	
	public java.lang.Integer getPatientAge() {
		return this.patientAge;
	}
	public void setReceiveTime(java.lang.Long value) {
		this.receiveTime = value;
	}
	
	public java.lang.Long getReceiveTime() {
		return this.receiveTime;
	}
	
	
	public void setReviewTime(java.util.Date value) {
		this.reviewTime = value;
	}
	
	public java.util.Date getReviewTime() {
		return this.reviewTime;
	}
	public void setReviewCheck(java.lang.Integer value) {
		this.reviewCheck = value;
	}
	
	public java.lang.Integer getReviewCheck() {
		return this.reviewCheck;
	}
	
	
	public void setUserReplyTime(java.util.Date value) {
		this.userReplyTime = value;
	}
	
	public java.util.Date getUserReplyTime() {
		return this.userReplyTime;
	}
	
	
	public void setDoctorReplyTime(java.util.Date value) {
		this.doctorReplyTime = value;
	}
	
	public java.util.Date getDoctorReplyTime() {
		return this.doctorReplyTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("VconsultId",getVconsultId())
			.append("VdoctorId",getVdoctorId())
			.append("IconsultWay",getIconsultWay())
			.append("DcreateTime",getDcreateTime())
			.append("Vcontent",getVcontent())
			.append("IreplyNum",getIreplyNum())
			.append("DbegTime",getDbegTime())
			.append("DendTime",getDendTime())
			.append("Istatus",getIstatus())
			.append("IstatusTime",getIstatusTime())
			.append("Iresult",getIresult())
			.append("Vreason",getVreason())
			.append("IauditStatus",getIauditStatus())
			.append("Vuserid",getVuserid())
			.append("VproductId",getVproductId())
			.append("VauditDemo",getVauditDemo())
			.append("VauditTime",getVauditTime())
			.append("VcallId",getVcallId())
			.append("VcallStaff",getVcallStaff())
			.append("IstatusStaff",getIstatusStaff())
			.append("DstatusStaff",getDstatusStaff())
			.append("IsFriend",getIsFriend())
			.append("IresultContent",getIresultContent())
			.append("CreatorType",getCreatorType())
			.append("FromSys",getFromSys())
			.append("PatientSex",getPatientSex())
			.append("PatientAge",getPatientAge())
			.append("ReceiveTime",getReceiveTime())
			.append("ReviewTime",getReviewTime())
			.append("ReviewCheck",getReviewCheck())
			.append("UserReplyTime",getUserReplyTime())
			.append("DoctorReplyTime",getDoctorReplyTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getVconsultId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TuserConsult == false) return false;
		if(this == obj) return true;
		TuserConsult other = (TuserConsult)obj;
		return new EqualsBuilder()
			.append(getVconsultId(),other.getVconsultId())
			.isEquals();
	}
}

