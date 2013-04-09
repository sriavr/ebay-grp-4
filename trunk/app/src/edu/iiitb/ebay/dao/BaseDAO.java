package edu.iiitb.ebay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.Query;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.util.ConstantValues;

public class BaseDAO {
	private static Logger logger = Logger.getLogger(BaseDAO.class);
	static Connection con;

	public static Connection getConnection() {
		logger.info("Inside getConnection() method");
		try {
			if (con != null) {
				logger.info("Found an active connection");
				return con;
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			logger.info("Creating a connection for connectionString:"
					+ ConstantValues.connectionString);
			String connectionUrl = ConstantValues.connectionString;
			con = DriverManager.getConnection(connectionUrl,
					ConstantValues.databaseUser,
					ConstantValues.databasePassword);
		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occurred while procuring a DB Connection:", ex);
		}

		return con;
	}

	public static ResultSet readFromDB(String query) {
		logger.info("Inside readFromDB(query) method, executing query: "
				+ query);
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
			logger.error("Error occurred while getting resultset: ", se);
		}

		return result;
	}

	public static int update(String sql) {
		logger.info("Running update for statement: " + sql);
		Statement statement = null;
		int rows = 0;
		try {
			Connection connection = getConnection();
			statement = connection.createStatement();
			rows = statement.executeUpdate(sql);
			logger.info("Number of rows affected:" + rows);
		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occurred while running update() method: ", ex);
		}
		return rows;
	}

	public static int update(PreparedStatement ps) {
		logger.info("Running update for preparedstatement: " + ps.toString());
		int rows = 0;
		try {
			rows = ps.executeUpdate();
			logger.info("Number of rows affected:" + rows);
			close(ps);
		} catch (SQLException ex) {
			ex.printStackTrace();
			logger.error("Error occurred while running update() method: ", ex);
		}
		return rows;
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
				statement = null;
				logger.info("Closing statement");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		// return;
		if (rs != null) {
			try {
				logger.info("Closing resultset");
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
				logger.info("Closing preparedStatement");
				preparedStmt.close();
				preparedStmt = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}