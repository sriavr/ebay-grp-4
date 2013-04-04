/**
 * 
 */
package edu.iiitb.ebay.dao;

import java.sql.ResultSet;

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
						.getFloat("criteria1"));
				userFeedbackModel.setAvgRating2(DatabaseUtil.rs
						.getFloat("criteria2"));
				userFeedbackModel.setAvgRating3(DatabaseUtil.rs
						.getFloat("criteria3"));
				userFeedbackModel.setTotal(DatabaseUtil.rs.getInt("count"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DatabaseUtil.connectionClose();
		}

		String query1 = "SELECT COUNT(*) as positive  FROM userfeedback WHERE rate LIKE 'positive' AND productId="
				+ productID;
		ResultSet rst = BaseDAO.readFromDB(query1);
		int positiveFeedback = 0;
		try {
			while (rst.next()) {
				positiveFeedback = rst.getInt("positive");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DatabaseUtil.connectionClose();
		}
		System.out.println("totl: " + userFeedbackModel.getTotal()
				+ " positiveFeedback " + positiveFeedback);
		if (userFeedbackModel.getTotal() != 0) {
			float positiveScore = (float) (positiveFeedback * 100)
					/ (userFeedbackModel.getTotal());
			System.out.println("positiveScore " + positiveScore);

			// calcucalte the feedbackScore
			int feedbackscores = (int) (userFeedbackModel.getAvgRating1()
					+ userFeedbackModel.getAvgRating2() + userFeedbackModel
					.getAvgRating3()) / 3;

			userFeedbackModel.setFeedbackScore(feedbackscores * 10);
			userFeedbackModel.setPositiveFeedback(positiveScore);
		}
		return userFeedbackModel;

	}
}
