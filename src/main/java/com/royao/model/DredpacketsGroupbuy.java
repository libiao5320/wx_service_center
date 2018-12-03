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


public class DredpacketsGroupbuy extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "DredpacketsGroupbuy";
    public static final String ALIAS_REDPACKETS_ID = "红包ID";
    public static final String ALIAS_GROUPBUY_ID = "类目ID";

    //date formats

    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long redpacketsId;

    private Long groupbuyId;
    //columns END

    public DredpacketsGroupbuy() {
    }


    public void setRedpacketsId(Long value) {
        this.redpacketsId = value;
    }

    public Long getRedpacketsId() {
        return this.redpacketsId;
    }

    public void setGroupbuyId(Long value) {
        this.groupbuyId = value;
    }

    public Long getGroupbuyId() {
        return this.groupbuyId;
    }


}

