package edu.iiitb.ebay.action;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.PurchaseHistoryDAO;
import edu.iiitb.ebay.model.entity.ProductModel;

public class LeaveFeedBackAction extends ActionSupport {
	
	private int productId;
	private int userId;
	private int sellerId;
	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	private ProductModel product;
	private ArrayList<String> ratings=new ArrayList<String>();
	private static final String Positive = "positive";
	private static final String Negative = "negative";
	private static final String Neutral = "neutral";
	private String defaultValue="positive";
	
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public ArrayList<String> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<String> ratings) {
		this.ratings = ratings;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
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

	public String execute(){
		
		ratings.add(Positive);
		ratings.add(Negative);
		ratings.add(Neutral);
		
		PurchaseHistoryDAO purchasehistoryDAO=new PurchaseHistoryDAO();
		
		if(productId!=0)
			setProduct(purchasehistoryDAO.getProductDetails(productId));
		
		
		System.out.println("hai I amnnn in execute");
	return "success";
	}
	
}
