package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.ProductSpecModel;

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
		System.out.println("query:"+query);
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
	
	
	public void saveProduct(ProductModel pm,ArrayList<ProductSpecModel> itemSpecs,String selectedCategoryId)
	{
		
		try
		{
		String updateQuery = "insert into product(productId,sellerId,description,title,price,quantity,photo,discount) values("+pm.getProductId()+","+pm.getSellerId()+",'"+pm.getDescription()+"','"+pm.getTitle()+"',"+pm.getPrice()+","+pm.getQuantity()+",'"+pm.getPhoto()+"',"+pm.getDiscount()+")";
		System.out.println(updateQuery);
		update(updateQuery);
		
		for(ProductSpecModel ps:itemSpecs)
		{
			
			
			String query = "insert into productspecs(entity,value,type,productId) values('"+ps.getProperty()+"','"+ps.getValue()+"','string',"+pm.getProductId()+")";
			System.out.println(query);
			update(query);
		}
		
		String query = "insert into productcategorymapping(productId,categoryId) values("+pm.getProductId()+","+selectedCategoryId+")";
		System.out.println(query);
		update(query);
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public void updateProduct(ProductModel pm)
	{
		
		try
		{
		String updateQuery = "update product set description='"+pm.getDescription()+"',title='"+pm.getTitle()+"',price="+pm.getPrice()+",quantity="+pm.getQuantity()+",photo='"+pm.getPhoto()+"',discount="+pm.getDiscount()+" where productId="+pm.getProductId();
		System.out.println(updateQuery);
		update(updateQuery);
		
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public int getProductId()
	{
		String query = "select max(productId)+1 from product";
		ResultSet rs=readFromDB(query);
		try
		{
		if(rs.next())
		{
			
				return rs.getInt(1);
		}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
		return 0;
		
	}
	
	public int getProductSpecId()
	{
		String query = "select max(productSpecsId)+1 from productspecs";
		ResultSet rs=readFromDB(query);
		try
		{
		while(rs.next())
		{
			if(rs.getString(1)==null)
				return 0;
			else
				rs.getInt(1);
		}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
		return 0;
		
	}

}
