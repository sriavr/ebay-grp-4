package edu.iiitb.ebay.util;

/**
 * 
 * @author svkris
 * 
 *         This class has all the constant values which are used in code. All
 *         the static value initializations are done in this file and are used
 *         further in the code--> which implies that no variable should be
 *         initialized in any class other than this
 * 
 */
public class ConstantValues {
	public static String connectionString = "jdbc:mysql://localhost:3306/eBay";
	public static String databaseUser = "root";
	public static String databasePassword = "123456";
	public static String administrator = "administrator";
	public static String student = "student";
	public static int SUCCESS=0;
	public static int FAILURE=1;
	public static int INSUFFICIENT_MONEY=2;
	public static int EbayUserID=1;
	public static int productLimitForOutOfStock=3;

}
