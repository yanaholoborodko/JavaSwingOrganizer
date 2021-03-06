package model;


/**
 * 
 * Model for the event
 * @author Yana Holoborodko 30379
 *
 */
public class Event {

	private int id;
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
	
	/**
	 * Constructor for the event
	 * @param name event`s name
	 * @param category event`s category
	 * @param date event`s date
	 * @param startTime event`s startTime
	 * @param endTime event`s endTime
	 * @param location event`s location
	 * @param description event`s description
	 * @param reminder event`s reminder
	 * @param reminderDate event`s reminderDate
	 * @param reminderTime event`s reminderTime
	 */
	public Event(String name, String category, String date,
			String startTime, String endTime, String location, String description,
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
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
