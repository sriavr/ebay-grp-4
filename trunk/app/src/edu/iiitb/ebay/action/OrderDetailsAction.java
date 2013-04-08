package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.ProductDetailsDAO;
import edu.iiitb.ebay.dao.SellerSoldProductsDAO;
import edu.iiitb.ebay.dao.UserDAO;
import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class OrderDetailsAction extends ActionSupport{

	int orderId;
	int productId;
	int userId;
	String currentStatus;
	int hiddenStatus;
	public  OrderModel ordersList = new OrderModel();
	private ProductModel product=new ProductModel();
	private UserModel user =new UserModel();
	
	
	public String execute(){

		SellerSoldProductsDAO sellerDAO  = new SellerSoldProductsDAO();
		ProductDetailsDAO productDetails = new ProductDetailsDAO();
		UserDAO userDetails = new UserDAO();
			
		//get the order related details such as product, user information etc.
		
		//get the product id and user id of that particular order
		System.out.println("order id :" +orderId);
		
		productId =sellerDAO.getProductId(getOrderId());
		userId =sellerDAO.getUserId(getOrderId());
		currentStatus = sellerDAO.getCurrentStatus(getOrderId());
		System.out.println("product id :" +productId +"userId: " + userId +"status:" + currentStatus);
		 
		//if the product is not shipped ... make the hiddenStatus as 0 if not to 1
		if(!currentStatus.equalsIgnoreCase("shipped")){
			hiddenStatus = 0;
		}
		else{
			hiddenStatus = 1;
		}
		setProduct(productDetails.getProductDetails(productId));
		setUser(userDetails.getUserDetails(userId));
		return SUCCESS;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public OrderModel getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(OrderModel ordersList) {
		this.ordersList = ordersList;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public int getHiddenStatus() {
		return hiddenStatus;
	}

	public void setHiddenStatus(int hiddenStatus) {
		this.hiddenStatus = hiddenStatus;
	}
}
