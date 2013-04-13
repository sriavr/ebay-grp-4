package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;

public class CancelOrderDAO extends BaseDAO{

	public  OrderModel getOrder(int orderId) {
		// TODO Auto-generated method stub
		String query= "SELECT * FROM eBay.order WHERE orderId="+orderId;
		ResultSet rs = readFromDB(query);
		OrderModel order = new OrderModel();
		try {
			while(rs.next()){
				
				
				order.setOrderId(rs.getInt("orderId"));
				order.setProductId(rs.getInt("productId"));
				order.setSellerId(rs.getInt("sellerId"));
				order.setShipped(rs.getDate("shipped"));
				order.setUserId(rs.getInt("userId"));
				order.setQuantity(rs.getInt("quantity"));
				order.setCurrentStatus(rs.getString("currentStatus"));
				order.setStatusUpdateDate(rs.getDate("statusUpdatedDate"));
				order.setOrderPlacedDate(rs.getDate("orderPlacedDate"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
		
	}

	public  ProductModel getProduct(int productId) {
		// TODO Auto-generated method stub
		String query="SELECT * FROM product WHERE productId="+productId;
		ProductModel product = new ProductModel();
		ResultSet rs = readFromDB(query);
		try {
			
			while(rs.next()){
				
				product.setProductId(rs.getInt("productId"));
				product.setTitle(rs.getString("title"));
				product.setQuantity(rs.getInt("quantity"));
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

	public void updateBalance(int userId, float amount) {
		// TODO Auto-generated method stub
		String query="UPDATE bank SET balance=balance+"+amount+" WHERE userId="+userId;
		update(query);
	}

	public void updateStatus(String string, int orderId) {
		// TODO Auto-generated method stub
		String query = "UPDATE ebay.order SET currentStatus=\'"+string+"\' , statusUpdatedDate=curdate() WHERE orderId="+orderId;
		update(query);
	}

	public void updateProductQuantity(int productId, int quantity) {
		// TODO Auto-generated method stub
		String query="UPDATE product set quantity=quantity+"+quantity+" WHERE productId="+productId;
		update(query);
	}

	public SellerModel getSeller(int sellerId) {
		// TODO Auto-generated method stub
		String query="SELECT * FROM seller WHERE sellerId="+sellerId;
		ResultSet rs = readFromDB(query);
		SellerModel seller = new SellerModel();
		try {
			while(rs.next()){
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setUserId(rs.getInt("userId"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seller;
	}
	
}
