package edu.iiitb.ebay.model.entity;

import java.io.File;
import java.util.Date;
import java.util.Timer;

import org.apache.catalina.User;

/**
 * 
 * @author svkris, modified by Sridhar
 * 
 *         Model class for student
 */
public class UserModel {
	private Integer userId;
	
	private String firstName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	public long getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(long telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String lastName;
	private String homeAddress;
	private String city;
	private Integer countryId;
	private Integer stateId;
	private long pinCode;
	private long telephoneNo;
	private String email;
	private String password;
	
}
