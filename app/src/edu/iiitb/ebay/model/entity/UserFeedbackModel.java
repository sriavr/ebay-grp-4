/**
 * 
 */
package edu.iiitb.ebay.model.entity;

/**
 * @author Pratibind Kumar Jha
 * @version 1.0 @
 * @since 1 April 2013
 */
public class UserFeedbackModel {
	private int userFeedBackId;
	private int userId;
	private int sellerId;
	private String rate;
	private int rating1;
	private int rating2;
	private int rating3;
	private int productId;
	private String description;

	/**
	 * @return the userFeedBackId
	 */
	public int getUserFeedBackId() {
		return userFeedBackId;
	}

	/**
	 * @param userFeedBackId
	 *            the userFeedBackId to set
	 */
	public void setUserFeedBackId(int userFeedBackId) {
		this.userFeedBackId = userFeedBackId;
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
	 * @return the sellerId
	 */
	public int getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId
	 *            the sellerId to set
	 */
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * @return the rating1
	 */
	public int getRating1() {
		return rating1;
	}

	/**
	 * @param rating1
	 *            the rating1 to set
	 */
	public void setRating1(int rating1) {
		this.rating1 = rating1;
	}

	/**
	 * @return the rating2
	 */
	public int getRating2() {
		return rating2;
	}

	/**
	 * @param rating2
	 *            the rating2 to set
	 */
	public void setRating2(int rating2) {
		this.rating2 = rating2;
	}

	/**
	 * @return the rating3
	 */
	public int getRating3() {
		return rating3;
	}

	/**
	 * @param rating3
	 *            the rating3 to set
	 */
	public void setRating3(int rating3) {
		this.rating3 = rating3;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
