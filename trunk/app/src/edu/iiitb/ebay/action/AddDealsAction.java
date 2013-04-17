package edu.iiitb.ebay.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.DealsDAO;
import edu.iiitb.ebay.model.entity.DealModel;

public class AddDealsAction extends ActionSupport {
	
	int productId;
     String startDate="";
     String endDate="";
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	DealModel deal; 
	
	public DealModel getDeal() {
		return deal;
	}

	public void setDeal(DealModel deal) {
		this.deal = deal;
	}

	public String execute()
	{
		        Map<String, Object> sessionMap = ActionContext.getContext()
				.getSession();
				
				if(sessionMap.get("user")==null)
		          return "login";
				
				System.out.println("productId:"+productId);
				
				if(deal==null)
					return SUCCESS;
				
				else
				{
					System.out.println("productId:"+deal.getProductId());
					System.out.println("startDate:"+startDate+"endDate:"+endDate);
                    SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy");
                    try
                    {
                    
                    Date d = sd.parse(startDate);
					deal.setDealStartDate(new java.sql.Date(d.getTime()));
					d= sd.parse(endDate);
					deal.setDealEndDate(new java.sql.Date(d.getTime()));
                    }
                    catch(Exception ex)
                    {
                    	ex.printStackTrace();
                    }
					boolean value=new DealsDAO().saveDeals(deal);
					System.out.println("value:"+value);
					if(value)
					{	
					 addActionError("Saved successfully");
					 return "viewProduct";
					} 
					else
					{	
					  addActionError("Deal selling price cannot be greater than actual price");
					  return "success";
					} 
					
				}
				
				
				
	}

}
