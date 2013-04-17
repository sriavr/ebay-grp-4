/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.DealModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.page.CartPageModel;
import edu.iiitb.ebay.model.page.CategoryProductsModel;

/**
 * @author Pavan
 * 
 */
public class DealsDAO extends BaseDAO {
	private static Logger logger = Logger.getLogger(DealsDAO.class);

	public ArrayList<CategoryProductsModel> getProductGroups() {
		logger.info("Inside getProductsGroup method");
		ArrayList<CategoryProductsModel> productGroups = new ArrayList<CategoryProductsModel>();
		logger.info("Created empty list of productGroups");
		// cartList.add(cpm);
		// productList.add(catName);
		ArrayList<CategoryModel> categoryList = parentCategoryIdList();
		logger.info("Retrieved parentCategoryList size:" + categoryList.size());
		for (int i = 0; i < categoryList.size(); i++) {
			CategoryProductsModel catProdModel = new CategoryProductsModel();
			logger.info("Added a category "
					+ categoryList.get(i).getCategoryName());
			catProdModel.setCategory(categoryList.get(i));
			logger.info("calling setDeals method");
			catProdModel
					.setDeals(getDeals(categoryList.get(i).getCategoryID()));
			productGroups.add(catProdModel);
		}
		logger.info("returning to Action with productGroups");
		return productGroups;
	}

