package main;

import java.sql.SQLException;

import model.Event;
import model.EventDAO;
import controller.MainController;
import view.OrganizerView;
import view.NewEvent;

/**
 * Main class that is used to
 * launch the application.
 */

public class Main {

	public static void main(String[] args) throws SQLException {
				//View
				OrganizerView mainView = new OrganizerView();
				NewEvent eventView = new NewEvent();
				
				//Models
				Event mainModel = new Event();
				EventDAO dao = new EventDAO();
				
				//Controller
				MainController mainController = new MainController(mainView, eventView, mainModel, dao);
	}

}
