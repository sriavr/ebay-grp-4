package edu.iiitb.ebay.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.BaseDAO;
import edu.iiitb.ebay.dao.BrowseDAO;
import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.DealModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.page.BrowseModel;

public class BrowseDealsAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(BrowseDealsAction.class);
	private String query = "";
	private int categoryId = 0;
	// private ArrayList<ProductModel> products = new ArrayList<ProductModel>();
	private ArrayList<DealModel> products = new ArrayList<DealModel>();
	private ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
	private int priceLower = 0;
	private int priceHigher = 0;
	private int pageSize = 5;
	private int pageNum = 1;
	private int noOfPages = 1;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

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

	// public ArrayList<ProductModel> getProducts() {
	// return products;
	// }
	//
	// public void setProducts(ArrayList<ProductModel> products) {
	// this.products = products;
	// }
	public ArrayList<DealModel> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<DealModel> products) {
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
		if (priceLower > priceHigher) {
			addActionError("Lower limit should be lesser than Higher limit");
		}
		BrowseDAO browseDAO = new BrowseDAO();
		try {
			setCategories(browseDAO.getRelevantCategories());
		} catch (SQLException e) {
			logger.error("Error loading categories.", e);
			e.printStackTrace();
			addActionError("Error loading categories.");
		}

		if (query == null)
			query = "";
		try {
			// setProducts(browseDAO.getProducts(query, categoryId, priceLower,
			// priceHigher));
			setProducts(browseDAO.getProductDeals(query, categoryId,
					priceLower, priceHigher));
			logger.info("Length of product list: "+ this.products.size());
		} catch (SQLException e) {
			logger.error("Error loading products.", e);
			e.printStackTrace();
			addActionError("Error loading products.");
		}

		logger.info("pageNum * pageSize = " + pageNum * pageSize);
		logger.info("(pageNum-1) * pageSize = " + (pageNum - 1) * pageSize);
		int startIndex = 0, endIndex = 0;
		if (pageNum < 1) {
			logger.info("pageNum < 1, resetting to 1");
			pageNum = 1;
		}

		if (pageNum > 1) {
			startIndex = (pageNum - 1) * pageSize;
			logger.info("pageNum > 1, startIndex = " + startIndex);
		} else {
			startIndex = 0;
			logger.info("pageNum = 1, startIndex = " + startIndex);
		}
		endIndex = pageNum * pageSize - 1;

		if (pageNum * pageSize > products.size()) {
			logger.info("something could be wrong, let's check");
			if ((pageNum - 1) * pageSize < products.size()) {
				logger.info("valid pagination case. no problem");
			} else {
				logger.info("invalid case of pagination. resetting to page1");
				pageNum = 1;
				startIndex = 0;
				endIndex = pageNum * pageSize - 1;
			}
		}

		if (pageSize > 0) {
			noOfPages = products.size() / pageSize + 1;
		} else {
			noOfPages = 1;
			pageSize = 5;
		}

		setProducts(filter(products, startIndex, endIndex));
		logger.info("BrowseAction successful returning");
		return SUCCESS;
	}

	private ArrayList<DealModel> filter(ArrayList<DealModel> products2,
			int startIndex, int endIndex) {
		logger.info("startIndex:" + startIndex + " endIndex:" + endIndex);
		ArrayList<DealModel> subList = new ArrayList<DealModel>();
		if (startIndex < products2.size()) {
			for (int i = startIndex; i <= endIndex && i < products2.size(); i++) {
				subList.add(products2.get(i));
			}
		}
		return subList;
	}
}

// if (query != null && !query.isEmpty()) {
// logger.info("Query was " + query);
// if (categoryId > 0) {
// logger.info("categoryId was " + categoryId);
// setProducts(browseDAO.getProducts(query, categoryId, priceLower,
// priceHigher));ProductModel
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