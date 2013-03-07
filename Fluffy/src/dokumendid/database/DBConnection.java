package dokumendid.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBConnection {

	/*
	 * Constructor
	 */
	public DBConnection() {
	}

	/**
	 * Connects to database using properties defined in
	 * WebContent/WEB-INF/classes/DBConnection.properties
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection db_connection = null;
		String pwd = "";
		String usr = "";
		String url = "";

		try {
			ResourceBundle bundle = ResourceBundle.getBundle("DBConnection");
			Class.forName(bundle.getString("Driver"));
			url = bundle.getString("url");
			usr = bundle.getString("usr");
			pwd = bundle.getString("pwd");
			db_connection = DriverManager.getConnection(url, usr, pwd);

		} catch (Exception ex) {
			System.out.println("dbconnection.getConnection():"
					+ ex.getMessage());
		}
		return db_connection;
	}

	/**
	 * Closes the connection
	 * 
	 * @param connection
	 */
	public static void close(final Connection connection) {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				System.out.println("dbconnection.close()" + ex.getMessage());
			}
		}

	}

	/**
	 * 
	 * @param statement
	 */
	public static void closeStatement(final Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException ex) {
				System.out.println("dbconnection.closeStatement()"
						+ ex.getMessage());
			}
		}
	}

	/**
	 * 
	 * @param resultSet
	 */
	public static void closeResultSet(final ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				System.out.println("dbconnection.closeResult()"
						+ ex.getMessage());
			}
		}
	}

}
