package com.cqjtu.vo;

public class Order {
	private int orderId;
	private String userPhone;
	private String fixerPhone;
	private double bill;
	private String comment;
	private String createTime;
	private String orderInfo;
	

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getFixerPhone() {
		return fixerPhone;
	}

	public void setFixerPhone(String fixerPhone) {
		this.fixerPhone = fixerPhone;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Order() {
	}

	public Order(int id, String uname, String fname, double obill,
			String ocomment, String time) {
		orderId = id;
		userPhone = uname;
		fixerPhone = fname;
		bill = obill;
		comment = ocomment;
		createTime = time;
	}

}
