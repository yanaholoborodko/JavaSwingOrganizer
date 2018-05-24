package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EventDAO {

	private Connection connection;

	public EventDAO() throws SQLException {
		connection = ConnectDatabase.getConnection();
	}

	/**
	 * Creating event and inserting it into database
	 * @param event
	 */
	public void addEvent(Event event) {

		try {
			String query = "insert into event(Name, Category, Date, StartTime, EndTime, Location, Description, Reminder) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param date
	 * @return ArrayList of Events for a certain date (chosen on JCalendar)
	 */
	public ArrayList<Event> getEventsByDate(String date) {
		ArrayList<Event> eventListByDate = new ArrayList<Event>();
		try {
			
			PreparedStatement ps = connection.prepareStatement("select * from event where date = ?");
			ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
        	while (rs.next()) {
				Event event = new Event(rs.getString("Name"),
						rs.getString("Category"), rs.getString("Date"),
						rs.getString("StartTime"), rs.getString("EndTime"),
						rs.getString("Location"), rs.getString("Description"),
						rs.getBoolean("Reminder"),
						rs.getString("ReminderDate"),
						rs.getString("ReminderTime"));
				eventListByDate.add(event);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problem with getting list of events by date from db");
		}
		return eventListByDate;
	}
		
	/**
	 * 
	 * @return ArrayList of all Events
	 */
	public ArrayList<Event> eventList() {

		ArrayList<Event> eventList = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from event");

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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem with getting list of events from db");
		}
		return eventList;
	}

}
