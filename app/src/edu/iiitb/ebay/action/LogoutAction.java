package edu.iiitb.ebay.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.util.LogMessage;

public class LogoutAction extends ActionSupport {

	public String execute() throws Exception {
		Map<String, Object> sessionMap = ActionContext.getContext()
				.getSession();
		LogMessage.log("Inside LogoutAction. Logging out...");
		sessionMap.remove("user");
		sessionMap.remove("admin");
		sessionMap.remove("role");
		sessionMap.clear();
		return SUCCESS;
	}

}
