package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.CancelOrderDAO;
import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.util.ConstantValues;

public class CancelOrderAction extends ActionSupport{
	int orderId;
	OrderModel order;
	
	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String execute(){
		//UserModel user = (UserModel)ActionContext.getContext().getSession().get("user");
		CancelOrderDAO cancelOrderDAO = new CancelOrderDAO();
		//Get order details from orderId
		order = new OrderModel();
		order = cancelOrderDAO.getOrder(orderId);
		SellerModel seller = cancelOrderDAO.getSeller(order.getSellerId());
		//Get Product details from the Product Table
		ProductModel product = cancelOrderDAO.getProduct(order.getProductId());
		//Calculate amount to be reimbursed into buyers account
		float reimbursedAmount = (float) (((float)order.getQuantity())*product.getPrice()*ConstantValues.reimbursedPercentage);
		System.out.println("Quantity = "+order.getQuantity());
		System.out.println("Product Price = "+product.getPrice());
		System.out.println("Reimbursed Percentage"+ConstantValues.reimbursedPercentage);
		System.out.println("reimbursedAmount = "+order.getQuantity()*product.getPrice()*ConstantValues.reimbursedPercentage);
		//Calculate amount to be deducted from sellers account
		float deductedAmount = reimbursedAmount;
		
		//Check if order Status is PAYMENT_RECEIVED, if so then reimburse the money into buyers account with a penalty 
		//Similarly decrease amount from Sellers account with a penalty
		System.out.println("Order currentStatus = "+order.getCurrentStatus());
		System.out.println(order.getCurrentStatus().equals("PAYMENT_RECEIVED"));
		if(order.getCurrentStatus().equals("PAYMENT_RECEIVED")){
			//deducting Money from seller
			cancelOrderDAO.updateBalance(seller.getUserId(),-deductedAmount);
			cancelOrderDAO.updateBalance(order.getUserId(),reimbursedAmount);
			
		}
		//Update status of order to be "ORDER_CANCELLED" and statusUpdatedDate to current Date
			cancelOrderDAO.updateStatus("ORDER_CANCELLED",order.getOrderId());
		//update the quantity of the product
		cancelOrderDAO.updateProductQuantity(product.getProductId(),order.getQuantity());
		order = cancelOrderDAO.getOrder(orderId);
		return Action.SUCCESS;
	}
}
