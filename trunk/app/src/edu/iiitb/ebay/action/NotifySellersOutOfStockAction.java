package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.NotifySellersOutOfStockDAO;
import edu.iiitb.ebay.model.entity.ProductModel;

public class NotifySellersOutOfStockAction extends ActionSupport{
	ArrayList<ProductModel> productList;
	
		public ArrayList<ProductModel> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ProductModel> productList) {
		this.productList = productList;
	}

		public String execute(){
			//System.out.println("I am in NotifySellersOutOfStockAction");
			NotifySellersOutOfStockDAO notifySellersOutOfStockDAO = new NotifySellersOutOfStockDAO();
			productList = notifySellersOutOfStockDAO.getProductsOutOfStock();
			ActionContext.getContext().getSession().put("notifySellersProductList", productList);
			//System.out.println("size = "+productList.size());
//			for (ProductModel proModel : productList) {
//				System.out.println(proModel.getDescription());
//			}
//			
			return Action.SUCCESS;
		}
}
