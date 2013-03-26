package edu.iiitb.ebay.model.page;

import java.util.ArrayList;

import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.ProductModel;

/***
 * The purpose of this model is to store all that it takes to display the basic
 * Browse page. Elements like Product details and related categories on left
 * hand side.
 * 
 * @author sridhar
 * 
 */
public class BrowseModel {

	private ArrayList<CategoryModel> relatedCategories = new ArrayList<CategoryModel>();
	private ArrayList<ProductModel> products = new ArrayList<ProductModel>();

	public ArrayList<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}

	public ArrayList<CategoryModel> getRelatedCategories() {
		return relatedCategories;
	}

	public void setRelatedCategories(ArrayList<CategoryModel> relatedCategories) {
		this.relatedCategories = relatedCategories;
	}

}
