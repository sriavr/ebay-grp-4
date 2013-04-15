/**
 * 
 */
package edu.iiitb.ebay.model.page;

/**
 * @author Pratibind Kumar Jha
 * 
 */
/**
 * @author Pratibind Kumar Jha
 * 
 */
public class MyBankDetailsModel {

	// Bank Info
	private int bankId;
	private int accoutNum;
	private int atmNum;
	private int pin;
	private String bankPassword;
	private int balance;

	// user info
	private int userId;
	private String firstName;
	private String lastName;
	private String email;

	/**
	 * @return the bankId
	 */
	public int getBankId() {
		return bankId;
	}

	/**
	 * @param bankId
	 *            the bankId to set
	 */
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the accoutNum
	 */
	public int getAccoutNum() {
		return accoutNum;
	}

	/**
	 * @param accoutNum
	 *            the accoutNum to set
	 */
	public void setAccoutNum(int accoutNum) {
		this.accoutNum = accoutNum;
	}

	/**
	 * @return the atmNum
	 */
	public int getAtmNum() {
		return atmNum;
	}

	/**
	 * @param atmNum
	 *            the atmNum to set
	 */
	public void setAtmNum(int atmNum) {
		this.atmNum = atmNum;
	}

	/**
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * @param pin
	 *            the pin to set
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}

	/**
	 * @return the bankPassword
	 */
	public String getBankPassword() {
		return bankPassword;
	}

	/**
	 * @param bankPassword
	 *            the bankPassword to set
	 */
	public void setBankPassword(String bankPassword) {
		this.bankPassword = bankPassword;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
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

}
