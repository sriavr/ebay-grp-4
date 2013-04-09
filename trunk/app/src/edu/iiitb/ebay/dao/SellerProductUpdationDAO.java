package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;


//sellar dao to view his own products.
public class SellerProductUpdationDAO extends BaseDAO{
	
	//get the seller id if the user is seller if not return -1
	public int getSellerId(int userId) {
	
		String query;
		int sellerId;
		query = "select sellerId from seller where userId = " + userId;
		ResultSet rs = readFromDB(query);
		try {
			while(rs.next()){
				sellerId = rs.getInt("sellerId");
				return sellerId;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1; //not a seller
	}
	
	//get list of products of a particular seller
	public ArrayList<ProductModel> getProducts(int sellerId) {
		String query ;
		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
		query = "select * from product where sellerId = " + sellerId + " order by productId desc";
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setSellerId(rs.getInt("sellerId"));
				product.setDescription(rs.getString("description"));
				product.setTitle(rs.getString("title"));
				product.setQuantity(rs.getInt("quantity"));
				String photoUrl = rs.getString("photo");
				if (photoUrl == null || photoUrl.isEmpty())
					product.setPhoto("/images/default-pic.jpg");
				else
					product.setPhoto(photoUrl);
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	//updating the quantity,price & discount of a product by a seller
	public boolean updateDetails(ProductModel product){
		
		String query;
		query = "update product set quantity = " + product.getQuantity() + ",discount = " + product.getDiscount() + ", price = " + product.getPrice() + " where productId = " + product.getProductId();
		update(query);
		return true;
	}
}
