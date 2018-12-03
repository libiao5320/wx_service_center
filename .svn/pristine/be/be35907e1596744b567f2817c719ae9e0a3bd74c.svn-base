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


public class TconsultReply extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TconsultReply";
	public static final String ALIAS_VREPLY_ID = "回复ID";
	public static final String ALIAS_VCONSULT_ID = "咨询ID";
	public static final String ALIAS_IREPLY_TYPE = "1=医生 2=用户 3=客服 4=匿名用户";
	public static final String ALIAS_IREPLY_WAY = "1=图文 2=语音留言 3=语音通话 4=视频";
	public static final String ALIAS_VREPLER_ID = "回复者";
	public static final String ALIAS_VREPLY_CONTENT = "回复内容";
	public static final String ALIAS_DCREATE_DATE = "回复时间";
	public static final String ALIAS_DBEG_TIME = "开始时间";
	public static final String ALIAS_DEND_TIME = "结束时间";
	public static final String ALIAS_IAUDIT_STATUS = "状态。审核状态 0=禁止展现 1=允许展现";
	public static final String ALIAS_VFILE = "文件路径";
	public static final String ALIAS_RE_END = "是否结束此次咨询：1=医生发起结束询问；0=咨询中";
	public static final String ALIAS_MSGID = "容联消息ID";
	public static final String ALIAS_OBJECT_ID = "推荐对象id";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 回复ID       db_column: v_reply_id 
     */	
	
	private java.lang.Integer vreplyId;
    /**
     * 咨询ID       db_column: v_consult_id 
     */	
	private java.lang.String vconsultId;
    /**
     * 1=医生 2=用户 3=客服 4=匿名用户       db_column: i_reply_type 
     */	

	private java.lang.Integer ireplyType;
    /**
     * 1=图文 2=语音留言 3=语音通话 4=视频       db_column: i_reply_way 
     */	
	
	private java.lang.Integer ireplyWay;
    /**
     * 回复者       db_column: v_repler_id 
     */	

	private java.lang.String vreplerId;
    /**
     * 回复内容       db_column: v_reply_content 
     */	

	private java.lang.String vreplyContent;
    /**
     * 回复时间       db_column: d_create_date 
     */	

	private java.lang.String dcreateDate;
    /**
     * 开始时间       db_column: d_beg_time 
     */	

	private java.lang.String dbegTime;
    /**
     * 结束时间       db_column: d_end_time 
     */	

	private java.lang.String dendTime;
    /**
     * 状态。审核状态 0=禁止展现 1=允许展现       db_column: i_audit_status 
     */	
	
	private java.lang.Integer iauditStatus;
    /**
     * 文件路径       db_column: v_file 
     */	

	private java.lang.String vfile;
    /**
     * 是否结束此次咨询：1=医生发起结束询问；0=咨询中       db_column: re_end 
     */	

	private Integer reEnd;
    /**
     * 容联消息ID       db_column: msgid 
     */	

	private java.lang.String msgid;
    /**
     * 推荐对象id       db_column: object_id 
     */	
	
	private java.lang.Integer objectId;
	//columns END

	public TconsultReply(){
	}

	public TconsultReply(
		java.lang.Integer vreplyId
	){
		this.vreplyId = vreplyId;
	}

	public void setVreplyId(java.lang.Integer value) {
		this.vreplyId = value;
	}
	
	public java.lang.Integer getVreplyId() {
		return this.vreplyId;
	}
	public void setVconsultId(java.lang.String value) {
		this.vconsultId = value;
	}
	
	public java.lang.String getVconsultId() {
		return this.vconsultId;
	}
	public void setIreplyType(java.lang.Integer value) {
		this.ireplyType = value;
	}
	
	public java.lang.Integer getIreplyType() {
		return this.ireplyType;
	}
	public void setIreplyWay(java.lang.Integer value) {
		this.ireplyWay = value;
	}
	
	public java.lang.Integer getIreplyWay() {
		return this.ireplyWay;
	}
	public void setVreplerId(java.lang.String value) {
		this.vreplerId = value;
	}
	
	public java.lang.String getVreplerId() {
		return this.vreplerId;
	}
	public void setVreplyContent(java.lang.String value) {
		this.vreplyContent = value;
	}
	
	public java.lang.String getVreplyContent() {
		return this.vreplyContent;
	}
	public void setDcreateDate(java.lang.String value) {
		this.dcreateDate = value;
	}
	
	public java.lang.String getDcreateDate() {
		return this.dcreateDate;
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
	public void setIauditStatus(java.lang.Integer value) {
		this.iauditStatus = value;
	}
	
	public java.lang.Integer getIauditStatus() {
		return this.iauditStatus;
	}
	public void setVfile(java.lang.String value) {
		this.vfile = value;
	}
	
	public java.lang.String getVfile() {
		return this.vfile;
	}
	public void setReEnd(Integer value) {
		this.reEnd = value;
	}
	
	public Integer getReEnd() {
		return this.reEnd;
	}
	public void setMsgid(java.lang.String value) {
		this.msgid = value;
	}
	
	public java.lang.String getMsgid() {
		return this.msgid;
	}
	public void setObjectId(java.lang.Integer value) {
		this.objectId = value;
	}
	
	public java.lang.Integer getObjectId() {
		return this.objectId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("VreplyId",getVreplyId())
			.append("VconsultId",getVconsultId())
			.append("IreplyType",getIreplyType())
			.append("IreplyWay",getIreplyWay())
			.append("VreplerId",getVreplerId())
			.append("VreplyContent",getVreplyContent())
			.append("DcreateDate",getDcreateDate())
			.append("DbegTime",getDbegTime())
			.append("DendTime",getDendTime())
			.append("IauditStatus",getIauditStatus())
			.append("Vfile",getVfile())
			.append("ReEnd",getReEnd())
			.append("Msgid",getMsgid())
			.append("ObjectId",getObjectId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getVreplyId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TconsultReply == false) return false;
		if(this == obj) return true;
		TconsultReply other = (TconsultReply)obj;
		return new EqualsBuilder()
			.append(getVreplyId(),other.getVreplyId())
			.isEquals();
	}
}

