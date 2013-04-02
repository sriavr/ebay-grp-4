package edu.iiitb.ebay.model.entity;

public class SellerModel {
	
	Integer sellerId;
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getFeedbackScore() {
		return feedbackScore;
	}
	public void setFeedbackScore(int feedbackScore) {
		this.feedbackScore = feedbackScore;
	}
	public int getPositivFeedBack() {
		return positivFeedBack;
	}
	public void setPositivFeedBack(int positivFeedBack) {
		this.positivFeedBack = positivFeedBack;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSla() {
		return sla;
	}
	public void setSla(int sla) {
		this.sla = sla;
	}
	String dateOfRegistration;
	String location;
	int feedbackScore;
	int positivFeedBack;
	int userId;
	int sla;
	
	

}
