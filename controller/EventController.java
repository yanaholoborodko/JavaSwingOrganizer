package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.ConnectDatabase;
import model.Event;
import view.MyOrganizer2;
import view.NewEvent;

/**
 * 
 * @author Yana Holoborodko 30379 
 * EventController class is responsible for
 * controlling interactions between the View and the Model
 * 
 */

/* where the hell does this go??
 	NewEvent ne = new NewEvent();
	Connection con = null;
	ResultSet results = null;
	PreparedStatement ps = null;
 */


public class EventController {

	// Views
	private MyOrganizer2 organizerView;
	private NewEvent eventView;

	// Model
	private Event eventModel;

	// Database
	private ConnectDatabase database;

	Event events = new Event();

	public EventController(MyOrganizer2 organizerView, NewEvent eventView, Event eventModel) {
		this.organizerView = organizerView;
		this.eventModel = eventModel;
		this.eventView = eventView;
		this.database = new ConnectDatabase();

		organizerView.setVisible(true);

		// adding listeners
		/*telling the the view that whenever the ___ button is clicked
		to execute the ActionPerformed method that is going to be in
		the inner class*/

		this.organizerView.openButtonListener(new OpenButtonListener());

		this.organizerView.saveButtonListener(new SaveButtonListener());

		this.organizerView.closeButtonListener(new CloseButtonListener());

		this.organizerView
				.settingsButtonListener(new SettingsMenuItemButtonListener());

		this.organizerView.aboutButtonListener(new AboutButtonListener());

		this.organizerView.addEventButtonListener(new AddEventButtonListener());

		this.organizerView
				.editEventButtonListener(new EditEventButtonListener());

		this.organizerView
				.deleteEventButtonListener(new DeleteEventButtonListener());

		this.organizerView.readXMLButtonListener(new ReadXMLButtonListener());

		this.organizerView.writeXMLButtonListener(new WriteXMLButtonListener());
		
		this.eventView.clearEventButtonListener(new ClearEventButtonListener());

		this.eventView.saveEventButtonListener(new SaveEventButtonListener());
	}

	/**
	 * Action listeners for all the buttons
	 */

	/**
	 * Action listener for open button
	 */
	class OpenButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			e.getActionCommand();

		}

	}

	/**
	 * Action listener for save button
	 */
	class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for close button
	 */
	class CloseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for Settings button
	 */
	class SettingsMenuItemButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for About button
	 */
	class AboutButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for Add Event button
	 */
	class AddEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for Edit Event button
	 */
	class EditEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for Delete Event button
	 */
	class DeleteEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for Read XML button
	 */
	class ReadXMLButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Action listener for Write XML button
	 */
	class WriteXMLButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	}

	/**
	 * Action listener for Clear (Event Window) button
	 */
	class ClearEventButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * Action listener for Save (Event Window) button
	 */
	class SaveEventButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
/*			try {
				con = ConnectDatabase.connectDB();
				//??java.sql.Date sqlDate;
				//??sqlDate = (java.sql.Date) ne.getDate();
				
				String query = "insert into event(Name, Category, Date, StartTime, EndTime, Location, Description, Reminder) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(query);
				ps.setString(1, ne.getName());
				ps.setString(2, ne.getCategory());
			//	ps.setDate(4, (java.sql.Date) dateChooser.getDate());
			//	ps.setDate(4, sqlDate);
				ps.setDate(3, null);
				ps.setString(4, ne.getStartTime());
				ps.setString(5, ne.getEndTime());
				ps.setString(6, ne.getLocation());
				ps.setString(7, ne.getDescription());
				ps.setBoolean(8, ne.getReminder());
				ps.execute();
				saveToDB(query);
				JOptionPane.showMessageDialog(null, "The event is saved!");
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			}*/
		}
		
	}
}
