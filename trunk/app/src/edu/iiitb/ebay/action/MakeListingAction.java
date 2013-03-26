package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.MakeListingDAO;
import edu.iiitb.ebay.model.entity.CategoryModel;

public class MakeListingAction extends ActionSupport {
	
	String selectedCategoryId="";
	String selectedCategoryName="";
	String selectedsubCategoryId="";
	String selectedsubCategoryName="";
	String selectedsubsubCategoryId="";
	String selectedsubsubCategoryName="";
    String selection="";
	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getSelectedCategoryName() {
		return selectedCategoryName;
	}

	public void setSelectedCategoryName(String selectedCategoryName) {
		this.selectedCategoryName = selectedCategoryName;
	}

	public String getSelectedsubCategoryName() {
		return selectedsubCategoryName;
	}

	public void setSelectedsubCategoryName(String selectedsubCategoryName) {
		this.selectedsubCategoryName = selectedsubCategoryName;
	}

	public String getSelectedsubsubCategoryName() {
		return selectedsubsubCategoryName;
	}

	public void setSelectedsubsubCategoryName(String selectedsubsubCategoryName) {
		this.selectedsubsubCategoryName = selectedsubsubCategoryName;
	}

	public String getSelectedsubCategoryId() {
		return selectedsubCategoryId;
	}

	public void setSelectedsubCategoryId(String selectedsubCategoryId) {
		this.selectedsubCategoryId = selectedsubCategoryId;
	}

	public String getSelectedsubsubCategoryId() {
		return selectedsubsubCategoryId;
	}

	public void setSelectedsubsubCategoryId(String selectedsubsubCategoryId) {
		this.selectedsubsubCategoryId = selectedsubsubCategoryId;
	}

	public String getSelectedCategoryId() {
		return selectedCategoryId;
	}

	public void setSelectedCategoryId(String selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}
	
	
	private ArrayList<CategoryModel> categoryList;
	public ArrayList<CategoryModel> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<CategoryModel> categoryList) {
		this.categoryList = categoryList;
	}

	public ArrayList<CategoryModel> getSubcategoryList() {
		return subcategoryList;
	}

	public void setSubcategoryList(ArrayList<CategoryModel> subcategoryList) {
		this.subcategoryList = subcategoryList;
	}

	public ArrayList<CategoryModel> getSubsubcategoryList() {
		return subsubcategoryList;
	}

	public void setSubsubcategoryList(ArrayList<CategoryModel> subsubcategoryList) {
		this.subsubcategoryList = subsubcategoryList;
	}


	private ArrayList<CategoryModel> subcategoryList;
	private ArrayList<CategoryModel> subsubcategoryList;
	
	public String execute()
	{
		subcategoryList = new ArrayList<CategoryModel>();
		subsubcategoryList = new ArrayList<CategoryModel>();
		MakeListingDAO dao =  new MakeListingDAO();
		setCategoryList(dao.getAllCategories());
		if(!selectedCategoryId.equals(""))
		{
		    for(CategoryModel cb:categoryList)
		    {
		    	if(cb.getCategoryID().equals(selectedCategoryId))
		    	{	
		    	  selectedCategoryName = cb.getCategoryName();
		    	  
		    	} 
		    }
		    selection = selectedCategoryName;
			setSubcategoryList(dao.getAllSubCategories(selectedCategoryId));	
		}
		if(!selectedsubCategoryId.equals(""))
		{
			for(CategoryModel cb:subcategoryList)
		    {
		    	if(cb.getCategoryID().equals(selectedsubCategoryId))
		    	  selectedsubCategoryName = cb.getCategoryName();
		    }
			selection += ">"+selectedsubCategoryName;
			setSubsubcategoryList(dao.getAllSubCategories(selectedsubCategoryId));
		}
		
		if(!selectedsubsubCategoryId.equals(""))
		{
			for(CategoryModel cb:subsubcategoryList)
		    {
		    	if(cb.getCategoryID().equals(selectedsubsubCategoryId))
		    	  selectedsubsubCategoryName = cb.getCategoryName();
		    }
			selection += ">"+selectedsubsubCategoryName;
		}
		
		
		return SUCCESS;
		
	}
	
	

}
