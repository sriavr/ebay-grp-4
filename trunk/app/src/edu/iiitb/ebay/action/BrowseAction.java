package edu.iiitb.ebay.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.BaseDAO;
import edu.iiitb.ebay.dao.BrowseDAO;
import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.page.BrowseModel;

public class BrowseAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(BrowseAction.class);
	private String query = "";
	private ArrayList<ProductModel> products = new ArrayList<ProductModel>();
	private ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();

	public ArrayList<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<CategoryModel> categories) {
		this.categories = categories;
	}

	public ArrayList<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String execute() throws Exception {
		logger.info("Inside execute method of BrowseAction");

		BrowseDAO browseDAO = new BrowseDAO();
		setCategories(browseDAO.getRelevantCategories());
		if (query != null) {
			logger.info("query was " + query);
			setProducts(browseDAO.getProducts(query));
		} else {
			logger.info("query was null");
			setProducts(browseDAO.getProducts());
		}
		logger.info("BrowseAction successful returning");
		return SUCCESS;
	}
}
