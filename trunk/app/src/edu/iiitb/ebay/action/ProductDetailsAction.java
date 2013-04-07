package edu.iiitb.ebay.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.PaymentDAO;
import edu.iiitb.ebay.dao.ProductDetailsDAO;
import edu.iiitb.ebay.dao.UserDAO;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class ProductDetailsAction extends ActionSupport {
	Logger logger = Logger.getLogger(ProductDetailsAction.class);
	private int productId = 0;
	private ProductModel product = new ProductModel();
	private SellerModel seller = new SellerModel();
	private UserModel user = new UserModel();

	public SellerModel getSeller() {
		return seller;
	}

	public void setSeller(SellerModel seller) {
		this.seller = seller;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
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

	@Override
	public String execute() throws Exception {
		logger.info("Inside ProductDetailsAction: execute() method");
		ProductDetailsDAO productDetailsDAO = new ProductDetailsDAO();
		PaymentDAO sellerDAO = new PaymentDAO();
		UserDAO userDAO = new UserDAO();
		if (productId != 0) {
			setProduct(productDetailsDAO.getProductDetails(productId));
			setSeller(sellerDAO.getSeller(getProduct().getSellerId()));
			setUser(userDAO.getUserDetails(seller.getUserId()));
		} else
			logger.warn("productId is 0");
		return SUCCESS;
	}
}
