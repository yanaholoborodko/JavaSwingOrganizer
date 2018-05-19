package model;

import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectDatabase {

	Connection cn = null;
	
	public static Connection connectDB() {
		try{
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\holob\\workspace\\MyOrganizer1\\mydatabase.db");
			return con;
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return null;
		}
	}
	
	
}
