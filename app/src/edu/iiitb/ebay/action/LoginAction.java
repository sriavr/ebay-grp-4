package edu.iiitb.ebay.action;
import java.util.Map;

	import com.opensymphony.xwork2.ActionContext;
	import com.opensymphony.xwork2.ActionSupport;
	import edu.iiitb.ebay.dao.AdminDAO;
	import edu.iiitb.ebay.dao.UserDAO;
	import edu.iiitb.ebay.model.entity.AdminModel;
	import edu.iiitb.ebay.model.entity.UserModel;


public class LoginAction extends ActionSupport {

		private String userName="";
		private String password="";

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		private static final long serialVersionUID = 1L;

		/**
		 * This method handles the login of administrator and student
		 */

		public String execute() {
			Map<String, Object> sessionMap = ActionContext.getContext()
					.getSession();
			
			if(userName.equals(""))
				return "initial";
			
			AdminDAO adminDAO = new AdminDAO();
			UserDAO userDao = new UserDAO();

			AdminModel admin = adminDAO.login(userName, password);
			if (admin != null) {
				sessionMap.put("admin", admin);
				sessionMap.put("role", "admin");
				return "success";
			} else {
				UserModel user = userDao.login(userName, password);
				
				if (user == null) {
					addActionError("Wrong username/password combination");
					return "failure";
				} else {
					sessionMap.put("user", user);
					sessionMap.put("role", "user");
					return "success";
				}
			}
		}
		
		

	}



