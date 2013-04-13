package edu.iiitb.ebay.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.BuyProductDAO;
import edu.iiitb.ebay.model.entity.ProductModel;

public class BuyProductAction extends ActionSupport {
	Integer productId;
	Integer qty;

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String execute() {
		Map<String, Object> session;
		session = ActionContext.getContext().getSession();

		String Role = (String) session.get("role");
		System.out.println("role:" + Role);
		if (Role == null) {
			return "login";
		}
		BuyProductDAO buyProductDAO = new BuyProductDAO();
		System.out.println("ProductId: " + this.getProductId());
		// Quantity was null so it was giving the null pointer exception
		// so i chnaged it to 1, anyway it is not using in DAO.@pratibind
		ProductModel product = buyProductDAO.getProduct(this.getProductId(), 1);
		ActionContext.getContext().getSession().put("buyProduct", product);
		return Action.SUCCESS;
	}
}
