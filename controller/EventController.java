package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ConnectDatabase;
import model.Event;
import view.MyOrganizer2;

/**
 * 
 * @author Yana Holoborodko 30379 EventController class is responsible for
 *         controlling interactions between the View and the Model
 * 
 */

public class EventController {

	// View
	private MyOrganizer2 organizerView;

	// Model
	private Event eventModel;

	// Database
	private ConnectDatabase database;

	Event events = new Event();

	public EventController(MyOrganizer2 organizerView, Event eventModel) {
		this.organizerView = organizerView;
		this.eventModel = eventModel;
		this.database = new ConnectDatabase();

		organizerView.setVisible(true);

		// adding listeners

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
			// TODO Auto-generated method stub

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

}
