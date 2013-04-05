package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.page.CartPageModel;

public class BuyProductDAO extends BaseDAO{
	
	public ProductModel getProduct(int productId,int qty){
		String query = "SELECT * FROM product WHERE productId="+productId;
		ProductModel product = new ProductModel();
		ResultSet rs = readFromDB(query);
		try {
			
			while(rs.next()){
				
				product.setProductId(rs.getInt("productId"));
				product.setTitle(rs.getString("title"));
				product.setQuantity(qty);
				product.setPrice(rs.getInt("price"));
				product.setPhoto(rs.getString("photo"));
				product.setDiscount(rs.getInt("discount"));
				product.setSellerId(rs.getInt("sellerId"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return product;
	}
}
