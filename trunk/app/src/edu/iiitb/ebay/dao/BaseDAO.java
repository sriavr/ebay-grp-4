package edu.iiitb.ebay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.iiitb.ebay.util.ConstantValues;

public class BaseDAO {
	static Connection con;

	public static Connection getConnection() {

		try {
			if (con != null)
				return con;

			try {
				Class.forName("com.mysql.jdbc.Driver");

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();

			}

			String connectionUrl = ConstantValues.connectionString;
			con = DriverManager.getConnection(connectionUrl,
					ConstantValues.databaseUser,
					ConstantValues.databasePassword);
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

		return con;
	}

	public static ResultSet readFromDB(String query) {
		ResultSet result = null;
		Statement stmt = null;
		try {
			Connection connection = getConnection();

			stmt = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			result = stmt.executeQuery(query);

		} catch (SQLException se) {
			se.printStackTrace();
		}

		return result;
	}

	public static int update(String sql) {
		Statement statement = null;
		int rows = 0;
		try {
			Connection connection = getConnection();
			statement = connection.createStatement();
			rows = statement.executeUpdate(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rows;
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		// return;
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement preparedStmt) {
		if (preparedStmt != null) {
			try {
				preparedStmt.close();
				preparedStmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}