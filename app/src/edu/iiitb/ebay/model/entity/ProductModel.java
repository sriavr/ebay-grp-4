/**
 * 
 */
package edu.iiitb.ebay.model.entity;

/**
 * @author Sridhar Jammalamadaka
 * @version 1.0
 */
public class ProductModel {
	protected int productId;
	protected int sellerId;
	protected String title;
	protected String description;
	protected int price;
	protected int quantity;
	protected String photo;
    protected int discount;

    //This is not in DB but included it here for convenience of displaying Seller Name along with Product
	protected String sellerName;

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
