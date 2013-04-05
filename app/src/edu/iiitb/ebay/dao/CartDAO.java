package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.page.CartPageModel;

public class CartDAO extends BaseDAO{
	public Integer productUserInCart(int userId,int productId){
		String query="SELECT cartId FROM cart WHERE userId="+userId+" AND productId="+productId+" AND type=\"P\"";
		ResultSet rs = readFromDB(query);
		Integer cartId = null;
		try {
			while (rs.next()){
				cartId=rs.getInt("cartId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			cartId=null;
			e.printStackTrace();
		}
		return cartId;
	}

	public void insertCartItem(int userId, int productId, int qty, char c) {
		// Insert into cart table with the given values
		String query="INSERT INTO cart(userId,productId,quantity,type) VALUES("+userId+","+productId+","+qty+",\""+c+"\")";
		System.out.println(query);
		System.out.println(update(query));
	}

	public void updateCartItem(Integer cartId, int qty) {
		// TODO Auto-generated method stub
		String query = "UPDATE cart set quantity="+qty+" WHERE cartId="+cartId;
		update(query);
	}

	public ArrayList<CartPageModel> getUserCartList(int userId) {
		// TODO Auto-generated method stub
		ArrayList<CartPageModel> cartList=null;
		String query = "SELECT cartId,product.productId,title,cart.quantity as quantity,price,photo,discount,sellerId FROM cart,product WHERE cart.productId=product.productId AND cart.type='P' AND cart.userId="+userId;
		ResultSet rs = readFromDB(query);
		try {
			cartList=new ArrayList<CartPageModel>();
			
			while(rs.next()){
				CartPageModel cpm = new CartPageModel();
				cpm.setCartId(rs.getInt("cartId"));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setTitle(rs.getString("title"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getInt("price"));
				product.setPhoto(rs.getString("photo"));
				product.setDiscount(rs.getInt("discount"));
				product.setSellerId(rs.getInt("sellerId"));
				cpm.setProduct(product);
				cartList.add(cpm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return cartList;
	}

	public void removeFromCart(int cartId) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM cart WHERE cartId="+cartId;
		update(query);
	}
}
