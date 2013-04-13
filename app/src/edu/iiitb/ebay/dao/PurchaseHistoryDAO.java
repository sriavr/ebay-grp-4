package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;

/**
 * 
 * @author Surya Pratap Desai
 * 
 */
public class PurchaseHistoryDAO extends BaseDAO {
	
	Logger logger = Logger.getLogger(PurchaseHistoryDAO.class);

	public  ProductModel getProductDetails(int productId) {
		// TODO Auto-generated method stub
		
		ProductModel product=new ProductModel();
		
		StringBuilder sqlQuery = new StringBuilder(
				"select * from eBay.product where productId = " + productId);

		logger.info("Query executed: " + sqlQuery);
		
		ResultSet rs = readFromDB(sqlQuery.toString());
		try{
		while(rs.next()){
			product.setProductId(rs.getInt("productId"));
			product.setSellerId(rs.getInt("sellerId"));
			product.setDescription(rs.getString("description"));
			product.setTitle(rs.getString("title"));
			int price1=rs.getInt("price");
			int discount1=rs.getInt("discount");
			int actualprice=price1-(discount1/100)*price1;
			product.setPrice(actualprice);
			product.setPhoto(rs.getString("photo"));
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}

	
// To get list of products purchased by a particular user
	public ArrayList<Integer> getListOfProductId(int userId) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> productId =new ArrayList<Integer>();
		
		StringBuilder sqlQuery = new StringBuilder(
				"select productId from eBay.order where userId = " + userId);

		logger.info("Query executed: " + sqlQuery);
		
		ResultSet rs = readFromDB(sqlQuery.toString());
		try{
		while(rs.next()){
			productId.add(rs.getInt("productId"));
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return productId;
	}



	public SellerModel getSellerName(int sellerId) {
		// TODO Auto-generated method stub
		
		SellerModel seller=new SellerModel();
		
		StringBuilder sqlQuery = new StringBuilder(
				"select firstName from eBay.user where userId = " + sellerId);
		
		logger.info("Query executed: " + sqlQuery);
		
		ResultSet rs = readFromDB(sqlQuery.toString());
		
		try{
			if(rs.next()){
				seller.setSellerName(rs.getString("firstName"));
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		return seller;
	}


	public ArrayList<OrderModel> getOrderList(int userId) {
		// TODO Auto-generated method stub
		String query= "SELECT * FROM eBay.order WHERE userId="+userId;
		ResultSet rs = readFromDB(query);
		ArrayList<OrderModel> ordersList = new ArrayList<OrderModel>();
		try {
			while(rs.next()){
				OrderModel order = new OrderModel();
				
				order.setOrderId(rs.getInt("orderId"));
				order.setProductId(rs.getInt("productId"));
				order.setSellerId(rs.getInt("sellerId"));
				order.setShipped(rs.getDate("shipped"));
				order.setUserId(rs.getInt("userId"));
				order.setCurrentStatus(rs.getString("currentStatus"));
				order.setStatusUpdateDate(rs.getDate("statusUpdatedDate"));
				order.setOrderPlacedDate(rs.getDate("orderPlacedDate"));
				ordersList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersList;
	}
	
}
