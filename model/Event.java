package model;

import java.util.Date;

public class Event {

	private String name;
	private String description;
	private String category;
	private Date date;
	private Date startTime;
	private Date endTime;
	private String location;
	private boolean reminder;
	private boolean repeated;
	
	public Event(){
		
	}
	
	public Event(String name, String description, String category, Date date,
			Date startTime, Date endTime, String location, boolean reminder,
			boolean repeated) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.reminder = reminder;
		this.repeated = repeated;
	}
	
	public boolean isRepeated() {
		return repeated;
	}
	public void setRepeated(boolean repeated) {
		this.repeated = repeated;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
}
