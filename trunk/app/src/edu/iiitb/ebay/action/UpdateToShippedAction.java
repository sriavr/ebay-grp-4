package edu.iiitb.ebay.action;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.SellerSoldProductsDAO;
import edu.iiitb.ebay.dao.UserDAO;
import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class UpdateToShippedAction extends ActionSupport{

	int orderId;
	
	public String execute(){
		System.out.println("order to be updated : " + getOrderId());
		
		SellerSoldProductsDAO sellerDAO  = new SellerSoldProductsDAO();
		UserDAO userDAO = new UserDAO();
		
		//get current date time stamp
		Date now = new Date();
		//System.out.println("date : " + now.toString());
		
		//get customer email addr
		String custEmailId = sellerDAO.getEmailId(getOrderId());
		//System.out.println("email id : " +custEmailId);
		
		String subject = "your ebay order id : " + getOrderId() + " is shipped";
		String message = "your order " + getOrderId() + " is shipped on " + now.toString();
		
		//update the status of the order to shipped.
		sellerDAO.updateToShipped(getOrderId());
		
		try {
			userDAO.sendEmail(custEmailId, subject, message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//send the order updated status mail to customer  
		return SUCCESS;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
