package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.CartDAO;
import edu.iiitb.ebay.model.entity.UserModel;
import edu.iiitb.ebay.model.page.CartPageModel;

public class CartAction extends ActionSupport{
	int cartId;
	int productId;
	int qty;
	ArrayList<CartPageModel> cartList ;
	
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
