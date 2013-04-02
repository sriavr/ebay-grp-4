package edu.iiitb.ebay.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Blob;
import edu.iiitb.ebay.model.entity.UserModel;
import edu.iiitb.ebay.util.DatabaseUtil;
import edu.iiitb.ebay.util.LogMessage;

public class UserDAO {
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
				//user.setCountryId(DatabaseUtil.rs.getInt("countryId"));
				user.setEmail(DatabaseUtil.rs.getString("email"));
				user.setFirstName(DatabaseUtil.rs.getString("firstName"));
				user.setLastName(DatabaseUtil.rs.getString("lastName"));
				user.setPassword(DatabaseUtil.rs.getString("password"));
				user.setPinCode(DatabaseUtil.rs.getLong("pinCode"));
				//user.setStateId(DatabaseUtil.rs.getInt("stateId"));
				user.setTelephoneNo(DatabaseUtil.rs.getLong("telephoneNo"));
				user.setUserId(DatabaseUtil.rs.getInt("userId"));
				LogMessage
						.log("Message From userDAO.login : student Name is "
								+ user.getFirstName() );
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

	
	
	
}
