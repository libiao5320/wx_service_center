/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.model.base.BaseEntity;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class Dcollect extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "Dcollect";
    public static final String ALIAS_ID = "id";
    public static final String ALIAS_MEMBER_ID = "用户ID";
    public static final String ALIAS_TYPE = "收藏的类型，goods-产品(服务)，store-店铺";
    public static final String ALIAS_COMMON_ID = "如果用户收藏的是产品，那么这里对应的是产品ID，如果用户收藏的是店铺，那么这里对应的则是店铺ID";

    //date formats

    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private Long memberId;

    private String type;

    private Long commonId;

    private Dgoods good;
    private Dstore store;

    //columns END
    
    private boolean status;//用作前台判断

    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Dcollect() {
    }

    public Dcollect(
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

    public void setType(String value) {
        this.type = value;
    }

    public String getType() {
        return this.type;
    }

    public void setCommonId(Long value) {
        this.commonId = value;
    }

    public Long getCommonId() {
        return this.commonId;
    }

    public Dstore getStore() {
        return store;
    }

    public void setStore(Dstore store) {
        this.store = store;
    }

    public Dgoods getGood() {
        return good;
    }

    public void setGood(Dgoods good) {
        this.good = good;
    }
}

