package edu.iiitb.ebay.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.CreateSellerAccountDAO;
import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.model.entity.UserModel;

public class CreateSellerAction extends ActionSupport {
	
	
	String location;
	String sla;
	public String getSla() {
		return sla;
	}
	public void setSla(String sla) {
		this.sla = sla;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	String register="";
	public String execute()
	{
		Map<String, Object> sessionMap = ActionContext.getContext()
		.getSession();
		
		if(sessionMap.get("user")==null)
          return "initial";	
		UserModel um = (UserModel) sessionMap.get("user");
		CreateSellerAccountDAO dao = new CreateSellerAccountDAO();
		if(!register.equals(""))
		{
			SellerModel sm = new SellerModel();
			sm.setUserId(um.getUserId());
			sm.setLocation(location);
			sm.setSla(Integer.parseInt(sla));
			dao.insertSeller(sm);
		}
		
		SellerModel sm=dao.getSellerInfo(um.getUserId());
		if(sm==null)
		{	
			return "register";
		}
		else
		{
		  sessionMap.put("seller", sm);
		  return SUCCESS;
		}
		
		
		
		
	}
		

}
