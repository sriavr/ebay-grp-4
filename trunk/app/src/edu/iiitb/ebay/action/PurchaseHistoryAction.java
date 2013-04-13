package edu.iiitb.ebay.action;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.PurchaseHistoryDAO;
import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.model.entity.UserModel;

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
	private ArrayList<OrderModel> ordersList = new ArrayList<OrderModel>();

	public ArrayList<OrderModel> getOrdersList() {
		return ordersList;
	}


	public void setOrdersList(ArrayList<OrderModel> ordersList) {
		this.ordersList = ordersList;
	}


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
		
		//this.setUserId(10);
		userId=((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		
		logger.info("in execute() method of PurchaseHistoryAction class ");
		
		PurchaseHistoryDAO purchasehistoryDAO = new PurchaseHistoryDAO();
		
		this.ordersList = purchasehistoryDAO.getOrderList(userId);
		
		if(userId!=0){
			//get the list of products brought by particular user.
			setProductId(purchasehistoryDAO.getListOfProductId(userId));
			
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