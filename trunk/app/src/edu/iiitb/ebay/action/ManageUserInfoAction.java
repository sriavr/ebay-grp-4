/**
 * 
 */
package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.model.entity.UserModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class ManageUserInfoAction extends ActionSupport {
	// userModel object;
	private ArrayList<UserModel> userModel;
	// userid for modification
	private int userId;

	/**
	 * @return the userModel
	 */
	public ArrayList<UserModel> getUserModel() {
		return userModel;
	}

	/**
	 * @param userModel
	 *            the userModel to set
	 */
	public void setUserModel(ArrayList<UserModel> userModel) {
		this.userModel = userModel;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserInfoList() {

		return "";
	}

}
