package edu.iiitb.ebay.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Blob;
import edu.iiitb.ebay.model.entity.UserModel;
import edu.iiitb.ebay.util.DatabaseUtil;
import edu.iiitb.ebay.util.LogMessage;

public class UserDAO extends BaseDAO {
	Logger logger = Logger.getLogger(UserDAO.class);

	// This method validates the student credentials. If valid, returns a
	// student object else returns null
	public UserModel login(String userName, String password) {
		UserModel user = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("select * from user where email=? and password=?");
			LogMessage
					.log("Message From UserDAO.login : Arguments ::username is--"
							+ userName + " password is--" + password);
			DatabaseUtil.ps.setString(1, userName);
			DatabaseUtil.ps.setString(2, password);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				user = new UserModel();
				user.setCity(DatabaseUtil.rs.getString("city"));
				// user.setCountryId(DatabaseUtil.rs.getInt("countryId"));
				user.setEmail(DatabaseUtil.rs.getString("email"));
				user.setFirstName(DatabaseUtil.rs.getString("firstName"));
				user.setLastName(DatabaseUtil.rs.getString("lastName"));
				user.setPassword(DatabaseUtil.rs.getString("password"));
				user.setPinCode(DatabaseUtil.rs.getLong("pinCode"));
				// user.setStateId(DatabaseUtil.rs.getInt("stateId"));
				user.setTelephoneNo(DatabaseUtil.rs.getString("telephoneNo"));
				user.setUserId(DatabaseUtil.rs.getInt("userId"));
				LogMessage.log("Message From userDAO.login : student Name is "
						+ user.getFirstName());
			}

		} catch (Exception e) {
			LogMessage.log("Exception Caught in studentDAO.login");
			e.printStackTrace();
			user = null;
		} finally {

			DatabaseUtil.connectionClose();
		}

		return user;
	}

	public UserModel getUserDetails(int userId) {
		logger.info("Inside getUserDetails method");
		UserModel user = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("select * from user where userId=?");
			LogMessage
					.log("Message From UserDAO.getUserDetails : Arguments ::userId is--"
							+ userId);
			DatabaseUtil.ps.setInt(1, userId);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				user = new UserModel();
				user.setCity(DatabaseUtil.rs.getString("city"));
				user.setEmail(DatabaseUtil.rs.getString("email"));
				user.setFirstName(DatabaseUtil.rs.getString("firstName"));
				user.setLastName(DatabaseUtil.rs.getString("lastName"));
				user.setPassword(DatabaseUtil.rs.getString("password"));
				user.setPinCode(DatabaseUtil.rs.getLong("pinCode"));
				user.setTelephoneNo(DatabaseUtil.rs.getString("telephoneNo"));
				user.setUserId(DatabaseUtil.rs.getInt("userId"));
				user.setHomeAddress(DatabaseUtil.rs.getString("homeAddress"));
				user.setCity(DatabaseUtil.rs.getString("city"));
				logger.info("Message From userDAO.getUserDetails : student Name is "
						+ user.getFirstName());
				logger.info("Found a user");
			}

		} catch (Exception e) {
			logger.error("Exception Caught in studentDAO.login", e);
			e.printStackTrace();
			user = null;
		} finally {
			DatabaseUtil.connectionClose();
		}

		return user;
	}

	public void insertNewUser(UserModel user) {
		// TODO should remove hardcodings
		logger.info("Inside insertUser method");
		String insertQuery = "INSERT INTO `user` ( `firstName`, `lastName`, `homeAddress`, `city`, `pinCode`, "
				+ "`telephoneNo`, `email`, `password`, `secretQId`, `secretAnswer`, `dob`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		logger.info("Query to be run:" + insertQuery);
		try {
			PreparedStatement ps = getConnection()
					.prepareStatement(insertQuery);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getHomeAddress());
			ps.setString(4, user.getCity());
			ps.setLong(5, user.getPinCode());
			ps.setString(6, user.getTelephoneNo());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPassword());
			ps.setInt(9, 1);
			ps.setString(10, "tommy");
			// ps.setInt(10, user.getSecretQnId());
			// ps.setString(11, user.getSecretAnswer());
			ps.setDate(11, new java.sql.Date(0));
			// ps.setDate(12, );
			update(ps);
		} catch (SQLException e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
		}
	}
}
