package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.SellerSoldProductsDAO;
import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class UpdateToShippedAction extends ActionSupport{

	int orderId;
	
	public String execute(){
		System.out.println("order to be updated : " + getOrderId());
		
		SellerSoldProductsDAO sellerDAO  = new SellerSoldProductsDAO();
		
		//update the status of the order to shipped.
		sellerDAO.updateToShipped(getOrderId());
		return SUCCESS;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
