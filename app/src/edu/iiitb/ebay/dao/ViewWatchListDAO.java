/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.iiitb.ebay.model.page.ViewWatchListModel;
import edu.iiitb.ebay.util.DatabaseUtil;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class ViewWatchListDAO {
	public static ArrayList<ViewWatchListModel> getWatchListModel(int userId) {
		ArrayList<ViewWatchListModel> watchListObject = new ArrayList<ViewWatchListModel>();
		ResultSet rs = null;
		String Query = "SELECT pd.description,pd.productId,pd.title,pd.photo,pd.quantity,pd.price, uwl.userwishlistId "
				+ "FROM userwishlist uwl JOIN product pd ON pd.productId=uwl.productId"
				+ " WHERE uwl.userId=" + userId;
		try {
			rs = BaseDAO.readFromDB(Query);
			while (rs.next()) {
				watchListObject.add(getViewWatchListModelObject(rs));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			BaseDAO.close(rs);
		}
		return watchListObject;
	}

	// get watchListObject from resultset
	public static ViewWatchListModel getViewWatchListModelObject(ResultSet rs) {
		ViewWatchListModel viewWatchListModelObject = new ViewWatchListModel();
		try {
			viewWatchListModelObject.setDescription(rs
					.getString("pd.description"));
			viewWatchListModelObject.setWatchListId(rs
					.getInt("uwl.userwishlistId"));
			viewWatchListModelObject.setProductId(rs.getInt("pd.productId"));
			viewWatchListModelObject.setProductTitle(rs.getString("pd.title"));
			viewWatchListModelObject.setQuantityAvailable(rs
					.getInt("pd.quantity"));
			viewWatchListModelObject.setPrice(rs.getInt("price"));
			viewWatchListModelObject.setPhoto(rs.getString("pd.photo"));
			viewWatchListModelObject.setActions("Buy Now");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return viewWatchListModelObject;
	}

	// Remove the watchlist item from list.
	public static int removeFromWatchListDAO(int wishlistId) {
		int status = 0;
		String Query = "DELETE FROM userwishlist WHERE userWishListId="
				+ wishlistId;
		try {
			status = BaseDAO.update(Query);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		}
		return status;
	}

	// add item to watchList
	public static int addToWatchListDAO(int productId, int userId) {
		int status = 0;
		int watchListId = 0;
		int flag = 0;
		String Query = "SELECT max(userWishListId)as watchListId FROM userwishlist";
		// to check whether product has been all ready add by perticular user.
		String Query2 = "SELECT userWishListId FROM userwishlist WHERE productId="
				+ productId + " AND userId=" + userId;
		ResultSet rs = null;
		// check user has allready add the product into watchlist.
		try {
			rs = BaseDAO.readFromDB(Query2);
			while (rs.next()) {
				flag = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDAO.close(rs);
		}

		if (flag == 1) {
			return -1;
		}

		// retrive the next watchlistid.
		try {
			rs = BaseDAO.readFromDB(Query);
			while (rs.next()) {
				watchListId = rs.getInt("watchListId");
				System.out.println("Max wishlist IS is : " + watchListId);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDAO.close(rs);
		}
		String Query1 = "INSERT INTO userwishlist ( `userWishListId`, `productId`,`userId`) VALUES(?,?,?)";
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con.prepareStatement(Query1);
			DatabaseUtil.ps.setInt(1, watchListId + 1);
			DatabaseUtil.ps.setInt(2, productId);
			DatabaseUtil.ps.setInt(3, userId);
			System.out.println("Prespare Statement: " + DatabaseUtil.ps);
			status = DatabaseUtil.ps.executeUpdate();
			System.out.println("Add To WATCHLIST: Query output is:  " + status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DatabaseUtil.connectionClose();
		}
		return status;
	}
}