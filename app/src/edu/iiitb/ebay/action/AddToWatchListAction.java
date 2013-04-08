/**
 * 
 */
package edu.iiitb.ebay.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.ViewWatchListDAO;
import edu.iiitb.ebay.model.entity.UserModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class AddToWatchListAction extends ActionSupport {

	private int productId;

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

	public String addWatchList() {
		Map<String, Object> session;
		UserModel userModel;
		int userId = 0;
		int result;
		session = ActionContext.getContext().getSession();
		String Role = (String) session.get("role");
		if (Role.equals("user")) {
			userModel = (UserModel) session.get("user");
			userId = userModel.getUserId();
		}
		if (userId != 0) {
			result = ViewWatchListDAO.addToWatchListDAO(getProductId(), userId);
			if (result == 0) {
				addActionError("Error occur in this action");
				return "fail";
			}
		} else {
			addActionError("Please Login");
			return "login";
		}
		return "success";
	}
}
