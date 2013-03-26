/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

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

	public ArrayList<CategoryModel> getRelevantCategories() {
		logger.info("Inside BrowseDAO : getRelevantCategories()");
		ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();

		java.sql.Connection con = BaseDAO.getConnection();
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
			// TODO Auto-generated catch block
			logger.error("Error occurred", e);
			e.printStackTrace();
		}
		return categories;
	}

	public ArrayList<ProductModel> getProducts(String query) {
		logger.info("Inside BrowseDAO : getProducts(query)");
		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
		if (query != null)
			System.out.println("query:" + query);
		java.sql.Connection con = BaseDAO.getConnection();
		ResultSet rs = readFromDB("select * from product where title like '%"
				+ query + "%'");
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

	public ArrayList<ProductModel> getProducts() {
		logger.info("Inside BrowseDAO : getProducts(query)");
		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
		java.sql.Connection con = BaseDAO.getConnection();
		ResultSet rs = readFromDB("select * from product");
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
