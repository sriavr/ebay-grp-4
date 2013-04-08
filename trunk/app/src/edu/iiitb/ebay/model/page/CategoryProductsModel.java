/**
 * 
 */
package edu.iiitb.ebay.model.page;

import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.DealModel;
import edu.iiitb.ebay.model.entity.ProductModel;

/**
 * @author Pavan
 * 
 *
 */
public class CategoryProductsModel {
	private CategoryModel category = new CategoryModel();
	private ArrayList<DealModel> deals = new ArrayList<DealModel>();
	
	public ArrayList<DealModel> getDeals() {
		return deals;
	}
	public void setDeals(ArrayList<DealModel> deals) {
		this.deals = deals;
	}
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	
	
}
