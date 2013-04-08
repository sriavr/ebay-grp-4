package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.SubmitFeedBackDAO;
import edu.iiitb.ebay.model.entity.SubmitFeedBackModel;

public class SubmitFeedBackAction extends ActionSupport {
	
	private int rate1;
	private int rate2;
	private int rate3;
	private String rate;
	private String description;
	private int productId;
	private int userId;
	private int sellerId;
	
	

	public int getRate1() {
		return rate1;
	}

	public void setRate1(int rate1) {
		this.rate1 = rate1;
	}

	public int getRate2() {
		return rate2;
	}

	public void setRate2(int rate2) {
		this.rate2 = rate2;
	}

	public int getRate3() {
		return rate3;
	}

	public void setRate3(int rate3) {
		this.rate3 = rate3;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public String execute(){
		
		SubmitFeedBackModel submitfeedbackmodel=new SubmitFeedBackModel();
		submitfeedbackmodel.setUserId(userId);
		submitfeedbackmodel.setProductId(productId);
		submitfeedbackmodel.setSellerId(sellerId);
		submitfeedbackmodel.setRate(rate);
		submitfeedbackmodel.setRate1(rate1);
		submitfeedbackmodel.setRate2(rate2);
		submitfeedbackmodel.setRate3(rate3);
		submitfeedbackmodel.setDescription(description);
		
		SubmitFeedBackDAO submitfeedbackDAO=new SubmitFeedBackDAO();
		
		submitfeedbackDAO.submitFeedback(submitfeedbackmodel);
		
		return "success";
	}
	

}
