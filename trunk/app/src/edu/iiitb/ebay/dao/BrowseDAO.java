/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.DealModel;
import edu.iiitb.ebay.model.entity.ProductModel;

/**
 * This is DAO object for BrowseAction, purpose is to do the DB operations for
 * showing the products when searched, or even the default page without
 * searching for anything.
 * 
 * @author Sridhar Jammalamadaka
 * 
 */
public class BrowseDAO extends BaseDAO {
	Logger logger = Logger.getLogger(BrowseDAO.class);

	/***
	 * This method is called to load the categories on the left hand side of
	 * browse page.
	 * 
	 * @throws SQLException
	 */
	public ArrayList<CategoryModel> getRelevantCategories() throws SQLException {
		logger.info("Inside BrowseDAO : getRelevantCategories()");
		ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
		ResultSet rs = readFromDB("select * from category where parentCategoryId = 0");

		while (rs.next()) {
			CategoryModel category = new CategoryModel();
			category.setCategoryID(rs.getString("categoryId"));
			category.setCategoryName(rs.getString("categoryName"));

			StringBuilder sqlQuery = new StringBuilder("call getSubCategories("
					+ category.getCategoryID() + ");");
			logger.debug("Running query " + sqlQuery);
			ResultSet rs1 = readFromDB(sqlQuery.toString());
			ArrayList<CategoryModel> subCategories = new ArrayList<CategoryModel>();
			while (rs1.next()) {
				CategoryModel subCategory = new CategoryModel();
				if (!rs1.getString("categoryId").trim()
						.equals(category.getCategoryID())) {
					subCategory.setCategoryID(rs1.getString("categoryId"));
					subCategory.setCategoryName(rs1.getString("categoryName"));
					logger.info("Added a subcategory");
					subCategories.add(subCategory);
				} else {
					logger.info("Skipping case where categoryId is redundant");
				}
			}
			category.setCategories(subCategories);
			logger.info("size of subcategories:" + subCategories.size());
			categories.add(category);
		}
		logger.info("Size of categories list is " + categories.size());

		return categories;
	}

