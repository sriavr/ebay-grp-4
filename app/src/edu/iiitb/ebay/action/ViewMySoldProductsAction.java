package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.*;
import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class ViewMySoldProductsAction extends ActionSupport{

	int SellerId;
	public ArrayList<OrderModel> ordersList = new ArrayList<OrderModel>();
	private ArrayList<ProductModel> products=new ArrayList<ProductModel>();
	private ArrayList<UserModel> user =new ArrayList<UserModel>();
	
	
	public String execute(){
		
		int i;
		//get the user id of the user 
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		System.out.println("user id : " + userId);
		
		//check whether that user id exists in seller table or not ...if not he is not a seller
		SellerSoldProductsDAO sellerProducts = new SellerSoldProductsDAO();
		ProductDetailsDAO productDetails = new ProductDetailsDAO();
		UserDAO userDetails = new UserDAO();
		
		SellerId = sellerProducts.getSellerId(userId);
		System.out.println("seller id : " + SellerId);
		if(SellerId == -1){
			//user is not registered seller ....throw some error as "your not seller"
			return NONE;
		}
		else{
			//he is registered seller - get the list of sold products(i.e., ordered products) by a seller
			setOrdersList(sellerProducts.getOrdersList(SellerId));
			for(i=0; i < ordersList.size(); i++){
				products.add(productDetails.getProductDetails(ordersList.get(i).getProductId()));
				user.add(userDetails.getUserDetails(ordersList.get(i).getUserId()));
			}
		}
		return SUCCESS;
	}

	public int getSellerId() {
		return SellerId;
	}

	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}

	public ArrayList<OrderModel> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(ArrayList<OrderModel> ordersList) {
		this.ordersList = ordersList;
	}

	public ArrayList<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}

	public ArrayList<UserModel> getUser() {
		return user;
	}

	public void setUser(ArrayList<UserModel> user) {
		this.user = user;
	}

}
