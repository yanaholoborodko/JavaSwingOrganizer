package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * 
 * @author Yana Holoborodko
 * Class for connecting with SQLite database
 *
 */


public class ConnectDatabase {


	/**
	 * URL This is variable which contain a reference(URL) to the database
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/events";
	/**
	 * USERNAME This is variable which variable contain the username
	 */
	private static final String USERNAME = "root";
	/**
	 * PASSWORD This is variable which contain the password of user
	 */
	private static final String PASSWORD = "";

	private static Connection connection;

	private Statement statement = null;

	 /**
     * Variables contain queries to the database
     * selectTableSQL variable contain queries SELECT to the database
     * insertTableSQL variable contain queries INSERT to the database
     */
    private String selectTableSQL = "";
    private String insertTableSQL = "";
	
//	private static final String SQLCONN = "jdbc:sqlite:C:\\Users\\holob\\workspace\\MyOrganizer1\\src\\events.db";

	
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
