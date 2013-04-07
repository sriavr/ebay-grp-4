package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.SellerProductUpdationDAO;
import edu.iiitb.ebay.model.entity.ProductModel;

public class UpdateProdDetailsBySeller extends ActionSupport{
	private int quantity;
	private int discount;
	private int productId;
	private int price;

	
	public String execute(){
		
		SellerProductUpdationDAO sellerDAO = new SellerProductUpdationDAO();
		ProductModel productUpdate = new ProductModel();
		
		System.out.println("product Id "+ getProductId() + " quantity : " + getQuantity() + " discount : " + getDiscount() +" price : " + getPrice());
		
		productUpdate.setProductId(getProductId());
		productUpdate.setQuantity(getQuantity());
		productUpdate.setDiscount(getDiscount());
		productUpdate.setPrice(getPrice());
		
		//updating the quantity,price & discount of a product by a seller
		sellerDAO.updateDetails(productUpdate);
		
		return SUCCESS;
		
	}
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	
}
