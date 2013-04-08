/**
 * 
 */
package edu.iiitb.ebay.action;

import java.util.ArrayList;

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
	private ArrayList<Integer> watchListId;

	/**
	 * @return the watchListId
	 */
	public ArrayList<Integer> getWatchListId() {
		return watchListId;
	}

	/**
	 * @param watchListId
	 *            the watchListId to set
	 */
	public void setWatchListId(ArrayList<Integer> watchListId) {
		this.watchListId = watchListId;
	}

	// method to be executed
	public String removeWatchLists() {
		System.out.println("Inside removeWatchLists");
		int result;
		if (this.watchListId == null) {
			System.out.println("CheckBox is empty");
		} else {
			if (this.watchListId.size() != 0) {
				for (int i = 0; i < this.watchListId.size(); i++) {
					System.out.println("checkbox values "
							+ this.watchListId.get(i));
					result = ViewWatchListDAO
							.removeFromWatchListDAO(this.watchListId.get(i));
					if (result == 0) {
						addActionError("Error occured in remooving the item");
					}
				}
			}
		}
		return "success";
	}
}
