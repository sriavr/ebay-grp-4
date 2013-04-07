package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.util.ConstantValues;

public class NotifySellersOutOfStockDAO extends BaseDAO{

	public ArrayList<ProductModel> getProductsOutOfStock() {
		String query = "SELECT * FROM product WHERE quantity<"+ConstantValues.productLimitForOutOfStock;
		ResultSet rs = readFromDB(query);
		ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
		try {
			while(rs.next()){
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setSellerId(rs.getInt("sellerId"));
				product.setQuantity(rs.getInt("quantity"));
				product.setTitle(rs.getString("title"));
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			productList=null;
			e.printStackTrace();
		}
		return productList;
	}

}
