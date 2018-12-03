package com.royao.http;

import java.io.Serializable;

public class JsonContent implements Serializable {
	private static final long serialVersionUID = 1463512953214716597L;
	private String info;
	private int status;
	private int code;
	private String msg;
	private Object data;

	public JsonContent(){
		
	}
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
