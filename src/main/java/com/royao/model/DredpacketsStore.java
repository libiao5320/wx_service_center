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


public class DredpacketsStore extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "DredpacketsStore";
    public static final String ALIAS_REDPACKETS_ID = "主红包ID";
    public static final String ALIAS_STORE_ID = "合作商家ID";

    //date formats

    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long redpacketsId;

    private Long storeId;
    //columns END

    public DredpacketsStore() {
    }


    public void setRedpacketsId(Long value) {
        this.redpacketsId = value;
    }

    public Long getRedpacketsId() {
        return this.redpacketsId;
    }

    public void setStoreId(Long value) {
        this.storeId = value;
    }

    public Long getStoreId() {
        return this.storeId;
    }


}

