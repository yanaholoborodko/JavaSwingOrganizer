package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data Access Object for the event
 * @author Yana Holoborodko 30379
 *
 */
public class EventDAO {

	private static Connection connection;
	public EventList eventList;
	Statement statement1;

	/**
	 * Constructor that establishes the connection with the database
	 * @throws SQLException if there is no connection
	 */
	public EventDAO() throws SQLException {
		connection = ConnectDatabase.getConnection();
	}

	/**
	 * Creating event and inserting it into database
	 * @param event - event to be inserted
	 */
	public void addEvent(Event event) {

		try {
			System.out.println("Adding event");
			String query = "insert into eventsTable(name, category, date, startTime, endTime, location, description, reminder, reminderDate, reminderTime) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, event.getName());
			ps.setString(2, event.getCategory());
			ps.setString(3, event.getDate());
			ps.setString(4, event.getStartTime());
			ps.setString(5, event.getEndTime());
			ps.setString(6, event.getLocation());
			ps.setString(7, event.getDescription());
			ps.setBoolean(8, event.isReminder());
			ps.setString(9, event.getReminderDate());
			ps.setString(10, event.getReminderTime());
			System.out.println("Adding event2");
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the list of events by the date
	 * @param date - date for filtering events
	 * @return ArrayList of Events for a certain date (chosen on JCalendar)
	 *//*
	public EventList getEventsByDate(String date) {
		EventList eventListByDate = new EventList();
		Event event;
		try {
			
			PreparedStatement ps = connection.prepareStatement("select * from event where date = ?");
			ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
        	while (rs.next()) {
        		
        		event = new Event();
				event.setName(rs.getString("name"));
				event.setCategory(rs.getString("category"));
				event.setDate(rs.getString("date"));
				event.setStartTime(rs.getString("startTime"));
				event.setEndTime(rs.getString("endTime"));
				event.setLocation(rs.getString("location"));
				event.setDescription(rs.getString("description"));
				event.setReminder(rs.getBoolean("reminder"));
				event.setReminderDate(rs.getString("reminderDate"));
				event.setReminderTime(rs.getString("reminderTime"));
				
				eventListByDate.add(event);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problem with getting list of events by date from db");
		}
		return eventListByDate;
	}
		*/

	/**
	 * Getting all the events from database
	 * @return EventList of all Events in database
	 */
	public EventList GetEvents() {
        String selectTableSQL = "SELECT * from eventsTable";
        EventList calendarEvents = new EventList();
        Event event;

        try {
            statement1 = connection.createStatement();
            ResultSet rs = statement1.executeQuery(selectTableSQL);
            while (rs.next()) {
                event = new Event();
                event.setId(Integer.valueOf(rs.getString("id")));
            	event.setName(rs.getString("name"));
				event.setCategory(rs.getString("category"));
				event.setDate(rs.getString("date"));
				event.setStartTime(rs.getString("startTime"));
				event.setEndTime(rs.getString("endTime"));
				event.setLocation(rs.getString("location"));
				event.setDescription(rs.getString("description"));
				event.setReminder(rs.getBoolean("reminder"));
				event.setReminderDate(rs.getString("reminderDate"));
				event.setReminderTime(rs.getString("reminderTime"));

                calendarEvents.add(event);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return calendarEvents;
    }
	
	/**
	 * Deleting the selected event from the database
	 * @param id id of the deleted event 
	 */
	public void deleteEvent(int id) {
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("delete from eventsTable where id = ?");
			ps.setInt(1, id);
            ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problem with deleting the event");
		}
	}
	

	

}
