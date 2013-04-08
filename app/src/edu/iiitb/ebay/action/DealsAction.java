/**
 * 
 */
package edu.iiitb.ebay.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.DealsDAO;
import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.DealModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.page.CategoryProductsModel;

/**
 * @author Pavan
 * 
 */
public class DealsAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(DealsAction.class);
	private ArrayList<CategoryProductsModel> productGroups = new ArrayList<CategoryProductsModel>();

	public ArrayList<CategoryProductsModel> getProductGroups() {
		return productGroups;
	}

	public void setProductGroups(ArrayList<CategoryProductsModel> productGroups) {
		this.productGroups = productGroups;
	}

	// public void getDealsList(){
	// //int categoryId = 0;
	// int sellingPrice;
	// DealsDAO dao = new DealsDAO();
	// DealModel dm = null;
	// CategoryModel cm = null;
	// ArrayList<Integer> categoryList = dao.parentCategoryIdList();
	// for(int cat:categoryList ){
	// ArrayList<Integer> catList= new ArrayList<Integer>();
	// recursiveFun(catList,cat);
	// ArrayList<Integer> productList = null;
	// for(int subCateg : catList){
	// productList = dao.getProductIdList(subCateg);
	// ArrayList<ProductModel> prodList = new ArrayList<ProductModel>();
	// for(int proId : productList){
	// dm = dao.getDealModel(proId);
	// cm = dao.getCategoryModel(subCateg);
	// if(dm == null){
	// continue;
	// }
	// else {
	// productList.add
	// }
	// }
	// //productList.add(XYZDAO.getP roductsForCategory(categ.categoryId);
	// }
	// }
	//
	// }

	// public void getDealsList() {
	// logger.info("Inside getDealsList");
	// int sellingPrice;
	// DealsDAO dao = new DealsDAO();
	// setProductGroups(dao.getProductGroups());
	// }

	public void recursiveFun(ArrayList<Integer> catList, int cat) {
		DealsDAO dao = new DealsDAO();
		ArrayList<Integer> tempList;
		tempList = dao.getCategoryIdList(cat);
		if (tempList == null)
			return;
		else {
			for (int category : tempList) {
				catList.add(category);
				recursiveFun(catList, category);
			}
		}
	}

	@Override
	public String execute() throws Exception {
		DealsDAO dealsDAO = new DealsDAO();
		logger.info("Inside execute method");
		setProductGroups(dealsDAO.getProductGroups());
		return super.execute();
	}
}
