package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

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

	

	public ArrayList<Integer> getProductId(int userId) {
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
				"select sellerName from eBay.seller where sellerId = " + sellerId);
		
		logger.info("Query executed: " + sqlQuery);
		
		ResultSet rs = readFromDB(sqlQuery.toString());
		
		try{
			if(rs.next()){
				seller.setSellerName(rs.getString("sellerName"));
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		return seller;
	}
	
}
