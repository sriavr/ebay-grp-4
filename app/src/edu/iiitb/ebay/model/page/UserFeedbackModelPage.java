/**
 * 
 */
package edu.iiitb.ebay.model.page;

/**
 * @author Pratibind Kumar Jha
 * @version 1.0
 */
public class UserFeedbackModelPage {

	// product id
	private int productID;

	// product Name
	private int productName;

	private int feedbackScore;
	private float positiveFeedback;
	private int total;

	// rating aug. values.
	private float avgRating1;
	private float avgRating2;
	private float avgRating3;

	// no. of rating
	private int rating1;
	private int rating2;
	private int rating3;

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the productName
	 */
	public int getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(int productName) {
		this.productName = productName;
	}

	/**
	 * @return the feedbackScore
	 */
	public int getFeedbackScore() {
		return feedbackScore;
	}

	/**
	 * @param feedbackScore
	 *            the feedbackScore to set
	 */
	public void setFeedbackScore(int feedbackScore) {
		this.feedbackScore = feedbackScore;
	}

	/**
	 * @return the avgRating1
	 */
	public float getAvgRating1() {
		return avgRating1;
	}

	/**
	 * @param avgRating1
	 *            the avgRating1 to set
	 */
	public void setAvgRating1(float avgRating1) {
		this.avgRating1 = avgRating1;
	}

	/**
	 * @return the avgRating2
	 */
	public float getAvgRating2() {
		return avgRating2;
	}

	/**
	 * @param avgRating2
	 *            the avgRating2 to set
	 */
	public void setAvgRating2(float avgRating2) {
		this.avgRating2 = avgRating2;
	}

	/**
	 * @return the avgRating3
	 */
	public float getAvgRating3() {
		return avgRating3;
	}

	/**
	 * @param avgRating3
	 *            the avgRating3 to set
	 */
	public void setAvgRating3(float avgRating3) {
		this.avgRating3 = avgRating3;
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
	 * @return the positiveFeedback
	 */
	public float getPositiveFeedback() {
		return positiveFeedback;
	}

	/**
	 * @param positiveFeedback
	 *            the positiveFeedback to set
	 */
	public void setPositiveFeedback(float positiveFeedback) {
		this.positiveFeedback = positiveFeedback;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}
