package com.royao.model;

import java.io.Serializable;

import com.royao.model.base.BaseEntity;

/**
 * 
 * ClassName: DmemberExtend 
 * @Description: 用户拓展表
 * @author Liu Pinghui
 * @date 2016年1月25日
 */
public class DmemberExtend extends BaseEntity implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 8805275253755343313L;

	private Long memberId;
	
	private String eventIsKnow;	//是否知道分享有礼
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getEventIsKnow() {
		return eventIsKnow;
	}

	public void setEventIsKnow(String eventIsKnow) {
		this.eventIsKnow = eventIsKnow;
	}
}
