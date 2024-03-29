package edu.iiitb.ebay.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.MakeListingDAO;
import edu.iiitb.ebay.dao.ProductDetailsDAO;
import edu.iiitb.ebay.model.entity.CategoryModel;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.ProductSpecModel;
import edu.iiitb.ebay.model.entity.SellerModel;

public class CreateListingAction extends ActionSupport implements
		ServletRequestAware {

	String selectedCategoryId = "";
	String save = "";
	String filename = "images/default-pic.jpg";
	String upload = "";
	String discount = "";
	String productId="";
	


	

	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	String description = "";
	public HttpServletRequest request;

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getSelectedCategoryId() {
		return selectedCategoryId;
	}

	public void setSelectedCategoryId(String selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}

	public String getSelectedsubCategoryId() {
		return selectedsubCategoryId;
	}

	public void setSelectedsubCategoryId(String selectedsubCategoryId) {
		this.selectedsubCategoryId = selectedsubCategoryId;
	}

	public String getSelectedsubsubCategoryId() {
		return selectedsubsubCategoryId;
	}

	public void setSelectedsubsubCategoryId(String selectedsubsubCategoryId) {
		this.selectedsubsubCategoryId = selectedsubsubCategoryId;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	String selectedsubCategoryId = "";

	String selectedsubsubCategoryId = "";

	String selection = "";
	String title;
	String price;
	String quantity;
	private File userImage;

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	private String userImageContentType;
	private String userImageFileName;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	String propertyName = "";
	String propertyValue = "";
	String itemSpec = "";
    String deal="";
    
    
	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public ArrayList<ProductSpecModel> getItemspefics() {
		return itemspefics;
	}

	public void setItemspefics(ArrayList<ProductSpecModel> itemspefics) {
		this.itemspefics = itemspefics;
	}

	ArrayList<ProductSpecModel> itemspefics = new ArrayList<ProductSpecModel>();

	public String execute() {
		
		Map<String, Object> sessionMap = ActionContext.getContext()
		.getSession();
		
		if(sessionMap.get("user")==null)
          return "initial";
		
		if(!productId.equals(""))
		{
			ProductDetailsDAO prodDao = new ProductDetailsDAO();
			ProductModel pm=prodDao.getProductDetails(Integer.parseInt(productId));
		    setTitle(pm.getTitle());
		    setFilename(pm.getPhoto().substring(1));
		    setDescription(pm.getDescription());
		    setPrice(pm.getPrice()+"");
		    setQuantity(pm.getQuantity()+"");
		    pm.setProductId(Integer.parseInt(productId));
		    
		    CategoryModel cm=prodDao.getCategoryOfProduct(productId);
		    selection = selection+cm.getCategoryName();
		    while(!cm.getParentCategoryId().equals("0"))
		    {
		    	cm=prodDao.getCategory(cm.getParentCategoryId());
		    	selection=cm.getCategoryName()+">>"+selection;
		    }
		    
		    
		    
		}
		
		
		SellerModel sm= (SellerModel) sessionMap.get("seller");
		if (!itemSpec.equals("")) {
			System.out.println("here");
			ProductSpecModel productSpecModel = new ProductSpecModel();
			productSpecModel.setProperty(propertyName);
			productSpecModel.setValue(propertyValue);
			propertyName = "";
			propertyValue = "";
			itemspefics.add(productSpecModel);
			itemSpec = "";
		}
		
		
		
		
		
		

		if (userImage != null) {

			String name = userImage.getName();
			try {
				String filePath = request.getRealPath("/images");
				System.out.println("Server path:" + filePath + "name of file:"
						+ userImage.getAbsolutePath());
				
				String imageName = this.userImageFileName.substring(0,userImageFileName.indexOf("."))+System.currentTimeMillis()+".jpg";
				setUserImageFileName(imageName);
				File fileToCreate = new File(filePath, this.userImageFileName);
				System.out.println(fileToCreate.getAbsolutePath());

				FileUtils.copyFile(userImage, fileToCreate);
				filename = "images/" + fileToCreate.getName();
				System.out.println(filename);

			} catch (Exception ex) {
				ex.printStackTrace();
				return SUCCESS;
			}

		}

		if (!save.equals("")) {

			try {
				// Compute productId
				if(productId.equals(""))
				{	
				MakeListingDAO dao = new MakeListingDAO();
				int pId = dao.getProductId();
				System.out.println(pId);
				ProductModel pm = new ProductModel();
				pm.setProductId(pId);
				pm.setTitle(title);
				pm.setPrice(Integer.parseInt(price));
				
				pm.setQuantity(Integer.parseInt(quantity));
				pm.setSellerId(sm.getSellerId());
				pm.setPhoto("/" + filename);
				pm.setDescription(description);
				if (!discount.equals(""))
					pm.setDiscount(Integer.parseInt(discount));
				else
					pm.setDiscount(0);

				int catId;

				if (!selectedsubsubCategoryId.equals(""))
					catId = Integer.parseInt(selectedsubsubCategoryId);
				else if (!selectedsubCategoryId.equals(""))
					catId = Integer.parseInt(selectedsubCategoryId);
				else
					catId = Integer.parseInt(selectedCategoryId);

				dao.saveProduct(pm, itemspefics, catId + "");
				addActionError("Item successfully Listed.Press continue to review the listings made by you");
				}
				
				else
				{
					ProductModel pm = new ProductModel();
					pm.setProductId(Integer.parseInt(productId));
					pm.setTitle(title);
					pm.setPrice(Integer.parseInt(price));
					pm.setQuantity(Integer.parseInt(quantity));
					pm.setPhoto("/" + filename);
					pm.setDescription(description);
					if (!discount.equals(""))
						pm.setDiscount(Integer.parseInt(discount));
					else
						pm.setDiscount(0);
					MakeListingDAO dao = new MakeListingDAO();
					dao.updateProduct(pm);
					addActionError("Product successfully updated");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			save = "";
		}

		return SUCCESS;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
