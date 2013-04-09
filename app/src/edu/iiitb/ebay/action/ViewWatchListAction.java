/**
 * 
 */
package edu.iiitb.ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.ViewWatchListDAO;
import edu.iiitb.ebay.model.entity.UserModel;
import edu.iiitb.ebay.model.page.ViewWatchListModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class ViewWatchListAction extends ActionSupport {

	private int watchListId;
	private int productId;
	private String fromSubmit;
	private List<Integer> selectedCheckBox;
	private ArrayList<ViewWatchListModel> viewWatchListModel;

	/**
	 * @return the watchListId
	 */
	public int getWatchListId() {
		return watchListId;
	}

	/**
	 * @param watchListId
	 *            the watchListId to set
	 */
	public void setWatchListId(int watchListId) {
		this.watchListId = watchListId;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the viewWatchListModel
	 */
	public ArrayList<ViewWatchListModel> getViewWatchListModel() {
		return viewWatchListModel;
	}

	/**
	 * @param viewWatchListModel
	 *            the viewWatchListModel to set
	 */
	public void setViewWatchListModel(
			ArrayList<ViewWatchListModel> viewWatchListModel) {
		this.viewWatchListModel = viewWatchListModel;
	}

	// Method for get List of watchlist.
	public String viewWatchList() {
		// code for view watchlist.
		Map<String, Object> session;
		int userId = 0;
		UserModel userModel;

		session = ActionContext.getContext().getSession();
		String Role = "";
		Role = (String) session.get("role");
		System.out.println("Role " + Role);
		if (Role == null) {
			addActionMessage("Please Login");
			return "fail";
		}
		if (Role.equals("user")) {
			userModel = (UserModel) session.get("user");
			userId = userModel.getUserId();
		} else {
			addActionMessage("Please Login");
			return "fail";
		}

		// hardcoded data

		this.viewWatchListModel = ViewWatchListDAO.getWatchListModel(userId);
		if (this.viewWatchListModel == null)
			addActionMessage("There is no item in WatchList");

		return "success";

	}
}
