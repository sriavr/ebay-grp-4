package edu.iiitb.ebay.action;

import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import edu.iiitb.ebay.model.*;
import edu.iiitb.ebay.model.entity.*;
import edu.iiitb.ebay.dao.*;

public class RegisterAction extends ActionSupport {

	private String firstName;
	private String lastName;
	private String homeAddress;
	private String city;
	private String state;
	private String pinCode;
	private String phNumber;
	private String emailId;
	private String userId;
	private String password;
	private String rePassword;
	private String dob;
	private String action;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private String subject = "eBay Registration Mail" ;
	private String  message = "Successfully Registered to eBay." ;
	public String execute() {

		UserModel userRegister = new UserModel();

		System.out.println("first name : " + getFirstName() + "pin code : "
				+ getPinCode() +" dob: " + getDob());
		userRegister.setFirstName(getFirstName());
		userRegister.setLastName(getLastName());
		userRegister.setHomeAddress(getHomeAddress());
		userRegister.setCity(getCity());
		// userRegister.setState(getState());
		userRegister.setPinCode(Long.parseLong(getPinCode()));
		userRegister.setTelephoneNo(getPhNumber());
		userRegister.setEmail(getEmailId());
		userRegister.setPassword(getPassword());
		userRegister.setDob(getDob());
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.insertNewUser(userRegister);
			userDAO.sendEmail(getEmailId(), subject, message);
		} catch (Exception e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
