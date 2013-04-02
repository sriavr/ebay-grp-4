/**
 * 
 */
package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.UserFeedbackDAO;
import edu.iiitb.ebay.model.entity.UserFeedbackModel;
import edu.iiitb.ebay.model.page.UserFeedbackModelPage;

/**
 * @author Pratibind Kumar Jha
 * @version 1.0
 */
public class ViewFeedbackAction extends ActionSupport {

	// product id
	private int productID;

	// userfeedback details.
	private UserFeedbackModel userFeedbackModel;

	private UserFeedbackModelPage userFeedbackModelPage;

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the userFeedbackModel
	 */
	public UserFeedbackModel getUserFeedbackModel() {
		return userFeedbackModel;
	}

	/**
	 * @param userFeedbackModel
	 *            the userFeedbackModel to set
	 */
	public void setUserFeedbackModel(UserFeedbackModel userFeedbackModel) {
		this.userFeedbackModel = userFeedbackModel;
	}

	/**
	 * @return the userFeedbackModelPage
	 */
	public UserFeedbackModelPage getUserFeedbackModelPage() {
		return userFeedbackModelPage;
	}

	/**
	 * @param userFeedbackModelPage
	 *            the userFeedbackModelPage to set
	 */
	public void setUserFeedbackModelPage(
			UserFeedbackModelPage userFeedbackModelPage) {
		this.userFeedbackModelPage = userFeedbackModelPage;
	}

	public String viewFeedback() {
		UserFeedbackModelPage pageModel = null;
		/*
		 * Map<String, Object> session; String role; int productId; // get the
		 * user information from session object. session =
		 * ActionContext.getContext().getSession(); role =
		 * (String)session.get("role"); UserModel student =
		 * (UserModel)session.get("user");
		 */
		int productID = this.getProductID();
		productID = 200;
		pageModel = UserFeedbackDAO.getFeedbackList(productID);
		if (pageModel == null)
			addActionMessage("There is no feedback available");
		else
			this.setUserFeedbackModelPage(pageModel);
		return "success";
	}
}
