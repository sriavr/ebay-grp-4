package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.OrderModel;
import edu.iiitb.ebay.model.entity.ProductModel;

public class SellerSoldProductsDAO extends BaseDAO{
	
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
	
	//get the list of sold products(i.e., ordered products) by a seller
	public ArrayList<OrderModel> getOrdersList(int sellerId) {
		
		String query;
		ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
		query = "select * from eBay.order where sellerId = " + sellerId+" and currentStatus not in('ORDER_CANCELLED','DELIVERED')";
		ResultSet rs = readFromDB(query);
		try {
			while(rs.next()){
				System.out.println("here");
				OrderModel order = new OrderModel();
				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setSellerId(rs.getInt("sellerId"));
				order.setProductId(rs.getInt("productId"));
				order.setOrderPlacedDate(rs.getDate("orderPlacedDate"));
				order.setStatusUpdateDate(rs.getDate("statusUpdatedDate"));
				order.setShipped(rs.getDate("shipped"));
				orders.add(order);
				}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders; 			
	}
	
	//get the product id of an order
	public int getProductId(int orderId) {
		
		String query;
		int productId = 0;
		query = "select productId from eBay.order where orderId = " + orderId;
		ResultSet rs = readFromDB(query);
		try {
			while(rs.next()){
				productId = rs.getInt("productId");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;
	}
	
	//get the user id (customer) of an order
	public int getUserId(int orderId) {
		
		String query;
		int userId = 0;
		query = "select userId from eBay.order where orderId = " + orderId;
		ResultSet rs = readFromDB(query);
		try {
			while(rs.next()){
				userId = rs.getInt("userId");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}
	
	//get currentStatus of particular order
	public String getCurrentStatus(int orderId) {
		
		String query;
		String Status = "";
		query = "select currentStatus from eBay.order where orderId = " + orderId;
		ResultSet rs = readFromDB(query);
		try {
			while(rs.next()){
				Status = rs.getString("currentStatus");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status;
	}
	
	//update the status to shipped.
	public void updateToShipped(int orderId) {
		
		String query;
		query = "update eBay.order set currentStatus = 'SHIPPED' where orderId = " + orderId +" and (currentStatus<>'ORDER_CANCELLED' || currentStatus<>'DELIVERED')";
		BaseDAO.update(query);
		return ;
	}
	
}
