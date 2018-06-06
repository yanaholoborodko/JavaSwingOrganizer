package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Class for connecting with MySQL database
 * @author Yana Holoborodko
 */
public class ConnectDatabase {


	/**
	 * URL variable that contains a reference(URL) to the database
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/events";
	/**
	 * USERNAME variable that contains the username
	 */
	private static final String USERNAME = "root";
	/**
	 * PASSWORD variable which contains the password of user
	 */
	private static final String PASSWORD = "";

	private static Connection connection;

	private Statement statement = null;

	/**
	 * 	The method for establishing the connection with the database
	 * @return connection to the database
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		try{
			 if (connection == null) {
				 connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
				 System.out.println(connection);
			     System.out.println("Connected");
				 return connection;
		       
			 } else return connection;
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			System.out.println("ConnectDatabase");
			System.out.println(ex.getMessage());
		}
		return null;
	}	
	

}
