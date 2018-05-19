package view;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.ConnectDatabase;


public class NewEventController {

	NewEvent ne = new NewEvent();
	Connection con = null;
	ResultSet results = null;
	PreparedStatement ps = null;
	
	
	public void actionPerformed(ActionEvent e) {
		String source = (String)e.getSource();
		if(source.equals("btnSave")){
			saveEvent();
		}

	}

	private void saveEvent() {
		try {
			con = ConnectDatabase.connectDB();
			//AtomicInteger id = new AtomicInteger(0);
			java.sql.Date sqlDate;
			sqlDate = (java.sql.Date) ne.getDate().getDate();
			
			String query = "insert into event(Name, Category, Date, StartTime, EndTime, Location, Description, Reminder) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(query);
			//але чи буде кажного разу починати з нуля чи буде зберігати значення?
		//	ps.setInt(1, id.incrementAndGet());
			ps.setString(1, ne.getName().getText());
			ps.setString(2, ne.getCategory().getSelectedItem().toString());
		//	ps.setDate(4, (java.sql.Date) dateChooser.getDate());
		//	ps.setDate(4, sqlDate);
			ps.setDate(3, null);
			ps.setString(4, ne.getStartTime().getText());
			ps.setString(5, ne.getEndTime().getText());
			ps.setString(6, ne.getLocation().getText());
			ps.setString(7, ne.getDescription().getText());
			ps.setBoolean(8, ne.getReminder().isSelected());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "The event is saved!");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
