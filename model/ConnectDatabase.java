package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Yana Holoborodko
 * Class for connecting with SQLite database
 *
 */

public class ConnectDatabase {

	private static final String SQLCONN = "jdbc:sqlite:C:\\Users\\holob\\workspace\\MyOrganizer1\\src\\events.db";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		try{
			 if (connection == null) {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(SQLCONN);
			 } else return connection;
		} catch(ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex);
			System.out.println("ConnectDatabase");
			System.out.println(ex.getMessage());
		}
		return null;
	}	
	
}