	private ArrayList<DealModel> getDeals(String categoryID) {
		logger.info("Inside getDeals method categoryID:" + categoryID);
		ArrayList<DealModel> deals = new ArrayList<DealModel>();

		String query = "call getDeals(''," + categoryID + ",0,0);";
		logger.info("query: " + query);
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				DealModel deal = new DealModel();
				deal.setProductId(rs.getInt("productId"));
				deal.setTitle(rs.getString("title"));
				deal.setQuantity(rs.getInt("quantity"));
				deal.setPrice(rs.getInt("price"));
				deal.setPhoto(rs.getString("photo"));
				deal.setDiscount(rs.getInt("discount"));
				deal.setSellerId(rs.getInt("sellerId"));
				deal.setDealsId(rs.getInt("dealsId"));
				deal.setDealStartDate(rs.getDate("dealStartDate"));
				deal.setDealEndDate(rs.getDate("dealEndDate"));
				deal.setDealSellingPrice(rs.getInt("dealSellingPrice"));
				deals.add(deal);
				logger.info("Added a deal with dealId:" + deal.getDealsId());
			}
		} catch (SQLException e) {
			logger.error("Error occurred:" + e);
			e.printStackTrace();
		}
		logger.info("returning deals size:" + deals.size());
		return deals;
	}

	public ArrayList<String> parentCategoryList() {
		String query = "SELECT categoryName FROM category WHERE parentCategoryId=0";
		ResultSet rs = readFromDB(query);
		ArrayList<String> catList = null;
		String catName;
		try {
			catList = new ArrayList<String>();
			while (rs.next()) {
				catName = rs.getString("catgoryName");
				catList.add(catName);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			catList = null;
			e.printStackTrace();
		}
		return catList;
	}

	public ArrayList<CategoryModel> parentCategoryIdList() {
		String query = "SELECT * FROM category WHERE parentCategoryId=0";
		ResultSet rs = readFromDB(query);
		ArrayList<CategoryModel> catList = null;
		try {
			catList = new ArrayList<CategoryModel>();
			while (rs.next()) {
				CategoryModel catModel = new CategoryModel();
				catModel.setCategoryID(Integer.toString((rs
						.getInt("categoryId"))));
				catModel.setCategoryName(rs.getString("categoryName"));
				catModel.setParentCategoryId(Integer.toString(rs
						.getInt("parentCategoryId")));
				catList.add(catModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			catList = null;
			e.printStackTrace();
		}
		return catList;
	}

	public ArrayList<Integer> getCategoryIdList(int categoryNo) {
		String query = "SELECT categoryId FROM category WHERE parentCategoryId="
				+ categoryNo;
		ResultSet rs = readFromDB(query);
		ArrayList<Integer> catList = null;
		int catName = 0;
		try {
			catList = new ArrayList<Integer>();
			while (rs.next()) {
				catName = rs.getInt("catgoryId");
				catList.add(catName);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			catList = null;
			e.printStackTrace();
		}
		return catList;
	}

	public ArrayList<Integer> getProductIdList(int categoryNo) {
		String query = "SELECT productId FROM productcategorymapping WHERE CategoryId="
				+ categoryNo;
		ResultSet rs = readFromDB(query);
		ArrayList<Integer> productList = null;
		int catName = 0;
		try {
			productList = new ArrayList<Integer>();
			while (rs.next()) {
				catName = rs.getInt("productId");
				productList.add(catName);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			productList = null;
			e.printStackTrace();
		}
		return productList;
	}

	public DealModel getDealModel(int productNo) {
		String query = "SELECT sellerId,dealsId,dealStartDate,dealEndDate,dealSellingPrice,title,quantity,price,photo,discount FROM deals, product WHERE product.productId="
				+ productNo + " AND deals.productId=" + productNo;
		ResultSet rs = readFromDB(query);
		// int sellPrice = 0;
		DealModel dm = new DealModel();
		// Integer catName;
		try {
			// productList=new ArrayList<Integer>();
			if (rs.next()) {
				dm.setProductId(productNo);
				dm.setProductId(productNo);
				dm.setTitle(rs.getString("title"));
				dm.setQuantity(rs.getInt("quantity"));
				dm.setPrice(rs.getInt("price"));
				dm.setPhoto(rs.getString("photo"));
				dm.setDiscount(rs.getInt("discount"));
				dm.setSellerId(rs.getInt("sellerId"));
				dm.setDealsId(rs.getInt("dealsId"));
				dm.setDealStartDate(rs.getDate("dealStartDate"));
				dm.setDealEndDate(rs.getDate("dealEndDate"));
				dm.setDealSellingPrice(rs.getInt("dealSellingPrice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// sellPrice = -1;
			e.printStackTrace();
		}
		return dm;
	}

	public CategoryModel getCategoryModel(int categoryNo) {
		String query = "SELECT categoryId,categoryName,parentCategoryId FROM category WHERE categoryId="
				+ categoryNo;
		ResultSet rs = readFromDB(query);
		// int sellPrice = 0;
		CategoryModel dm = new CategoryModel();
		// Integer catName;
		try {
			// productList=new ArrayList<Integer>();
			while (rs.next()) {
				dm.setCategoryID(Integer.toString((rs.getInt("categoryId"))));
				dm.setCategoryName(rs.getString("categoryName"));
				dm.setParentCategoryId(Integer.toString(rs
						.getInt("parentCategoryId")));

			}
		} catch (SQLException e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
		}
		return dm;
	}

	// Added by DEbargha to save deals

	public boolean saveDeals(DealModel deal) {
		
		ProductDetailsDAO dao=new ProductDetailsDAO();
		
		ProductModel pm = dao.getProductDetails(deal.getProductId());
		System.out.println("price discount:"+pm.getPrice()+" "+pm.getDiscount());
		System.out.println(deal.getDealSellingPrice());
		if(deal.getDealSellingPrice()> (pm.getPrice()-pm.getDiscount()))
		{
			System.out.println("here");
			return false;
		}
		
		String query1="DELETE FROM deals WHERE productId="+deal.getProductId();
		update(query1);
		
		String query = "insert into deals(productId,dealStartDate,dealEndDate,dealSellingPrice) values("
				+ deal.getProductId()
				+ ",'"
				+ deal.getDealStartDate()
				+ "','"
				+ deal.getDealEndDate() + "'," + deal.getDealSellingPrice() + ")";

		System.out.println(query);
		try {
			System.out.println(update(query));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return true;
	}

}
