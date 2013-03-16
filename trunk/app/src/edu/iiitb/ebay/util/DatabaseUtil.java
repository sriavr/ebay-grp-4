package edu.iiitb.ebay.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author svkris
 *
 *This class provides the database utilities
 */
public class DatabaseUtil {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public static String conString = ConstantValues.connectionString;
	public static int flag;

	/**
	 * This method is useful in connecting to the database
	 */
	public static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(conString, ConstantValues.databaseUser, ConstantValues.databasePassword);
			LogMessage.log("Message from DatabaseUtil.connect(): connected to database");
		} catch (Exception e) {
			LogMessage.log("Exception Caught in DatabaseUtil.connect()");
			e.printStackTrace();

		}
	}

	/**
	 * This method is useful in closing the connection
	 * 
	 */
	public static void connectionClose() {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {

			LogMessage.log("Exception Caught in DatabaseUtil.connectionClose()");
			e.printStackTrace();
		}

	}

}
