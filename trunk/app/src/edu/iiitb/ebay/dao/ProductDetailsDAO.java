package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

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

}
