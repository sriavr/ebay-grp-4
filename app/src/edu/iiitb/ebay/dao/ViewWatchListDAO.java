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
		String Query = "SELECT max(userWishListId)as watchListId FROM userwishlist";
		ResultSet rs;
		try {
			rs = BaseDAO.readFromDB(Query);
			while (rs.next()) {
				watchListId = rs.getInt("watchListId");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String Query1 = "INSERT INTO userwishlist ( `userWishListId`, `userId`,`productId`) VALUES(?,?)";
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con.prepareStatement(Query1);
			DatabaseUtil.ps.setInt(1, watchListId + 1);
			DatabaseUtil.ps.setInt(2, productId);
			DatabaseUtil.ps.setInt(2, userId);
			status = DatabaseUtil.ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DatabaseUtil.connectionClose();
		}
		return status;
	}
}