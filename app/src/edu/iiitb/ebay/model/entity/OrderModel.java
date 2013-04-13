package edu.iiitb.ebay.model.entity;

import java.sql.Date;

public class OrderModel {
	int orderId;
	int userId;
	int sellerId;
	int productId;
	int transactionId;
	int quantity;
	String currentStatus;
	Date orderPlacedDate;
	Date statusUpdateDate;
	Date shipped;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
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
	public Date getStatusUpdateDate() {
		return statusUpdateDate;
	}
	public void setStatusUpdateDate(Date statusUpdateDate) {
		this.statusUpdateDate = statusUpdateDate;
	}
	public Date getShipped() {
		return shipped;
	}
	public void setShipped(Date shipped) {
		this.shipped = shipped;
	}
}
