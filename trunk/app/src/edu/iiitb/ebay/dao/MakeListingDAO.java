package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.CategoryBean;

public class MakeListingDAO extends BaseDAO {
	
	public ArrayList<CategoryBean>  getAllCategories()
	{
		String query = "select * from category where parentCategoryId=0";
		ArrayList<CategoryBean> categories = new ArrayList<CategoryBean>();
		ResultSet rs= readFromDB(query);
		try
		{
		while(rs.next())
		{
			CategoryBean cb=new CategoryBean();
			cb.setCategoryID(rs.getString(1));
			cb.setCategoryName(rs.getString(2)+">");
			cb.setParentCategoryId(rs.getString(3));
			categories.add(cb);
		
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return categories;
	}
	
	
	public ArrayList<CategoryBean>  getAllSubCategories(String categoryId)
	{
		String query = "select * from category where parentCategoryId="+categoryId;
		ArrayList<CategoryBean> categories = new ArrayList<CategoryBean>();
		ResultSet rs= readFromDB(query);
		try
		{
		while(rs.next())
		{
			CategoryBean cb=new CategoryBean();
			cb.setCategoryID(rs.getString(1));
			cb.setCategoryName(rs.getString(2));
			cb.setParentCategoryId(rs.getString(3));
			categories.add(cb);
		
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return categories;
	}
	
	
	

}
