package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.thoughtworks.xstream.XStream;

import model.Event;
import model.EventDAO;
import model.EventList;

/**
 * Manages writing and reading from XML.
 * @author Yana Holoborodko 30379
 *
 */
public class SerializeManager {

    /**
     * Static instance of the class.
     */
    public static SerializeManager instance;

    private final String EventsXML = "PlannedEvents.xml";
    
    private final String readEventsXML = "ReadEvents.xml";
    
    private EventDAO dao;

    EventList events;

    /**
     * A constructor for the class. Creates static singleton, loads data from disk.
     */
    public SerializeManager() {
    	try {
			dao = new EventDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        instance = this;
        events = dao.GetEvents();
    }

    /**
     * Returns all the events available.
     * @return Events list to return. 
     */
    public EventList GetAllEvents() {
        return events;
    }


    /**
     * Adds and event to database.
     * @param event Event to add.
     */
    public void AddEvent(Event event) {
        events.list.add(event);
    }

    /**
     * Removes Calendar Event from database.
     * @param event	Event to remove.
     */
    public void RemoveEvent(Event event) {
        events.list.remove(event);
     }

/*
    public Event GetEventByID(int eventID) {
        for (Event event : events.list) {
            if (eventID == event.getId()) {
                return event;
            }
        }
        return null;
    }*/


    /**
     * Saves Calendar Events list to XML file.
     */
    public void saveEventsXML() {

    		
            XStream xStream = new XStream();
            xStream.alias("event", Event.class);
            xStream.alias("list", EventList.class);

            String xmlString = xStream.toXML(events);
            PrintWriter printWriter = null;

            try {
                printWriter = new PrintWriter(EventsXML, "UTF-8");
                printWriter.write(xmlString);

            } catch (Exception ex) {
                System.err.println(ex);
            } finally {
                if (printWriter != null)
                    printWriter.close();
            }
  
    }

    /**
     * Reads Events from XML file.
     * @return	Returns list of events read from XML file.
     */
    public EventList loadCalendarEvents() {

        events = new EventList();
            System.out.println("XML");
            XStream xStream = new XStream();
            xStream.alias("event", Event.class);
            xStream.alias("list", EventList.class);

            String xmlString;
            String line;

            try {
                FileReader fileReader = new FileReader(readEventsXML);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                StringBuilder stringBuilder = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                xmlString = stringBuilder.toString();
                if (!xmlString.equals("")) {
                    events = (EventList) xStream.fromXML(xmlString);
                } else {
                    System.out.println("XML is empty");
                    return null;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return events;
    }


}
