/**
 * 
 */
package edu.iiitb.ebay.dao;

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
		String Query = "SELECT * FROM user JOIN country ON user.countryId=country.countryId JOIN state "
				+ " ON state.stateId=user.stateId " + whereClouse;
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
			userModelObj.setCountryName(rs.getString("country"));
			userModelObj.setStateName(rs.getString("state"));
			userModelObj.setPinCode(rs.getInt("pinCode"));
			userModelObj.setTelephoneNo(rs.getLong("telephoneNo"));
			userModelObj.setEmail(rs.getString("email"));
			userModelObj.setPassword(rs.getString("password"));
			userModelObj.setDob(rs.getString("dob"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userModelObj;
	}
}
