/**
 * 
 */
package edu.iiitb.ebay.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.MangeUserInfoDAO;
import edu.iiitb.ebay.model.entity.UserModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class MyInfoDetailsAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(MyInfoDetailsAction.class);

	// userModel object;
	private ArrayList<UserModel> userModel;
	// userid for modification
	private int userId;
	private String firstName;
	private String lastName;
	private String homeAddress;
	private String city;
	private long pinCode;
	private String telephoneNo;
	private String email;
	private String password;

	// get userinformatio of perticular userId.
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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress
	 *            the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the pinCode
	 */
	public long getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode
	 *            the pinCode to set
	 */
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the telephoneNo
	 */
	public String getTelephoneNo() {
		return telephoneNo;
	}

	/**
	 * @param telephoneNo
	 *            the telephoneNo to set
	 */
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserInfo() {

		Map<String, Object> session;
		session = ActionContext.getContext().getSession();
		String Role = (String) session.get("role");
		System.out.println("role:" + Role);
		if (Role == null) {
			return "login";
		}
		if (Role.equals("admin")) {
			return "login";
		}
		this.setUserId(((UserModel) session.get("user")).getUserId());
		logger.info("User Id " + this.getUserId());
		String whereClouse = " WHERE userId=" + this.getUserId();
		this.setUserModel(MangeUserInfoDAO.getUserModelList(whereClouse));
		return "success";
	}

	// Save the user info into DB.
	public String saveMyInfoDetails() {
		Map<String, Object> session;
		session = ActionContext.getContext().getSession();
		String Role = (String) session.get("role");
		System.out.println("role:" + Role);
		if (Role == null) {
			return "login";
		}
		if (!Role.equals("user")) {
			logger.info("Role.equals(user): " + Role.equals("user"));
			return "login";
		}

		UserModel userModel = new UserModel();
		userModel.setUserId(this.getUserId());
		userModel.setFirstName(this.getFirstName());
		userModel.setLastName(this.getLastName());
		userModel.setHomeAddress(this.getHomeAddress());
		userModel.setCity(this.getCity());
		userModel.setPinCode(this.getPinCode());
		userModel.setEmail(this.getEmail());
		userModel.setTelephoneNo(this.getTelephoneNo());
		userModel.setPassword(this.getPassword());
		System.out.println("Name: " + userModel.getFirstName() + " UserId "
				+ this.getUserId());
		int status = MangeUserInfoDAO.saveUserInfo(userModel);
		if (status == 0)
			return "fail";
		addActionMessage("Save Successfull ");
		this.setUserId(((UserModel) session.get("user")).getUserId());
		logger.info("User Id " + this.getUserId());
		String whereClouse = " WHERE userId=" + this.getUserId();
		this.setUserModel(MangeUserInfoDAO.getUserModelList(whereClouse));
		return "success";
	}
}
