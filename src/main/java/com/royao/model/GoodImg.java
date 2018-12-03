package com.royao.model;

import com.royao.commons.enums.YN;

import java.io.Serializable;

/**
 * Created by libia on 2016/2/3.
 */
public class GoodImg implements Serializable {

    private Long id;
    private Integer goodId;
    private String img;
    private String createDate;
    private YN isMain;


    public YN getIsMain() {
        return isMain;
    }

    public void setIsMain(YN isMain) {
        this.isMain = isMain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
