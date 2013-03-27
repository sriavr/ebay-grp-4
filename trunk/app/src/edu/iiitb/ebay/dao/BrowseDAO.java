/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.Select;

import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.page.BrowseModel;

/**
 * This is DAO object for BrowseAction, purpose is to do the DB operations for
 * showing the products when searched, or even the default page without
 * searching for anything.
 * 
 * @author Sridhar Jammalamadaka
 * 
 */
public class BrowseDAO extends BaseDAO {
	Logger logger = Logger.getLogger("edu.iiitb.ebay.dao");

	/***
	 * This method is called to load the categories on the left hand side of
	 * browse page.
	 */
	public ArrayList<CategoryModel> getRelevantCategories() {
		logger.info("Inside BrowseDAO : getRelevantCategories()");
		ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
		ResultSet rs = readFromDB("select * from category where parentCategoryId = 0");
		try {
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryID(rs.getString("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				categories.add(category);
			}
			logger.info("Size of categories list is " + categories.size());
		} catch (SQLException e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
		}
		return categories;
	}

//	/***
//	 * This method is called when "All Categories" is selected and query is
//	 * EMPTY string.
//	 */
//	public ArrayList<ProductModel> getProducts() {
//		logger.info("Inside BrowseDAO : getProducts()");
//		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
//		ResultSet rs = readFromDB("select * from product");
//		try {
//			while (rs.next()) {
//				ProductModel product = new ProductModel();
//
//				product.setProductId(rs.getInt("productId"));
//				product.setDescription(rs.getString("description"));
//				product.setSellerId(rs.getInt("sellerId"));
//				product.setQuantity(rs.getInt("quantity"));
//				product.setTitle(rs.getString("title"));
//				product.setPhoto(rs.getString("photo"));
//				product.setPrice(rs.getInt("price"));
//				products.add(product);
//			}
//			logger.info("Size of products list is " + products.size());
//		} catch (SQLException e) {
//			logger.error("Error occurred", e);
//			e.printStackTrace();
//		}
//		return products;
//	}
//
//	/***
//	 * This method is called when "All Categories" is selected and query is
//	 * non-empty string.
//	 */
//	public ArrayList<ProductModel> getProducts(String query) {
//		logger.info("Inside BrowseDAO : getProducts(query)");
//		logger.info("query:" + query);
//		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
//		if (query != null)
//			System.out.println("query:" + query);
//		ResultSet rs = readFromDB("select * from product where title like '%"
//				+ query + "%'");
//		try {
//			while (rs.next()) {
//				ProductModel product = new ProductModel();
//
//				product.setProductId(rs.getInt("productId"));
//				product.setDescription(rs.getString("description"));
//				product.setSellerId(rs.getInt("sellerId"));
//				product.setQuantity(rs.getInt("quantity"));
//				product.setTitle(rs.getString("title"));
//				product.setPhoto(rs.getString("photo"));
//				product.setPrice(rs.getInt("price"));
//				products.add(product);
//			}
//			logger.info("Size of products list is " + products.size());
//		} catch (SQLException e) {
//			logger.error("Error occurred", e);
//			e.printStackTrace();
//		}
//		return products;
//	}
//
//	/***
//	 * This method is called when a valid category is selected and query is
//	 * EMPTY string.
//	 */
//	public ArrayList<ProductModel> getProducts(int categoryId) {
//		logger.info("Inside BrowseDAO : getProducts(categoryId)");
//		logger.info("categoryId:" + categoryId);
//		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
//		// TODO SHOULD REFINE THIS QUERY TO ACCOMODATE CHECKING OF CATEGORY
//		ResultSet rs = readFromDB("select * from product  ");
//		try {
//			while (rs.next()) {
//				ProductModel product = new ProductModel();
//
//				product.setProductId(rs.getInt("productId"));
//				product.setDescription(rs.getString("description"));
//				product.setSellerId(rs.getInt("sellerId"));
//				product.setQuantity(rs.getInt("quantity"));
//				product.setTitle(rs.getString("title"));
//				product.setPhoto(rs.getString("photo"));
//				product.setPrice(rs.getInt("price"));
//				products.add(product);
//			}
//			logger.info("Size of products list is " + products.size());
//		} catch (SQLException e) {
//			logger.error("Error occurred", e);
//			e.printStackTrace();
//		}
//		return products;
//	}
//
//	/***
//	 * This method is called when a valid category is selected and query is
//	 * non-empty string.
//	 */
//	public ArrayList<ProductModel> getProducts(String query, int categoryId) {
//		logger.info("Inside BrowseDAO : getProducts(query, categoryId)");
//		logger.info("query:" + query + ", categoryId:" + categoryId);
//		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
//		// TODO NEED TO REFINE THE QUERY
//		ResultSet rs = readFromDB("select * from product where title like '%"
//				+ query + "%'");
//		try {
//			while (rs.next()) {
//				ProductModel product = new ProductModel();
//
//				product.setProductId(rs.getInt("productId"));
//				product.setDescription(rs.getString("description"));
//				product.setSellerId(rs.getInt("sellerId"));
//				product.setQuantity(rs.getInt("quantity"));
//				product.setTitle(rs.getString("title"));
//				product.setPhoto(rs.getString("photo"));
//				product.setPrice(rs.getInt("price"));
//				products.add(product);
//			}
//			logger.info("Size of products list is " + products.size());
//		} catch (SQLException e) {
//			logger.error("Error occurred", e);
//			e.printStackTrace();
//		}
//		return products;
//	}

	public ArrayList<ProductModel> getProducts(String query, int categoryId,
			int priceLower, int priceHigher) {
		logger.info("Inside BrowseDAO : getProducts(query, categoryId, priceLower, priceHigher)");
		logger.info("query:" + query + ", categoryId:" + categoryId
				+ ", priceLower:" + priceLower + ", priceHigher:" + priceHigher);
		ArrayList<ProductModel> products = new ArrayList<ProductModel>();

		StringBuilder sqlQuery = new StringBuilder(
				"select * from product where 1=1 ");
		if (!query.isEmpty()) {
			sqlQuery = sqlQuery.append(" and title like '%" + query + "%'");
		}

		if (categoryId != 0) {
			System.out.println("don't worry we added categoryId");
			//sqlQuery = sqlQuery.append(" and categoryId=" + categoryId);
		}

		if (priceHigher > priceLower) {
			sqlQuery = sqlQuery.append(" and price between " + priceLower
					+ " and " + priceHigher);
		}
		logger.info("Query executed: " + sqlQuery);
		ResultSet rs = readFromDB(sqlQuery.toString());
		try {
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setDescription(rs.getString("description"));
				product.setSellerId(rs.getInt("sellerId"));
				product.setQuantity(rs.getInt("quantity"));
				product.setTitle(rs.getString("title"));
				product.setPhoto(rs.getString("photo"));
				product.setPrice(rs.getInt("price"));
				products.add(product);
			}
			logger.info("Size of products list is " + products.size());
		} catch (SQLException e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
		}
		return products;
	}
}
