/**
 * 
 */
package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.PaymentDAO;
import edu.iiitb.ebay.dao.UserDAO;
import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.model.entity.UserModel;

/**
 * @author Sridhar Jammalamadaka
 * 
 */
public class SellerDetailsAction extends ActionSupport {
	private int sellerId = 0;
	private SellerModel seller = new SellerModel();
	private UserModel user = new UserModel();

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public SellerModel getSeller() {
		return seller;
	}

	public void setSeller(SellerModel seller) {
		this.seller = seller;
	}

	@Override
	public String execute() throws Exception {
		PaymentDAO sellerDAO = new PaymentDAO();
		UserDAO userDAO = new UserDAO();
		SellerModel slr = sellerDAO.getSeller(sellerId);
		if (slr != null)
			setSeller(slr);
		setUser(userDAO.getUserDetails(seller.getUserId()));
		return SUCCESS;
	}
}
