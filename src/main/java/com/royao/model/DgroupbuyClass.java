/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.model;


import java.util.List;

import com.royao.model.base.BaseEntity;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class DgroupbuyClass extends BaseEntity implements java.io.Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    //alias
    public static final String TABLE_ALIAS = "DgroupbuyClass";
    public static final String ALIAS_CLASS_ID = "类别id";
    public static final String ALIAS_CLASS_NAME = "类别名称";
    public static final String ALIAS_CLASS_PARENT_ID = "父类别编号";
    public static final String ALIAS_SORT = "排序";
    public static final String ALIAS_DEEP = "深度";

    //date formats

    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START

    private Long classId;

    private String className;

    private Long classParentId;

    private String classImg ;

    private Integer sort;

    private Integer deep;
    //columns END
    
    private String secondClass;//子类名称
    
    private String firstClass;//父类名称
    
    public String getSecondClass() {
		return secondClass;
	}

	public void setSecondClass(String secondClass) {
		this.secondClass = secondClass;
	}

	public String getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(String firstClass) {
		this.firstClass = firstClass;
	}

	private List<DgroupbuyClass> groupbuyList;
    
	public List<DgroupbuyClass> getGroupbuyList() {
		return groupbuyList;
	}

	public void setGroupbuyList(List<DgroupbuyClass> groupbuyList) {
		this.groupbuyList = groupbuyList;
	}

	public DgroupbuyClass() {
    }

    public DgroupbuyClass(
            Long classId
    ) {
        this.classId = classId;
    }

    public void setClassId(Long value) {
        this.classId = value;
    }

    public Long getClassId() {
        return this.classId;
    }

    public void setClassName(String value) {
        this.className = value;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassParentId(Long classParentId) {
        this.classParentId = classParentId;
    }

    public Long getClassParentId() {
        return this.classParentId;
    }

    public void setSort(Integer value) {
        this.sort = value;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setDeep(Integer value) {
        this.deep = value;
    }

    public Integer getDeep() {
        return this.deep;
    }

    public String getClassImg() {
        return this.classImg;
    }

    public void setClassImg(String classImg) {
        this.classImg = classImg;
    }
}

