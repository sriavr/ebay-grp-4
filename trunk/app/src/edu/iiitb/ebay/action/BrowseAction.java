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
	private int categoryId = 0;
	private ArrayList<ProductModel> products = new ArrayList<ProductModel>();
	private ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
	private int priceLower = 0;
	private int priceHigher = 0;

	public int getPriceLower() {
		return priceLower;
	}

	public void setPriceLower(int priceLower) {
		this.priceLower = priceLower;
	}

	public int getPriceHigher() {
		return priceHigher;
	}

	public void setPriceHigher(int priceHigher) {
		this.priceHigher = priceHigher;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

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
		if (query == null)
			query = "";
		setProducts(browseDAO.getProducts(query, categoryId, priceLower,
				priceHigher));
		// if (query != null && !query.isEmpty()) {
		// logger.info("Query was " + query);
		// if (categoryId > 0) {
		// logger.info("categoryId was " + categoryId);
		// setProducts(browseDAO.getProducts(query, categoryId, priceLower,
		// priceHigher));
		// } else {
		// setProducts(browseDAO.getProducts(query, priceLower, priceHigher));
		// }
		// } else {
		// logger.info("query was null");
		// if (categoryId > 0) {
		// logger.info("categoryId was " + categoryId);
		// setProducts(browseDAO.getProducts(categoryId, priceLower,
		// priceHigher));
		// } else {
		// setProducts(browseDAO.getProducts());
		// }
		//
		// }
		logger.info("BrowseAction successful returning");
		return SUCCESS;
	}
}
