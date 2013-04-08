package edu.iiitb.ebay.dao;

import edu.iiitb.ebay.model.entity.SubmitFeedBackModel;

public class SubmitFeedBackDAO extends BaseDAO{

	public void submitFeedback(SubmitFeedBackModel submitFeedbackModel) {
		// TODO Auto-generated method stub
		
		String query="insert into userFeedBack(userId,sellerId,rate,rating1,rating2,rating3,productId,description) values("
				+ submitFeedbackModel.getUserId() + ","
				+ submitFeedbackModel.getSellerId() + ",'"
				+ submitFeedbackModel.getRate() + "',"
				+ submitFeedbackModel.getRate1() + ","
				+ submitFeedbackModel.getRate2() + ","
				+ submitFeedbackModel.getRate3() + ","
				+ submitFeedbackModel.getProductId() + ",'"
				+ submitFeedbackModel.getDescription() + "');";
		
		        BaseDAO.update(query);
	}

}
