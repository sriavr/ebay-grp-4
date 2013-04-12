package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.ProductModel;

public class ProductDetailsDAO extends BaseDAO {
	Logger logger = Logger.getLogger(ProductDetailsDAO.class);

	public ProductModel getProductDetails(int productId) {
		logger.info("Inside ProductDetailsDAO : getProductDetails(productId)");
		logger.info("productId:" + productId);

		ProductModel product = new ProductModel();

		StringBuilder sqlQuery = new StringBuilder(
				"select * from product where productId = " + productId);

		logger.info("Query executed: " + sqlQuery);
		ResultSet rs = readFromDB(sqlQuery.toString());
		try {
			if (rs.next()) {
				product.setProductId(rs.getInt("productId"));
				product.setDescription(rs.getString("description"));
				product.setSellerId(rs.getInt("sellerId"));
				product.setQuantity(rs.getInt("quantity"));
				product.setTitle(rs.getString("title"));
				String photoUrl = rs.getString("photo");
				if (photoUrl == null || photoUrl.isEmpty())
					product.setPhoto("/images/default-pic.jpg");
				else
					product.setPhoto(photoUrl);
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				logger.info("found a product");
			} else {
				logger.warn("no product with matching productId found");
			}

		} catch (SQLException e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
		}
		return product;
	}

	public CategoryModel getCategoryOfProduct(String productId) {
		logger.info("Inside ProductDetailsDAO : getCategoryOfProduct(productId)");
		logger.info("productId:" + productId);

		String sqlQuery = "select p.categoryId,categoryName,parentCategoryId  from productcategorymapping pm,category p  where pm.productId="
				+ productId + " and p.categoryId=pm.categoryId";
		CategoryModel cat = new CategoryModel();
		ResultSet rs = readFromDB(sqlQuery);
		try {
			if (rs.next()) {
				cat.setCategoryID(rs.getInt(1)+"");
				cat.setCategoryName(rs.getString(2)+"");
				cat.setParentCategoryId(rs.getInt(3)+"");
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		return cat;

	}
	
	public CategoryModel getCategory(String categoryId) {
		logger.info("Inside ProductDetailsDAO : getCategory(productId)");
		logger.info("productId:" + categoryId);

		String sqlQuery = "select * from category where categoryId ="+categoryId;
		CategoryModel cat = new CategoryModel();
		ResultSet rs = readFromDB(sqlQuery);
		try {
			if (rs.next()) {
				cat.setCategoryID(rs.getInt(1)+"");
				cat.setCategoryName(rs.getString(2)+"");
				cat.setParentCategoryId(rs.getInt(3)+"");
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		return cat;

	}
	
	

}
