package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EventDAO {

	private static Connection connection;
	public EventList eventList;
	Statement statement1;

	public EventDAO() throws SQLException {
		connection = ConnectDatabase.getConnection();
	//	eventListArray();
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
	 * 
	 * @param date - date for filterin events
	 * @return ArrayList of Events for a certain date (chosen on JCalendar)
	 */
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
		
	
/*	//blabla
	public void eventListArray() {

		//ArrayList<Event> eventList = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from eventsTable");

			while (rs.next()) {
				Event event = new Event(rs.getString("Name"),
						rs.getString("Category"), rs.getString("Date"),
						rs.getString("StartTime"), rs.getString("EndTime"),
						rs.getString("Location"), rs.getString("Description"),
						rs.getBoolean("Reminder"),
						rs.getString("ReminderDate"),
						rs.getString("ReminderTime"));
				eventList.add(event);
			}
			
		//	this.eventList.setList(eventList);;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem with getting list of events from db");
		}
	}*/

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
	 * 
	 * @return ArrayList of all Events
	 *//*
	public EventList eventList() {

		String query = "SELECT * FROM eventsTable";
		eventList = new EventList();
		Event event;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				event = new Event();
				//event.setId(rs.getInt("id");
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
				
				Event event = new Event(rs.getString("Name"),
						rs.getString("Category"), rs.getString("Date"),
						rs.getString("StartTime"), rs.getString("EndTime"),
						rs.getString("Location"), rs.getString("Description"),
						rs.getBoolean("Reminder"),
						rs.getString("ReminderDate"),
						rs.getString("ReminderTime"));
				eventList.add(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem with getting list of events from db");
		}
		return eventList;
	}
*/
	
	public EventList getEventList() {
		return eventList;
	}

	public void setEventList(EventList eventList) {
		this.eventList = eventList;
	}
	
	

}
