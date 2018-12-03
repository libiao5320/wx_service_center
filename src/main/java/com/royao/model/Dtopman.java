/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.commons.enums.YN;
import com.royao.model.base.BaseEntity;
import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Dtopman extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "Dtopman";
    public static final String ALIAS_ID = "id";
    public static final String ALIAS_MEMBER_ID = "memberId";
    public static final String ALIAS_REASON = "申请理由";
    public static final String ALIAS_STATUS = "审核状态，examining-待审核(审核中)，unexamine-未通过，examined-通过";
    public static final String ALIAS_REMARK = "备注，一般是审核拒绝的原由";
    public static final String ALIAS_CREATE_TIME = "申请时间";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private Long memberId;
    private String memberName;
    private String memberMobile;
    
    private String industry;
    private String  job ;
    private YN ifMeadia;
    private YN ifHaveMediaRes;
    private YN ifSpecial;
    private YN ifHavePubRes;
    private String reason;


    private String status;

    private String remark;

    private Date createTime;
    
    private String strCreateTime;
    //columns END
    
    private Dmember member;

    public Dmember getMember() {
		return member;
	}

	public void setMember(Dmember member) {
		this.member = member;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberMobile() {
		return memberMobile;
	}

	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}

	public Dtopman() {
    }

    public Dtopman(
            Long id
    ) {
        this.id = id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setMemberId(Long value) {
        this.memberId = value;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setReason(String value) {
        this.reason = value;
    }

    public String getReason() {
        return this.reason;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public String getStatus() {
        return this.status;
    }

    public void setRemark(String value) {
        this.remark = value;
    }

    public String getRemark() {
        return this.remark;
    }


    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public YN getIfMeadia() {
        return ifMeadia;
    }

    public void setIfMeadia(YN ifMeadia) {
        this.ifMeadia = ifMeadia;
    }

    public YN getIfHaveMediaRes() {
        return ifHaveMediaRes;
    }

    public void setIfHaveMediaRes(YN ifHaveMediaRes) {
        this.ifHaveMediaRes = ifHaveMediaRes;
    }

    public YN getIfSpecial() {
        return ifSpecial;
    }

    public void setIfSpecial(YN ifSpecial) {
        this.ifSpecial = ifSpecial;
    }

    public YN getIfHavePubRes() {
        return ifHavePubRes;
    }

    public void setIfHavePubRes(YN ifHavePubRes) {
        this.ifHavePubRes = ifHavePubRes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getStrCreateTime() {
		if(createTime != null){
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strCreateTime = sd.format(createTime);
		}
		
		return strCreateTime;
	}

	public void setStrCreateTime(String strCreateTime) {
		this.strCreateTime = strCreateTime;
	}
}

