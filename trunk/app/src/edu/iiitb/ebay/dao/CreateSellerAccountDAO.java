package edu.iiitb.ebay.dao;

import java.sql.ResultSet;

import com.opensymphony.xwork2.util.logging.Logger;

import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.util.LogMessage;

public class CreateSellerAccountDAO extends BaseDAO {
	
	public SellerModel getSellerInfo(int userId)
	{
		String query = "select * from seller where userId="+userId;
		SellerModel sm = null; 
		ResultSet rs = readFromDB(query);
		try
		{
		if(rs.next())
		{
		  sm = new SellerModel();
		  sm.setSellerId(rs.getInt(1));
		  sm.setDateOfRegistration(rs.getString(2));
		  sm.setLocation(rs.getString(3));
		  sm.setFeedbackScore(rs.getInt(4));
		  sm.setPositivFeedBack(rs.getInt(5));
		  sm.setUserId(userId);
		  sm.setSla(rs.getInt(7));
		}
		
			
		
		}
		catch(Exception ex)
		{
			LogMessage.log("Message From CreateSellerAccountDAO.getSellerInfo"+ex);
		}
		return sm;
	}
	
	public void insertSeller(SellerModel sm)
	{
		try
		{
		String updateQuery ="insert into seller(location,userId) values('"+sm.getLocation()+"',"+sm.getUserId()+")";
		LogMessage.log("Update query in insertSeller:"+updateQuery);
		System.out.println(update(updateQuery));
		}
		catch(Exception ex)
		{
			LogMessage.log("Message From CreateSellerAccountDAO.insertSeller"+ex);
		}
	}

}
