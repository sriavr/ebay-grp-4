package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.CategoryModel;

public class MakeListingDAO extends BaseDAO {
	
	public ArrayList<CategoryModel>  getAllCategories()
	{
		String query = "select * from category where parentCategoryId=0";
		ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
		ResultSet rs= readFromDB(query);
		try
		{
		while(rs.next())
		{
			CategoryModel cb=new CategoryModel();
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
	
	
	public ArrayList<CategoryModel>  getAllSubCategories(String categoryId)
	{
		String query = "select * from category where parentCategoryId="+categoryId;
		ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
		ResultSet rs= readFromDB(query);
		try
		{
		while(rs.next())
		{
			CategoryModel cb=new CategoryModel();
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
