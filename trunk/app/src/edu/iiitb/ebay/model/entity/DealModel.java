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
	private int productId;
	private Date dealStartDate;
	private Date dealEndDate;
	private int dealSellingPrice;
	private int productDiscountPercent;
	private ProductModel product;
	public int getDealsId() {
		return dealsId;
	}
	
	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public void setDealsId(int dealsId) {
		this.dealsId = dealsId;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getProductDiscountPercent() {
		return productDiscountPercent;
	}
	public void setProductDiscountPercent(int productDiscountPercent) {
		this.productDiscountPercent = productDiscountPercent;
	}
	
	
}
