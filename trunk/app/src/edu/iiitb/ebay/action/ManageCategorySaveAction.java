package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.ManageCategoryDAO;
import edu.iiitb.ebay.model.entity.CategoryBean;

public class ManageCategorySaveAction extends ActionSupport {
	
	private ArrayList<CategoryBean> categoryList;
	
	
	public ArrayList<CategoryBean> getCategoryList() {
		return categoryList;
	}


	public void setCategoryList(ArrayList<CategoryBean> categoryList) {
		this.categoryList = categoryList;
	}


	public String execute()
	{
		
		ManageCategoryDAO dao = new ManageCategoryDAO();
		
		dao.saveCategories(categoryList);
		
		return SUCCESS;
	}

}
