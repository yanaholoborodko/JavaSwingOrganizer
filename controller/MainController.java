package controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.ConnectDatabase;
import model.Event;
import model.EventDAO;
import view.MyOrganizer2;
import view.NewEvent;

/**
 * 
 * @author Yana Holoborodko 30379 EventController class is responsible for
 *         controlling interactions between the View and the Model
 * 
 */

public class MainController {

	// Views
	private MyOrganizer2 organizerView;
	private NewEvent eventView;

	// Model
	private Event eventModel;
	private EventDAO dao;

	// Database
	private ConnectDatabase database;

	ArrayList<Event> eventList;

	// Event event1 = new Event();

	public MainController(MyOrganizer2 organizerView, NewEvent eventView,
			Event eventModel, EventDAO dao) {

		this.organizerView = organizerView;
		this.eventModel = eventModel;
		this.eventView = eventView;
		this.dao = dao;
		this.database = new ConnectDatabase();

		eventList = dao.eventList();

		organizerView.setVisible(true);

		// adding listeners
		/**
		 * 
		 * telling the the view that whenever the ___ button is clicked to
		 * execute the ActionPerformed method that is going to be in the inner
		 * class
		 */
		/*
		 * this.organizerView.openButtonListener(new OpenButtonListener());
		 * 
		 * this.organizerView.saveButtonListener(new SaveButtonListener());
		 * 
		 * this.organizerView.closeButtonListener(new CloseButtonListener());
		 */

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

		this.organizerView
				.setCalendarPropertyListener(new CalendarPropertyChangeListener());

		this.eventView.setClearEventButtonListener(new ClearEventButtonListener());

		this.eventView.setSaveEventButtonListener(new SaveEventButtonListener());
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
			JOptionPane
					.showMessageDialog(
							null,
							"The program for keeping track of events, adding and removing them from the list."
									+ "\nAuthor: Yana Holoborodko 30379");

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
			try	{
			    JAXBContext jaxbContext = JAXBContext.newInstance(Event.class);
			    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 
			    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			     
			    //where do I take this list from?
			  //  jaxbMarshaller.marshal(employees, new File("c:/temp/employees.xml"));
			} catch (JAXBException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Problem with writing into XML file");
			}

		}
	}

	/**
	 * Property change listener for JCalendar
	 */
	class CalendarPropertyChangeListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			String date = organizerView.getCalendarDate().toString();
			ArrayList<Event> eventListByDate = dao.getEventsByDate(date);
			// metoda updateJtable, zeby wrzucic ta array liste
			updateJTable(eventListByDate);

		}
	}

	/**
	 * Action listener for Clear (Event Window) button
	 */
	class ClearEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			eventView.setName("");
			eventView.setCategory("");
			eventView.setDate(null);
			eventView.setStartTime("00:00");
			eventView.setEndTime("00:00");
			eventView.setLocation("");
			eventView.setDescription("");
			eventView.setReminder(false);

		}

	}

	/**
	 * Action listener for Save (Event Window) button
	 */
	class SaveEventButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Event event = new Event(eventView.getName(),
					eventView.getDescription(), eventView.getCategory(),
					eventView.getDate(), eventView.getStartTime(),
					eventView.getEndTime(), eventView.getLocation(),
					eventView.getReminder(), eventView.getReminderDate(),
					eventView.getReminderTime());
			System.out.println(eventView.getName()+
					eventView.getDescription() + eventView.getCategory()+
					eventView.getDate()+ eventView.getStartTime()+
					eventView.getEndTime()+eventView.getLocation()+
					eventView.getReminder()+ eventView.getReminderDate()+
					eventView.getReminderTime());
			dao.addEvent(event);
			JOptionPane.showMessageDialog(null, "The event is saved!");
			
		}

	}

	public void updateJTable(ArrayList<Event> eventList) {
		for (int i = 0; i < eventList.size(); i++) {

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

			Object[] data = { name, description, category, date, startTime, endTime,
					location, reminder, reminderDate, reminderTime };

			organizerView.addRow(data);

		}
	}

}
