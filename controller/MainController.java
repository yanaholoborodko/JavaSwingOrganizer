package controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;

import model.ConnectDatabase;
import model.Event;
import model.EventDAO;
import model.EventList;
import util.SerializeManager;
import view.NewEvent;
import view.OrganizerView;

/**
 * EventController class is responsible for controlling interactions between the View and the Model
 *  @author Yana Holoborodko 30379
 */
public class MainController {

	public static MainController instance;

	// Views
	private OrganizerView organizerView;
	private NewEvent eventView;

	// Model
	private Event eventModel;
	private EventDAO dao;

	// Database
	private ConnectDatabase database;

	private SerializeManager xml;

	EventList eventList;
	EventList eventListFromXML;

	private int idDelete;

	/**
	 * 
	 * @param organizerView
	 *            main window of the application
	 * @param eventModel
	 *            model of the event
	 * @param dao
	 *            data access object
	 */
	public MainController(OrganizerView organizerView, Event eventModel, EventDAO dao) {

		instance = this;
		this.organizerView = organizerView;
		this.eventModel = eventModel;
		// this.eventView = eventView;
		this.dao = dao;
		this.database = new ConnectDatabase();

		eventList = dao.GetEvents();
		System.out.println(eventList.getList());

		updateJTable(eventList);

		/**
		 * 
		 * telling the the view that whenever the ___ button is clicked to execute the
		 * ActionPerformed method that is going to be in the inner class
		 */

		this.organizerView.setSettingsButtonListener(new SettingsMenuItemButtonListener());

		this.organizerView.setAboutButtonListener(new AboutButtonListener());

		this.organizerView.setAddEventButtonListener(new AddEventButtonListener());

		this.organizerView.setEditEventButtonListener(new EditEventButtonListener());

		this.organizerView.setDeleteEventButtonListener(new DeleteEventButtonListener());

		this.organizerView.setReadXMLButtonListener(new ReadXMLButtonListener());

		this.organizerView.setWriteXMLButtonListener(new WriteXMLButtonListener());

		this.organizerView.setCalendarPropertyListener(new CalendarPropertyChangeListener());

	}

	/**
	 * Creates event from input data and saves it to the database
	 * 
	 * @param nameS
	 *            event`s name
	 * @param categoryS
	 *            event`s category
	 * @param dateS
	 *            event`s date
	 * @param startTimeS
	 *            event`s start time
	 * @param endTimeS
	 *            event`s end time
	 * @param locationS
	 *            event`s location
	 * @param descriptionS
	 *            event`s description
	 * @param reminderS
	 *            event`s reminder (if any)
	 * @param reminderDateS
	 *            reminder date
	 * @param reminderTimeS
	 *            reminder time
	 */
	public void saveNewEvent(String nameS, String categoryS, String dateS, String startTimeS, String endTimeS,
			String locationS, String descriptionS, boolean reminderS, String reminderDateS, String reminderTimeS) {

		Event event = new Event(nameS, categoryS, dateS, startTimeS, endTimeS, locationS, descriptionS, reminderS,
				reminderDateS, reminderTimeS);
		System.out.println(nameS + categoryS + dateS + startTimeS + endTimeS + locationS + descriptionS + reminderS
				+ reminderDateS + reminderTimeS);
		dao.addEvent(event);
		// need to get id of this record from the database?
		// int id =
		Object[] data = { /* id, */ nameS, categoryS, dateS, startTimeS, endTimeS, locationS, descriptionS, reminderS,
				reminderDateS, reminderTimeS };

		organizerView.addRow(data);

		JOptionPane.showMessageDialog(null, "The event is saved!");
	}

	public void doRemind(String date, String time) {

		Toolkit.getDefaultToolkit().beep();
	}

	/**
	 * Action listeners for all the buttons
	 */

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

		JOptionPane.showMessageDialog(null, "The program for keeping track of events, adding and removing them from the list."
							+ "\nAuthor: Yana Holoborodko 30379", "About the program", 1);

		}

	}

	/**
	 * Action listener for Add Event button
	 */
	class AddEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			NewEvent newEvent = new NewEvent();
			newEvent.newScreen();
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

			dao.deleteEvent(idDelete);
			JOptionPane.showMessageDialog(null, "The event is deleted!");
			eventList = dao.GetEvents();
			updateJTable(eventList);

		}

	}

	/**
	 * Action listener for Read XML button
	 */
	class ReadXMLButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			eventListFromXML = xml.instance.loadCalendarEvents();
			updateJTable(eventListFromXML);
			for (int i = 0; i < eventListFromXML.size(); i++) {
				dao.addEvent(eventListFromXML.get(i));
			}
		}

	}

	/**
	 * Action listener for Write XML button
	 */
	class WriteXMLButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			xml.instance.saveEventsXML();
			System.out.println("Events saved to XML");
			JOptionPane.showMessageDialog(null, "Events successfully saved to XML");

		}
	}

	/**
	 * Property change listener for JCalendar
	 */
	class CalendarPropertyChangeListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			String date = organizerView.getCalendarDate().toString();
	//		EventList eventListByDate = dao.getEventsByDate(date);
			// metoda updateJtable, zeby wrzucic ta array liste
		//	updateJTable(eventListByDate);

		}
	}

	/**
	 * Method that updates the contents of the table with the new list of events
	 * (by appending those events to the existing ones)
	 * 
	 * @param eventList
	 *            list of events to be added to the table
	 */
	public void updateJTable(EventList eventList) {
		organizerView.clearTable();
		for (int i = 0; i < eventList.size(); i++) {

			int id = eventList.get(i).getId();
			String name = eventList.get(i).getName();
			String description = eventList.get(i).getDescription();
			String category = eventList.get(i).getCategory();
			String date = eventList.get(i).getDate();
			String startTime = eventList.get(i).getStartTime();
			String endTime = eventList.get(i).getEndTime();
			String location = eventList.get(i).getLocation();
			boolean reminder = eventList.get(i).isReminder();
			String reminderDate = eventList.get(i).getReminderDate();
			String reminderTime = eventList.get(i).getReminderTime();

			Object[] data = { id, name, category, date, startTime, endTime, location, description, reminder,
					reminderDate, reminderTime };

			organizerView.addRow(data);

		}
	}

	/**
	 * Fully updating the JTable
	 */
	public void updateJTable() {

		for (int i = 0; i < eventList.size(); i++) {

			int id = eventList.get(i).getId();
			String name = eventList.get(i).getName();
			String description = eventList.get(i).getDescription();
			String category = eventList.get(i).getCategory();
			String date = eventList.get(i).getDate();
			String startTime = eventList.get(i).getStartTime();
			String endTime = eventList.get(i).getEndTime();
			String location = eventList.get(i).getLocation();
			boolean reminder = eventList.get(i).isReminder();
			String reminderDate = eventList.get(i).getReminderDate();
			String reminderTime = eventList.get(i).getReminderTime();

			Object[] data = { id, name, category, date, startTime, endTime, location, description, reminder,
					reminderDate, reminderTime };

			organizerView.addRow(data);

		}
	}

	/**
	 * Setting the id of the event to be deleted
	 * @param id id of the event to be deleted
	 */
	public void setIdDelete(int id) {
		this.idDelete = id;
	}

}
