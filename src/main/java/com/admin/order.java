package com.admin;

public class order {
	private String title;
	private int orderId;
	private int userId;
	private int guiderId;
	private int price;
	private String date;
	private int packageId;
	
	/*String paymentMethod;*/
	
	
	public order(int orderId,String title, int guiderId,int uid, int price, String date) {
		super();
		this.orderId = orderId;
		this.title = title;
		this.userId = uid;
		this.guiderId = guiderId;
		this.price = price;
		this.date = date;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getGuiderId() {
		return guiderId;
	}
	public void setGuiderId(int guiderId) {
		this.guiderId = guiderId;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTitle(String tit) {
		this.title = tit;
	}
	public String getTitle() {
		return this.title;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	
	

}
