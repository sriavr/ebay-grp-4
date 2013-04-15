/**
 * 
 */
package edu.iiitb.ebay.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.MyAccountInfoDAO;
import edu.iiitb.ebay.model.entity.UserModel;
import edu.iiitb.ebay.model.page.MyBankDetailsModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class MyAccountInfoAction extends ActionSupport {

	public static Logger logger = Logger.getLogger(MyAccountInfoAction.class);
	private MyBankDetailsModel bankDetailsModel;

	/**
	 * @return the bankDetailsModel
	 */
	public MyBankDetailsModel getBankDetailsModel() {
		return bankDetailsModel;
	}

	/**
	 * @param bankDetailsModel
	 *            the bankDetailsModel to set
	 */
	public void setBankDetailsModel(MyBankDetailsModel bankDetailsModel) {
		this.bankDetailsModel = bankDetailsModel;
	}

	// get bank info for perticular userId.
	public String getBankDetails() {
		Map<String, Object> session;
		session = ActionContext.getContext().getSession();
		String Role = (String) session.get("role");
		System.out.println("role:" + Role);
		if (Role == null) {
			return "login";
		}
		if (!Role.equals("user")) {
			return "login";
		}
		int userId = ((UserModel) session.get("user")).getUserId();

		String whereClause = " WHERE bank.userId=" + userId;
		logger.info("WhereClouse " + whereClause);
		try {
			MyBankDetailsModel bankDetails = MyAccountInfoDAO
					.getBankDetails(whereClause);
			this.setBankDetailsModel(bankDetails);
		} catch (Exception e) {
			// TODO: handle exception
			return "login";
		}

		return "success";
	}
}
