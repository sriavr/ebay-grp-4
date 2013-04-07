/**
 * 
 */
package edu.iiitb.ebay.model.page;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class ViewWatchListModel {
	private int watchListId;
	private int productId;
	private String productTitle;
	private int quantityAvailable;
	private int price;
	private String actions;

	/**
	 * @return the watchListId
	 */
	public int getWatchListId() {
		return watchListId;
	}

	/**
	 * @param watchListId
	 *            the watchListId to set
	 */
	public void setWatchListId(int watchListId) {
		this.watchListId = watchListId;
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
	 * @return the productTitle
	 */
	public String getProductTitle() {
		return productTitle;
	}

	/**
	 * @param productTitle
	 *            the productTitle to set
	 */
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	/**
	 * @return the quantityAvailable
	 */
	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	/**
	 * @param quantityAvailable
	 *            the quantityAvailable to set
	 */
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the actions
	 */
	public String getActions() {
		return actions;
	}

	/**
	 * @param actions
	 *            the actions to set
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}

}
