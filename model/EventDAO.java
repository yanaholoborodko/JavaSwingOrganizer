package model;

import java.lang.reflect.Array;
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

	public void addEvent(Event event) {

		try {
			String query = "insert into event(Name, Category, Date, StartTime, EndTime, Location, Description, Reminder) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, event.getName());
			ps.setString(2, event.getCategory());
			ps.setString(3, event.getDate());
			ps.setString(4, event.getStartTime());
			ps.setString(5, event.getEndTime());
			ps.setString(6, event.getLocation());
			ps.setString(7, event.getDescription());
			ps.setBoolean(8, event.isReminder());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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
