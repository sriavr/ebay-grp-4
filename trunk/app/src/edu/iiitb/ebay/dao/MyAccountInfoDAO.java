/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.model.page.MyBankDetailsModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class MyAccountInfoDAO {

	public static Logger logger = Logger.getLogger(MyAccountInfoDAO.class);

	public static MyBankDetailsModel getBankDetails(String whereClouse)
			throws Exception {
		MyBankDetailsModel bankDetails = new MyBankDetailsModel();
		String query = "SELECT u.firstName,u.lastName,u.email,u.userId,bank.bankId,bank.accountNum,bank.atmNum,"
				+ " bank.pinNum,bank.password,bank.balance FROM bank  JOIN user u ON u.userId=bank.userId "
				+ whereClouse;
		logger.info(query);
		ResultSet rs = BaseDAO.readFromDB(query);
		while (rs.next()) {
			bankDetails.setUserId(rs.getInt("u.userId"));
			bankDetails.setFirstName(rs.getString("u.firstName"));
			bankDetails.setLastName(rs.getString("u.lastName"));
			bankDetails.setEmail(rs.getString("u.email"));
			bankDetails.setBankId(rs.getInt("bankId"));
			bankDetails.setAccoutNum(rs.getInt("accountNum"));
			bankDetails.setAtmNum(rs.getInt("atmNum"));
			bankDetails.setPin(rs.getInt("pinNum"));
			bankDetails.setBankPassword(rs.getString("bank.password"));
			bankDetails.setBalance(rs.getInt("balance"));
		}
		return bankDetails;
	}
}
