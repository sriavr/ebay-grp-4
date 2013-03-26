package edu.iiitb.ebay.action;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.ManageCategoryDAO;
import edu.iiitb.ebay.model.entity.CategoryModel;
public class ManageCategoryAction extends ActionSupport {
	
	private ArrayList<CategoryModel> categoryList;

	public ArrayList<CategoryModel> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<CategoryModel> categoryList) {
		this.categoryList = categoryList;
	}
	
	
	public String execute()
	{
		ManageCategoryDAO dao = new ManageCategoryDAO();
		setCategoryList(dao.getAllCategories());
		return SUCCESS;
		
	}

}
