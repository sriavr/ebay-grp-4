package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.iiitb.ebay.dao.ProductDetailsDAO;
import edu.iiitb.ebay.model.entity.ProductModel;


public class PerticularSellerProductDetails extends ActionSupport{ 

	int productId;
	private ProductModel product = new ProductModel();
	
	public String execute() throws Exception {
		
		ProductDetailsDAO productDetailsDAO = new ProductDetailsDAO();
		setProduct(productDetailsDAO.getProductDetails(productId));
		return SUCCESS;
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}
}
