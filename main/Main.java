package main;

import model.Event;
import controller.EventController;
import view.MyOrganizer2;
import view.NewEvent;


public class Main {

	public static void main(String[] args) /*throws ...*/{
				//View
				MyOrganizer2 mainView = new MyOrganizer2();
				NewEvent eventView = new NewEvent();
				
				//Models
				Event mainModel = new Event();
				
				//Controller
				EventController mainController = new EventController(mainView, eventView, mainModel);
	}

}
