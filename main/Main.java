package main;

import java.sql.SQLException;

import model.Event;
import model.EventDAO;
import util.SerializeManager;
import controller.MainController;
import view.OrganizerView;
import view.NewEvent;

/**
 * Main class that is used to launch the application.
 */

public class Main {

	public static void main(String[] args) throws SQLException {
				/**
				 * View
				 */
				OrganizerView mainView = new OrganizerView();
				
				/**
				 * Model
				 */
				Event mainModel = new Event();
				
				/**
				 * Data Access Object
				 */
				EventDAO dao = new EventDAO();
				
				/**
				 * Controller
				 */
				MainController mainController = new MainController(mainView, mainModel, dao);
	}

}
