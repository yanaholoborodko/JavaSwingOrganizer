package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Yana Holoborodko
 * Class for connecting with database
 *
 */

public class ConnectDatabase {

	private static final String SQLCONN = "jdbc:sqlite:events.db";
	
	//connectDB -> getConnection
	public static Connection getConnection() throws SQLException {
		try{
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(SQLCONN);
		} catch(ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex);
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public void saveToDB(String query){
		
	}
	
	
}
