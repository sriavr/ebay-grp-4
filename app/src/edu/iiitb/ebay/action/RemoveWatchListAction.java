/**
 * 
 */
package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.ViewWatchListDAO;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class RemoveWatchListAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int selectedCheckBox;

	/**
	 * @return the selectedCheckBox
	 */
	public int getSelectedCheckBox() {
		return selectedCheckBox;
	}

	/**
	 * @param selectedCheckBox
	 *            the selectedCheckBox to set
	 */
	public void setSelectedCheckBox(int selectedCheckBox) {
		this.selectedCheckBox = selectedCheckBox;
	}

	public String removeFromList() {
		System.out.println("Inside removeWatchLists "
				+ this.getSelectedCheckBox());

		int result;
		if (this.getSelectedCheckBox() != 0) {
			result = ViewWatchListDAO.removeFromWatchListDAO(this
					.getSelectedCheckBox());
			if (result != 0) {
				addActionError("Item has been remove successfully");
				return "success";
			} else {
				addActionError("Error occured in database operation");
				return "fail";
			}
		} else {
			return "fail";
		}

	}
}
