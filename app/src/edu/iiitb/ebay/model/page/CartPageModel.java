package edu.iiitb.ebay.model.page;

import edu.iiitb.ebay.model.entity.ProductModel;

public class CartPageModel {
	int cartId;
	ProductModel product;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
}
