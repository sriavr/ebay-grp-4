package edu.iiitb.ebay.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.MakeListingDAO;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.ProductSpecModel;

public class CreateListingAction extends ActionSupport {
	
	String selectedCategoryId="";
	String save="";
	String filename="images/default-pic.jpg";
	String upload="";
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

	String selectedsubCategoryId="";
	
	String selectedsubsubCategoryId="";
	
    String selection="";
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

	String propertyName="";
    String propertyValue="";
    String itemSpec="";
    
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
    public String execute()
    {
    	System.out.println("property name:"+propertyName);
    	System.out.println("category id:"+selectedCategoryId);
    	if(!itemSpec.equals(""))
    	{
    		System.out.println("here");
    		ProductSpecModel productSpecModel=new ProductSpecModel();
    		productSpecModel.setProperty(propertyName);
    		productSpecModel.setValue(propertyValue);
    		propertyName="";
    		propertyValue="";
    		itemspefics.add(productSpecModel);
    		itemSpec="";
    	}
    	
    		
        	if(userImage!=null)
        	{
        		
        		String name=userImage.getName();
        		try
        		{
        			String filePath = "C:\\Users\\DEBARGHA\\workspace1\\Ebay\\WebContent\\images";
                    System.out.println("Server path:" + filePath + "name of file:"+userImage.getAbsolutePath());
                    File fileToCreate = new File(filePath, this.userImageFileName);
                    System.out.println(fileToCreate.getAbsolutePath());
                   
                   
                    FileUtils.copyFile(userImage, fileToCreate); 
                    filename = "images/"+fileToCreate.getName();
                    System.out.println(filename);
        	        
        		}
        		catch(Exception ex)
        		{
        			ex.printStackTrace();
        			return SUCCESS;
        		}
        		
        	}
        	
        	if(!save.equals(""))
        	{
        		
        		try
        		{
        			//Compute productId
        			MakeListingDAO dao = new MakeListingDAO();
        			int productId = dao.getProductId();
        			ProductModel pm = new ProductModel();
        			pm.setProductId(productId);
        			pm.setTitle(title);
        			pm.setPrice(Integer.parseInt(price));
        			pm.setDescription("");
        			pm.setQuantity(Integer.parseInt(quantity));
        			pm.setSellerId(1);
        			pm.setPhoto(filename);
        		
        			
        			int catId;
        			
        			/*if(!selectedsubsubCategoryId.equals(""))
        				catId = Integer.parseInt(selectedsubsubCategoryId);
        			else if(!selectedsubCategoryId.equals(""))
        				catId = Integer.parseInt(selectedsubCategoryId);
        			else
        				catId = Integer.parseInt(selectedCategoryId);*/
        			
        			
        			dao.saveProduct(pm, itemspefics, "1");
        		}
        		catch(Exception ex)
        		{
        			ex.printStackTrace();
        		}
        		save="";
        	}
        	
        	
    		
    		
    	
    
    		
    	return SUCCESS;
    	
    }
    
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;  
        }

}
