/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.UserModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class MangeUserInfoDAO {

	// get arraylist of user model object
	public static ArrayList<UserModel> getUserModelList(String whereClouse) {

		ArrayList<UserModel> userModel = new ArrayList<UserModel>();
		String Query = "SELECT * FROM user " + whereClouse;
		ResultSet rs = null;
		try {
			rs = BaseDAO.readFromDB(Query);
			while (rs.next()) {
				userModel.add(getUserModelObject(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			BaseDAO.close(rs);
		}
		return userModel;
	}

	// get the usermodel object from result set.
	public static UserModel getUserModelObject(ResultSet rs) {
		UserModel userModelObj = new UserModel();
		try {
			userModelObj.setUserId(rs.getInt("userId"));
			userModelObj.setFirstName(rs.getString("firstName"));
			userModelObj.setLastName(rs.getString("lastName"));
			userModelObj.setHomeAddress(rs.getString("homeAddress"));
			userModelObj.setCity(rs.getString("city"));
			// userModelObj.setCountryName(rs.getString("country"));
			// userModelObj.setStateName(rs.getString("state"));
			userModelObj.setPinCode(rs.getInt("pinCode"));
			userModelObj.setTelephoneNo(rs.getString("telephoneNo"));
			userModelObj.setEmail(rs.getString("email"));
			userModelObj.setPassword(rs.getString("password"));
			userModelObj.setDob(rs.getString("dob"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userModelObj;
	}

	// save the edited user info into database
	public static int saveUserInfo(UserModel userModel) {
		int status = 0;
		try {
			PreparedStatement ps = BaseDAO
					.getConnection()
					.prepareStatement(
							"UPDATE user set firstName=?, "
									+ " lastName=?, homeAddress=?, city=?, pinCode=?, telephoneNo=?, email=?, password=?  WHERE userId=?");
			ps.setString(1, userModel.getFirstName());
			ps.setString(2, userModel.getLastName());
			ps.setString(3, userModel.getHomeAddress());
			ps.setString(4, userModel.getCity());
			ps.setLong(5, userModel.getPinCode());
			ps.setString(6, userModel.getTelephoneNo());
			ps.setString(7, userModel.getEmail());
			ps.setString(8, userModel.getPassword());
			ps.setInt(9, userModel.getUserId());
			System.out.println("query:  " + ps.toString());
			status = BaseDAO.update(ps);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
}
