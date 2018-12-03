/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import com.royao.commons.enums.YN;
import com.royao.model.base.BaseEntity;

import java.util.Date;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DwxBanner extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "DwxBanner";
    public static final String ALIAS_ID = "id";
    public static final String ALIAS_REDPACKETS_ID = "关联的红包ID";
    public static final String ALIAS_NAME = "活动名称";
    public static final String ALIAS_IMG = "活动图片地址";
    public static final String ALIAS_ISSHOW = "是否显示";
    public static final String ALIAS_ORDER_BY = "排序，值越小越靠前";
    public static final String ALIAS_URL = "跳转的url";
    public static final String ALIAS_START_TIME = "开始时间";
    public static final String ALIAS_END_TIME = "结束时间";


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long id;

    private Long redpacketsId;

    private String name;

    private String img;

    private YN isShow;

    private Integer orderBy;

    private String url;

    private Date startTime;

    private Date endTime;
    private Long areaId;
    private String areaName;
    
    //columns END

    public DwxBanner() {
    }

    public DwxBanner(
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

    public void setRedpacketsId(Long value) {
        this.redpacketsId = value;
    }

    public Long getRedpacketsId() {
        return this.redpacketsId;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setImg(String value) {
        this.img = value;
    }

    public String getImg() {
        return this.img;
    }

    public YN getIsShow() {
        return isShow;
    }

    public void setIsShow(YN isShow) {
        this.isShow = isShow;
    }

    public void setOrderBy(Integer value) {
        this.orderBy = value;
    }

    public Integer getOrderBy() {
        return this.orderBy;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getUrl() {
        return this.url;
    }


    public void setStartTime(Date value) {
        this.startTime = value;
    }

    public Date getStartTime() {
        return this.startTime;
    }


    public void setEndTime(Date value) {
        this.endTime = value;
    }

    public Date getEndTime() {
        return this.endTime;
    }

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
    
    

}

