/**
 * 
 */
package edu.iiitb.ebay.model.entity;

import java.sql.Date;
import java.util.Calendar;

/**
 * @author Pavan
 * 
 */
public class DealModel extends ProductModel {
	private int dealsId;
	private Date dealStartDate;
	private Date dealEndDate;
	private int dealSellingPrice;

	public int getDealsId() {
		return dealsId;
	}

	public void setDealsId(int dealsId) {
		this.dealsId = dealsId;
	}

	public Date getDealStartDate() {
		return dealStartDate;
	}

	public void setDealStartDate(Date dealStartDate) {
		this.dealStartDate = dealStartDate;
	}

	public Date getDealEndDate() {
		return dealEndDate;
	}

	public void setDealEndDate(Date dealEndDate) {
		this.dealEndDate = dealEndDate;
	}

	public int getDealSellingPrice() {
		return dealSellingPrice;
	}

	public void setDealSellingPrice(int dealSellingPrice) {
		this.dealSellingPrice = dealSellingPrice;
	}

	@Override
	public String toString() {
		String temp = "";
		temp = "dealsId:" + dealsId + ", dealStartDate:" + dealStartDate
				+ ", dealEndDate:" + dealEndDate + ", dealSellingPrice:"
				+ dealSellingPrice + ", productId:" + productId
				+ ", sellerId:" + sellerId + ", title:" + title
				+ ", description:" + description + ", price:" + price
				+ ", quantity:" + quantity + ", photo:" + photo + ", "
				+ discount;
		return temp;
	}

}
