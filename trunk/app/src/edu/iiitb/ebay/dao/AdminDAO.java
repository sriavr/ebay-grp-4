package edu.iiitb.ebay.dao;

import edu.iiitb.ebay.model.entity.AdminModel;
import edu.iiitb.ebay.util.DatabaseUtil;
import edu.iiitb.ebay.util.LogMessage;

public class AdminDAO {
	// This method validates the admin credentials. If valid, it will return a
	// admin object else returns null
	public AdminModel login(String userName, String password) {
		AdminModel admin = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("SELECT * FROM admin WHERE adminUserName=? AND adminPassword=?");
			LogMessage
					.log("Message From AdminDAO.login : Arguments ::username is--"
							+ userName + " password is--" + password);
			DatabaseUtil.ps.setString(1, userName);
			DatabaseUtil.ps.setString(2, password);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				admin = new AdminModel();
				admin.setAdminID(DatabaseUtil.rs.getInt("adminID"));
				admin.setAdminName(DatabaseUtil.rs.getString("adminUserName"));
				admin.setPassword(DatabaseUtil.rs.getString("adminPassword"));
				flag = 1;// setting flag = 1 says that a admin credentials are
							// validated and there is an admin with the given
							// credentials
				LogMessage.log("Message From AdminDAO.login : username is "
						+ admin.getAdminName());
			}

		} catch (Exception e) {
			LogMessage.log("Exception Caught in AdminDAO.login");
			e.printStackTrace();
			admin = null;
		} finally {
			if (flag != 1)
				admin = null;
			DatabaseUtil.connectionClose();
		}

		return admin;
	}
}
