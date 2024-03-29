package edu.iiitb.ebay.action;

import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.CartDAO;
import edu.iiitb.ebay.dao.DealsDAO;
import edu.iiitb.ebay.model.entity.DealModel;
import edu.iiitb.ebay.model.entity.UserModel;
import edu.iiitb.ebay.model.page.CartPageModel;

public class CartAction extends ActionSupport{
	int cartId;
	int productId;
	int qty;
	ArrayList<CartPageModel> cartList ;
	float cartAmount;
	
	public float getCartAmount() {
		return cartAmount;
	}
	public void setCartAmount(float cartAmount) {
		this.cartAmount = cartAmount;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public ArrayList<CartPageModel> getCartList() {
		return cartList;
	}
	public void setCartList(ArrayList<CartPageModel> cartList) {
		this.cartList = cartList;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String execute(){
		CartDAO cartDAO = new CartDAO();
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		
		Integer cartId = cartDAO.productUserInCart(userId, productId);
		if(cartId == null){
			//Insert a cartItem with type P
			cartDAO.insertCartItem(userId,productId,qty,'P');
		}else{
			//Update the cartItem with the new quantity qty
			cartDAO.updateCartItem(cartId,qty);
		}
		
		cartList = cartDAO.getUserCartList(userId);
		cartAmount=0;
		for (CartPageModel cart : cartList) {
			//**************************************************************
			//Set the price of product to deal price if exists
			DealModel deal = new DealsDAO().getDealModel(productId);
			if(deal.getDealsId()!=0 && deal.getDealEndDate().after(new Date())){
				cart.getProduct().setPrice(deal.getDealSellingPrice());
			}else{
				cart.getProduct().setPrice(cart.getProduct().getPrice()-cart.getProduct().getDiscount());
			}
			//else set the price of product to price - discount price
			//****************************************************************

			cartAmount+=(cart.getProduct().getPrice()*cart.getProduct().getQuantity());
		}
		ActionContext.getContext().getSession().put("cartList", cartList);
		
		
		return Action.SUCCESS;
	}
	
	public String removeFromCart(){
		CartDAO cartDAO = new CartDAO();
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		
		cartDAO.removeFromCart(cartId);//Removing cartItem
		cartList = cartDAO.getUserCartList(userId);//Populating cartList again from DB so that it can be listed in jsp
		
		ActionContext.getContext().getSession().put("cartList", cartList);
		return Action.SUCCESS;
	}
}
