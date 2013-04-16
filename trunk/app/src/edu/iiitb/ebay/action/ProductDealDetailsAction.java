package edu.iiitb.ebay.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.PaymentDAO;
import edu.iiitb.ebay.dao.ProductDetailsDAO;
import edu.iiitb.ebay.dao.UserDAO;
import edu.iiitb.ebay.model.entity.DealModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class ProductDealDetailsAction extends ActionSupport {
	Logger logger = Logger.getLogger(ProductDealDetailsAction.class);
	private int productId = 0;
	private DealModel product = new DealModel();
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

	public DealModel getProduct() {
		return product;
	}

	public void setProduct(DealModel product) {
		this.product = product;
	}

	@Override
	public String execute() throws Exception {
		logger.info("Inside ProductDealDetailsAction: execute() method");
		ProductDetailsDAO productDetailsDAO = new ProductDetailsDAO();
		PaymentDAO sellerDAO = new PaymentDAO();
		UserDAO userDAO = new UserDAO();
		if (productId != 0) {
			setProduct(productDetailsDAO.getProductDealDetails(productId));
			setSeller(sellerDAO.getSeller(getProduct().getSellerId()));
			setUser(userDAO.getUserDetails(seller.getUserId()));
		} else
			logger.warn("productId is 0");
		return SUCCESS;
	}
}
