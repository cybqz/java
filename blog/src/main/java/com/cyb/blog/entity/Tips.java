package com.cyb.blog.entity;

public class Tips {

	private String msg;
	
	private boolean show = true;
	
	private boolean validate;
	
	public Tips(String msg, boolean validate) {
		super();
		this.msg = msg;
		this.validate = validate;
	}
	
	public Tips(String msg, boolean show, boolean validate) {
		super();
		this.msg = msg;
		this.show = show;
		this.validate = validate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}
}
