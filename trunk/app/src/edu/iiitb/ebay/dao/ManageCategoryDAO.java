package edu.iiitb.ebay.dao;


import java.sql.ResultSet;
import java.util.ArrayList;



import edu.iiitb.ebay.model.entity.CategoryBean;
public class ManageCategoryDAO extends BaseDAO{
	
	
	public ArrayList<CategoryBean>  getAllCategories()
	{
		String query = "select * from category";
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
	
	public void saveCategories(ArrayList<CategoryBean> categories)
	{
		String updateQuery="";
		for(CategoryBean category:categories)
		{
		
			if(category.getCategoryID().indexOf(",")!=-1)
			{
				category.setCategoryID(category.getCategoryID().substring(category.getCategoryID().indexOf(",")+2));
			}
			
			if(category.getParentCategoryId().indexOf(",")!=-1)
			{
				category.setParentCategoryId(category.getParentCategoryId().substring(category.getParentCategoryId().indexOf(",")+2));
			}
			if(category.isSelected())
			{
				System.out.println(category.getCategoryID());
				if(category.getCategoryID().equals("0"))
				{
					System.out.println("here");
					updateQuery = "insert into category(categoryName,parentCategoryId) values('"+category.getCategoryName()+"',"+category.getParentCategoryId()+")";
					System.out.println("updateQuery:"+updateQuery);
				    System.out.println(update(updateQuery));	
					
				}
				else
				{
					updateQuery = "update category set categoryName='"+category.getCategoryName()+"',parentCategoryId="+category.getParentCategoryId();
					updateQuery +=" where categoryId="+category.getCategoryID();
					System.out.println("update query:"+updateQuery);
					System.out.println(update(updateQuery));
					
					
				}
				
			}
			
		}
		
	} 

}
