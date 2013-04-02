/**
 * 
 */
package edu.iiitb.ebay.dao;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.model.page.UserFeedbackModelPage;
import edu.iiitb.ebay.util.DatabaseUtil;

/**
 * @author Pratibind Kumar Jha
 * @version 1.0
 */
public class UserFeedbackDAO {
	public static Logger logger = Logger.getLogger(UserFeedbackDAO.class);

	// get the feedback List for perticular product.
	public static UserFeedbackModelPage getFeedbackList(int productID) {
		UserFeedbackModelPage userFeedbackModel = new UserFeedbackModelPage();
		String Query = "SELECT productId, AVG(rating1)as criteria1,AVG(rating2) as criteria2,"
				+ "AVG(rating3) as criteria3,SUM(rating1)as c1 ,SUM(rating2) as c2 ,SUM(rating3) as c3,COUNT(*) as count"
				+ " FROM userfeedback GROUP BY productID HAVING productId=?";
		logger.info(Query);
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con.prepareStatement(Query);
			DatabaseUtil.ps.setInt(1, productID);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				userFeedbackModel.setProductID(DatabaseUtil.rs
						.getInt("productID"));
				userFeedbackModel.setRating1(DatabaseUtil.rs.getInt("c1"));
				userFeedbackModel.setRating2(DatabaseUtil.rs.getInt("c2"));
				userFeedbackModel.setRating3(DatabaseUtil.rs.getInt("c3"));
				userFeedbackModel.setAvgRating1(DatabaseUtil.rs
						.getInt("criteria1"));
				userFeedbackModel.setAvgRating2(DatabaseUtil.rs
						.getInt("criteria2"));
				userFeedbackModel.setAvgRating3(DatabaseUtil.rs
						.getInt("criteria3"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DatabaseUtil.connectionClose();
		}
		return userFeedbackModel;

	}
}
