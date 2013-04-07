package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class NotifySellerDAO extends BaseDAO{

	public UserModel getUserWithSellerId(int sellerId) {
		// TODO Auto-generated method stub
		String query = "SELECT user.email AS \"email\",user.firstName AS \"firstName\",user.LastName AS \"lastName\" FROM user,seller WHERE user.userId=seller.userId AND seller.sellerId="+sellerId;
		UserModel user = new UserModel();
		ResultSet rs = readFromDB(query);
		try {
			while(rs.next()){
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public ProductModel getProduct(int productId) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM product WHERE productId="+productId;
		ResultSet rs = readFromDB(query);
		ProductModel product = new ProductModel();
		
		try {
			while(rs.next()){
				product.setProductId(productId);
				product.setTitle(rs.getString("title"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSellerId(rs.getInt("sellerId"));
				product.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
}
