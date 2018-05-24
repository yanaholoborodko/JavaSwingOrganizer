package main;

import java.sql.SQLException;

import model.Event;
import model.EventDAO;
import controller.MainController;
import view.MyOrganizer2;
import view.NewEvent;

/**
 * Main class that is used to
 * launch the application.
 */

public class Main {

	public static void main(String[] args) throws SQLException {
				//View
				MyOrganizer2 mainView = new MyOrganizer2();
				NewEvent eventView = new NewEvent();
				
				//Models
				Event mainModel = new Event();
				EventDAO dao = new EventDAO();
				
				//Controller
				MainController mainController = new MainController(mainView, eventView, mainModel, dao);
	}

}
