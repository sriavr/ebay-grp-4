package edu.iiitb.ebay.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.PurchaseHistoryDAO;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;

/**
 * 
 * @author Surya Pratap Desai
 * 
 */
public class PurchaseHistoryAction extends ActionSupport {
	
	private int userId=0;
	private ArrayList<Integer> productId =new ArrayList<Integer>();
	


	Logger logger = Logger.getLogger(PurchaseHistoryAction.class);
	private ArrayList<ProductModel> products=new ArrayList<ProductModel>();
	private ArrayList<SellerModel> sellers=new ArrayList<SellerModel>();
	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	


	public ArrayList<ProductModel> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}


	

	
	public ArrayList<Integer> getProductId() {
		return productId;
	}


	public void setProductId(ArrayList<Integer> productId) {
		this.productId = productId;
	}


	public ArrayList<SellerModel> getSellers() {
		return sellers;
	}


	public void setSellers(ArrayList<SellerModel> sellers) {
		this.sellers = sellers;
	}


	public String execute() {
		
		int i;
		
		userId=10;
		
		logger.info("in execute() method of PurchaseHistoryAction class ");
		
		PurchaseHistoryDAO purchasehistoryDAO = new PurchaseHistoryDAO();
		
		if(userId!=0){
			setProductId(purchasehistoryDAO.getProductId(userId));
			
		}
		
		for(i=0;i<productId.size();i++){
			
			products.add(purchasehistoryDAO.getProductDetails(productId.get(i)));
		}
			
		for(i=0;i<productId.size();i++){
			
			sellers.add(purchasehistoryDAO.getSellerName(products.get(i).getSellerId()));
		}
		
		return "success";

 }
}