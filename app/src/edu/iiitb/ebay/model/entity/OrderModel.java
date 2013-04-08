package edu.iiitb.ebay.model.entity;

import java.util.Date;

/**
 * @author Ranadheer K
 * @version 1.0
 */

public class OrderModel {

	private int orderId;
	private int userId;
	private int sellerId;
	private int productId;
	private int transactionId;
	private String currentStatus;
	private Date orderPlacedDate;
	private Date statusUpdatedDate;
	private Date shipped;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public Date getOrderPlacedDate() {
		return orderPlacedDate;
	}
	public void setOrderPlacedDate(Date orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}
	public Date getStatusUpdatedDate() {
		return statusUpdatedDate;
	}
	public void setStatusUpdatedDate(Date statusUpdatedDate) {
		this.statusUpdatedDate = statusUpdatedDate;
	}
	public Date getShipped() {
		return shipped;
	}
	public void setShipped(Date shipped) {
		this.shipped = shipped;
	}
}