	/**
	 * Returns all the products. But deal information is not retrieved in this
	 * method. See getProductDeals in case you want deal information along with
	 * products.
	 * 
	 * @param query
	 * @param categoryId
	 * @param priceLower
	 * @param priceHigher
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ProductModel> getProducts(String query, int categoryId,
			int priceLower, int priceHigher) throws SQLException {
		if (query.contains(",")) {
			query.replace("'", "");
		}
		logger.info("Inside BrowseDAO : getProducts(query, categoryId, priceLower, priceHigher)");
		logger.info("query:" + query + ", categoryId:" + categoryId
				+ ", priceLower:" + priceLower + ", priceHigher:" + priceHigher);
		ArrayList<ProductModel> products = new ArrayList<ProductModel>();

		StringBuilder sqlQuery = new StringBuilder("call getProducts('" + query
				+ "'," + categoryId + "," + priceLower + "," + priceHigher
				+ ");");
		logger.info("Query executed: " + sqlQuery);
		ResultSet rs = readFromDB(sqlQuery.toString());

		while (rs.next()) {
			ProductModel product = new ProductModel();
			product.setProductId(rs.getInt("productId"));
			product.setDescription(rs.getString("description"));
			product.setSellerId(rs.getInt("sellerId"));
			product.setSellerName(rs.getString("firstName") + " "
					+ rs.getString("lastName"));
			product.setQuantity(rs.getInt("quantity"));
			product.setTitle(rs.getString("title"));
			String photoUrl = rs.getString("photo");
			if (photoUrl == null || photoUrl.isEmpty())
				product.setPhoto("/images/default-pic.jpg");
			else
				product.setPhoto(photoUrl);
			product.setPrice(rs.getInt("price"));
			products.add(product);
		}
		logger.info("Size of products list is " + products.size());

		return products;
	}

	/**
	 * This method returns all the products even if there is no deal is present.
	 * If there is no deal, all the deal fields would be set to null is
	 * 
	 * @param query
	 * @param categoryId
	 * @param priceLower
	 * @param priceHigher
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<DealModel> getProductDeals(String query, int categoryId,
			int priceLower, int priceHigher) throws SQLException {
		if (query.contains(",")) {
			query.replace("'", "");
		}
		logger.info("Inside BrowseDAO : getProductDeals(query, categoryId, priceLower, priceHigher)");
		logger.info("query:" + query + ", categoryId:" + categoryId
				+ ", priceLower:" + priceLower + ", priceHigher:" + priceHigher);
		ArrayList<DealModel> products = new ArrayList<DealModel>();

		StringBuilder sqlQuery = new StringBuilder("call getProductDeals('" + query
				+ "'," + categoryId + "," + priceLower + "," + priceHigher
				+ ");");
		logger.info("Query executed: " + sqlQuery);
		ResultSet rs = readFromDB(sqlQuery.toString());

		while (rs.next()) {
			DealModel product = new DealModel();
			product.setProductId(rs.getInt("productId"));
			product.setDescription(rs.getString("description"));
			product.setSellerId(rs.getInt("sellerId"));
			product.setSellerName(rs.getString("firstName") + " "
					+ rs.getString("lastName"));
			product.setQuantity(rs.getInt("quantity"));
			product.setTitle(rs.getString("title"));
			String photoUrl = rs.getString("photo");
			if (photoUrl == null || photoUrl.isEmpty())
				product.setPhoto("/images/default-pic.jpg");
			else
				product.setPhoto(photoUrl);
			product.setPrice(rs.getInt("price"));
			product.setDealsId(rs.getInt("dealsId"));
			if (rs.getDate("dealStartDate") != null)
				product.setDealStartDate(rs.getDate("dealStartDate"));
			else
				product.setDealStartDate(new Date(1111, 11, 11));
			if (rs.getDate("dealEndDate") != null)
				product.setDealEndDate(rs.getDate("dealEndDate"));
			else
				product.setDealEndDate(new Date(1111, 11, 11));
			product.setDealEndDate(rs.getDate("dealEndDate"));
			product.setDealSellingPrice(rs.getInt("dealSellingPrice"));
			logger.info("Added a product: " + product);
			products.add(product);
		}
		logger.info("Size of products list is " + products.size());

		return products;
	}
}

// /***
// * This method is called when "All Categories" is selected and query is
// * EMPTY string.
// */
// public ArrayList<ProductModel> getProducts() {
// logger.info("Inside BrowseDAO : getProducts()");
// ArrayList<ProductModel> products = new ArrayList<ProductModel>();
// ResultSet rs = readFromDB("select * from product");
// try {
// while (rs.next()) {
// ProductModel product = new ProductModel();
//
// product.setProductId(rs.getInt("productId"));
// product.setDescription(rs.getString("description"));
// product.setSellerId(rs.getInt("sellerId"));
// product.setQuantity(rs.getInt("quantity"));
// product.setTitle(rs.getString("title"));
// product.setPhoto(rs.getString("photo"));
// product.setPrice(rs.getInt("price"));
// products.add(product);
// }
// logger.info("Size of products list is " + products.size());
// } catch (SQLException e) {
// logger.error("Error occurred", e);
// e.printStackTrace();
// }
// return products;
// }
//
// /***
// * This method is called when "All Categories" is selected and query is
// * non-empty string.
// */
// public ArrayList<ProductModel> getProducts(String query) {
// logger.info("Inside BrowseDAO : getProducts(query)");
// logger.info("query:" + query);
// ArrayList<ProductModel> products = new ArrayList<ProductModel>();
// if (query != null)
// System.out.println("query:" + query);
// ResultSet rs = readFromDB("select * from product where title like '%"
// + query + "%'");
// try {
// while (rs.next()) {
// ProductModel product = new ProductModel();
//
// product.setProductId(rs.getInt("productId"));
// product.setDescription(rs.getString("description"));
// product.setSellerId(rs.getInt("sellerId"));
// product.setQuantity(rs.getInt("quantity"));
// product.setTitle(rs.getString("title"));
// product.setPhoto(rs.getString("photo"));
// product.setPrice(rs.getInt("price"));
// products.add(product);
// }
// logger.info("Size of products list is " + products.size());
// } catch (SQLException e) {
// logger.error("Error occurred", e);
// e.printStackTrace();
// }
// return products;
// }
//
// /***
// * This method is called when a valid category is selected and query is
// * EMPTY string.
// */
// public ArrayList<ProductModel> getProducts(int categoryId) {
// logger.info("Inside BrowseDAO : getProducts(categoryId)");
// logger.info("categoryId:" + categoryId);
// ArrayList<ProductModel> products = new ArrayList<ProductModel>();
// // TODO SHOULD REFINE THIS QUERY TO ACCOMODATE CHECKING OF CATEGORY
// ResultSet rs = readFromDB("select * from product  ");
// try {
// while (rs.next()) {
// ProductModel product = new ProductModel();
//
// product.setProductId(rs.getInt("productId"));
// product.setDescription(rs.getString("description"));
// product.setSellerId(rs.getInt("sellerId"));
// product.setQuantity(rs.getInt("quantity"));
// product.setTitle(rs.getString("title"));
// product.setPhoto(rs.getString("photo"));
// product.setPrice(rs.getInt("price"));
// products.add(product);
// }
// logger.info("Size of products list is " + products.size());
// } catch (SQLException e) {
// logger.error("Error occurred", e);
// e.printStackTrace();
// }
// return products;
// }
//
// /***
// * This method is called when a valid category is selected and query is
// * non-empty string.
// */
// public ArrayList<ProductModel> getProducts(String query, int categoryId)
// {
// logger.info("Inside BrowseDAO : getProducts(query, categoryId)");
// logger.info("query:" + query + ", categoryId:" + categoryId);
// ArrayList<ProductModel> products = new ArrayList<ProductModel>();
// // TODO NEED TO REFINE THE QUERY
// ResultSet rs = readFromDB("select * from product where title like '%"
// + query + "%'");
// try {
// while (rs.next()) {
// ProductModel product = new ProductModel();
//
// product.setProductId(rs.getInt("productId"));
// product.setDescription(rs.getString("description"));
// product.setSellerId(rs.getInt("sellerId"));
// product.setQuantity(rs.getInt("quantity"));
// product.setTitle(rs.getString("title"));
// product.setPhoto(rs.getString("photo"));
// product.setPrice(rs.getInt("price"));
// products.add(product);
// }
// logger.info("Size of products list is " + products.size());
// } catch (SQLException e) {
// logger.error("Error occurred", e);
// e.printStackTrace();
// }
// return products;
// }