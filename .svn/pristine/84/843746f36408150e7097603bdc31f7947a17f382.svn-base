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


public class TconsultAttas extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "TconsultAttas";
	public static final String ALIAS_VATTACH_ID = "附件ID";
	public static final String ALIAS_VCONSULT_ID = "咨询ID";
	public static final String ALIAS_VFILE = "存放路径";
	public static final String ALIAS_IIS_DOCMENT = "是否健康档案:1=是;0或空表示不是";
	public static final String ALIAS_DUP_DATE = "上传日期";
	public static final String ALIAS_ISTATUS = "审核状态:0=无效, 1=有效";
	public static final String ALIAS_VUSERID = "上传用户Id";
	public static final String ALIAS_VDESC = "附件描述";
	public static final String ALIAS_VTYPE = "附件类型: 1: 用户上传 2: 客服上传";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 附件ID       db_column: v_attach_id 
     */	
	
	private java.lang.Integer vattachId;
    /**
     * 咨询ID       db_column: v_consult_id 
     */	
	private java.lang.String vconsultId;
    /**
     * 存放路径       db_column: v_file 
     */	
	private java.lang.String vfile;
    /**
     * 是否健康档案:1=是;0或空表示不是       db_column: i_is_docment 
     */	
	
	private java.lang.Integer iisDocment;
    /**
     * 上传日期       db_column: d_up_date 
     */	
	private java.lang.String dupDate;
    /**
     * 审核状态:0=无效, 1=有效       db_column: i_status 
     */	
	
	private java.lang.Integer istatus;
    /**
     * 上传用户Id       db_column: v_userid 
     */	
	private java.lang.String vuserid;
    /**
     * 附件描述       db_column: v_desc 
     */	
	private java.lang.String vdesc;
    /**
     * 附件类型: 1: 用户上传 2: 客服上传       db_column: v_type 
     */	
	
	private java.lang.Integer vtype;
	//columns END

	public TconsultAttas(){
	}

	public TconsultAttas(
		java.lang.Integer vattachId
	){
		this.vattachId = vattachId;
	}

	public void setVattachId(java.lang.Integer value) {
		this.vattachId = value;
	}
	
	public java.lang.Integer getVattachId() {
		return this.vattachId;
	}
	public void setVconsultId(java.lang.String value) {
		this.vconsultId = value;
	}
	
	public java.lang.String getVconsultId() {
		return this.vconsultId;
	}
	public void setVfile(java.lang.String value) {
		this.vfile = value;
	}
	
	public java.lang.String getVfile() {
		return this.vfile;
	}
	public void setIisDocment(java.lang.Integer value) {
		this.iisDocment = value;
	}
	
	public java.lang.Integer getIisDocment() {
		return this.iisDocment;
	}
	public void setDupDate(java.lang.String value) {
		this.dupDate = value;
	}
	
	public java.lang.String getDupDate() {
		return this.dupDate;
	}
	public void setIstatus(java.lang.Integer value) {
		this.istatus = value;
	}
	
	public java.lang.Integer getIstatus() {
		return this.istatus;
	}
	public void setVuserid(java.lang.String value) {
		this.vuserid = value;
	}
	
	public java.lang.String getVuserid() {
		return this.vuserid;
	}
	public void setVdesc(java.lang.String value) {
		this.vdesc = value;
	}
	
	public java.lang.String getVdesc() {
		return this.vdesc;
	}
	public void setVtype(java.lang.Integer value) {
		this.vtype = value;
	}
	
	public java.lang.Integer getVtype() {
		return this.vtype;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("VattachId",getVattachId())
			.append("VconsultId",getVconsultId())
			.append("Vfile",getVfile())
			.append("IisDocment",getIisDocment())
			.append("DupDate",getDupDate())
			.append("Istatus",getIstatus())
			.append("Vuserid",getVuserid())
			.append("Vdesc",getVdesc())
			.append("Vtype",getVtype())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getVattachId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TconsultAttas == false) return false;
		if(this == obj) return true;
		TconsultAttas other = (TconsultAttas)obj;
		return new EqualsBuilder()
			.append(getVattachId(),other.getVattachId())
			.isEquals();
	}
}

