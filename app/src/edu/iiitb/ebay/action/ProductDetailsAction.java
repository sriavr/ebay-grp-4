package edu.iiitb.ebay.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.ProductDetailsDAO;
import edu.iiitb.ebay.model.entity.ProductModel;

public class ProductDetailsAction extends ActionSupport {
	Logger logger = Logger.getLogger(ProductDetailsAction.class);
	private int productId = 0;
	private ProductModel product = new ProductModel();

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

	@Override
	public String execute() throws Exception {
		logger.info("Inside ProductDetailsAction: execute() method");
		ProductDetailsDAO productDetailsDAO = new ProductDetailsDAO();
		if (productId != 0)
			setProduct(productDetailsDAO.getProductDetails(productId));
		else
			logger.warn("productId is 0");
		return SUCCESS;
	}
}
