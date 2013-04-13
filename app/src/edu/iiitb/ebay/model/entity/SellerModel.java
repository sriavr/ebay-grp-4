package edu.iiitb.ebay.model.entity;

public class SellerModel {

	private Integer sellerId;
	private String dateOfRegistration;
	private String location;
	private int feedbackScore;
	private int positivFeedBack;
	private int userId;
	private int sla;
	private String sellerName;

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

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

}
