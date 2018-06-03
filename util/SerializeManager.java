/**
 * util - Package for classes that provide additional 
 * functionality for the project 
 */

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
 * Manages all the saving and loading data methods. Contains list of Events.
 * @author Yana Holoborodko
 *
 */
public class SerializeManager {

    /**
     * Static instace of the class.
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
//        EventList preloadedEvents = LoadCalendarEvents();
//        events = preloadedEvents == null ? new EventList() : preloadedEvents;
    }

    /**
     * Returns all the events available.
     * @return Events list to return. 
     */
    public EventList GetAllEvents() {
        return events;
    }


/*    public EventList GetEventsForDate(int day, int month, int year) {
        EventList foundEvents = new EventList();
        for (Event event : events.list) {
            if (event.getDate().get(Calendar.DAY_OF_MONTH) == day && event.date.get(Calendar.MONTH) == month && event.date.get(Calendar.YEAR) == year) {
                foundEvents.add(event);
                //continue;
            }
        }

        if (foundEvents.size() > 0) {
            //System.out.println("Events found for " + day + "." + month + "." + year + ": " + foundEvents.size());
            return foundEvents;
        }
        else return null;
    }*/

    /**
     * Adds and event to database.
     * @param event Event to add.
     */
    public void AddEvent(Event event) {
        events.list.add(event);
  //      SaveCalendarEvents();
    }

    /**
     * Removes Calendar Event from database.
     * @param event	Event to remove.
     */
    public void RemoveEvent(Event event) {
        events.list.remove(event);
  //      SaveCalendarEvents();
    }

    /**
     * Finds Calendar Event in database using its id. Returns null if not found
     * @param eventID ID of a particular event.
     * @return	Event to return. Null if not found.
     */
    public Event GetEventByID(int eventID) {
        for (Event event : events.list) {
            if (eventID == event.getId()) {
                return event;
            }
        }
        return null;
    }

    /**
     * Removes Calendar Event from database using its id.
     * @param eventID ID of a particular event.
     */
    public void RemoveEventByID(int eventID) {
        for (Event event : events.list) {
            if (eventID == event.getId()) {
                events.removed(event);
 //               SaveCalendarEvents();
            }
        }
    }

    /**
     * Saves Calendar Events list to database.
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
     * Loads Calendar Events from database.
     * @return	Returns loaded list.
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
