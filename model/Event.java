package model;

import java.sql.Connection;

public class Event {


	Connection connection;
	private String name;
	private String description;
	private String category;
	private String date;
	private String startTime;
	private String endTime;
	private String location;
	private boolean reminder;
	private String reminderDate;
	private String reminderTime;
	
	public Event(){
		
	}
	
	public Event(String name, String description, String category, String date,
			String startTime, String endTime, String location,
			boolean reminder, String reminderDate, String reminderTime) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.reminder = reminder;
		this.reminderDate = reminderDate;
		this.reminderTime = reminderTime;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isReminder() {
		return reminder;
	}

	public void setReminder(boolean reminder) {
		this.reminder = reminder;
	}

	public String getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}

	public String getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(String reminderTime) {
		this.reminderTime = reminderTime;
	}
}
