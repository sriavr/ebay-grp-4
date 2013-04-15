package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.BrowseDAO;
import edu.iiitb.ebay.dao.SellerProductUpdationDAO;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;

// sellar viewing his own products. 
public class ViewMyProductsAction extends ActionSupport{

	int SellerId;
	private ArrayList<ProductModel> products = new ArrayList<ProductModel>();
	
	public String execute(){
		
		//get the user id of the user 
		if((String) ActionContext.getContext().getSession().get("role") == null){
			return "fail";
		}
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		System.out.println("user id : " + userId);
		
		//check whether that user id exists in sellar table or not ...if not he is not a sellar
		SellerProductUpdationDAO sellerDAO = new SellerProductUpdationDAO();
		
		SellerId = sellerDAO.getSellerId(userId);
		System.out.println("seller id : " + SellerId);
		if(SellerId == -1){
			//user is not registered seller ....throw some error as "ur not seller"
			return NONE;
		}
		else{
			//he is registered seller - get the list of his own products 
			setProducts(sellerDAO.getProducts(SellerId));
		}
		return SUCCESS;
	}
	
	public int getSellerId() {
		return SellerId;
	}
	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}
	public ArrayList<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}
	
}
