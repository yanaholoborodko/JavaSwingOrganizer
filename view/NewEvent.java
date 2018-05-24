package view;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.toedter.calendar.JDateChooser;

public class NewEvent {
	
	private MyOrganizer2 organizerView;

	// Layout
	SpringLayout springLayout = new SpringLayout();

	private JFrame frmNewEvent;
	private JPanel panel;

	// Labels
	private JLabel lblName;
	private JLabel lblCategory;
	private JLabel lblDate;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JLabel lblLocation;
	private JLabel lblDescription;

	// /Fields
	private JTextField name;
	private Choice category;
	private JDateChooser date;
	private JTextField location;
	private JTextArea description;
	private JFormattedTextField startTime;
	private JFormattedTextField endTime;
	private JFormattedTextField reminderTime;
	private JCheckBox reminder;
	private JDateChooser reminderDate;

	// Buttons
	private JButton btnSave;
	private JButton btnClear;
	
	SimpleDateFormat format = new SimpleDateFormat("hh:mm");

	private void initialize() {
		initFrame();
		initPanel();
		
		//Init Labels
		initLabelName();
		initLabelCategory();
		initLabelDate();
		initLabelStartTime();
		initLabelEndTime();
		initLabelLocation();
		initLabelDescription();
		
		//Init Fields
		initTFName();
		initChoice();
		initJDateChooser();
		initTFStartTime();
		initTFEndTime();
		initTFLocation();
		initTADescription();
		initCBReminder();
		initReminderDate();
		initReminderTime();
		
		//Init Buttons
		initButtonSave();
		initButtonClear();
		
	}

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEvent window = new NewEvent();
					window.frmNewEvent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public NewEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initFrame() {
		frmNewEvent = new JFrame();
		frmNewEvent.setTitle("New Event");
		frmNewEvent.setBounds(100, 100, 450, 367);
		frmNewEvent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNewEvent.getContentPane().setLayout(springLayout);
	}

	private void initPanel() {
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0,
				SpringLayout.NORTH, frmNewEvent.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0,
				SpringLayout.WEST, frmNewEvent.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 329,
				SpringLayout.NORTH, frmNewEvent.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 434,
				SpringLayout.WEST, frmNewEvent.getContentPane());
		frmNewEvent.getContentPane().add(panel);
	}

	private void initLabelName() {
		panel.setLayout(null);
		lblName = new JLabel("Name:");
		lblName.setBounds(20, 10, 38, 16);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelCategory() {
		lblCategory = new JLabel("Category:");
		lblCategory.setBounds(20, 43, 56, 16);
		panel.add(lblCategory);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelDate() {
		lblDate = new JLabel("Date:");
		lblDate.setBounds(20, 76, 31, 16);
		panel.add(lblDate);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelStartTime() {
		lblStartTime = new JLabel("Start time:");
		lblStartTime.setBounds(20, 111, 62, 16);
		panel.add(lblStartTime);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelEndTime() {
		lblEndTime = new JLabel("End time:");
		lblEndTime.setBounds(21, 146, 55, 16);
		panel.add(lblEndTime);
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelLocation() {
		lblLocation = new JLabel("Location:");
		lblLocation.setBounds(20, 181, 52, 16);
		panel.add(lblLocation);
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelDescription() {
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(20, 218, 68, 16);
		panel.add(lblDescription);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initTFName() {
		name = new JTextField();
		name.setBounds(100, 10, 265, 20);
		panel.add(name);
		name.setColumns(10);
	}

	private void initChoice() {
		category = new Choice();
		category.setBounds(100, 44, 117, 20);
		category.add("--------------------------");
		category.add("University");
		category.add("Work");
		category.add("Personal");
		category.add("Sport");
		category.add("Learning");
		category.add("Family, friends");
		category.add("Entertainment");

		panel.add(category);
	}

	private void initJDateChooser() {
		date = new JDateChooser();
		date.setBounds(100, 76, 117, 20);
		panel.add(date);
	}

	private void initTFStartTime() {
		startTime = new JFormattedTextField(format);
		startTime.setBounds(100, 107, 86, 20);
		startTime.setValue(new Date(11));
		panel.add(startTime);
	}

	private void initTFEndTime() {
		endTime = new JFormattedTextField(format);
		endTime.setBounds(100, 142, 86, 20);
		endTime.setValue(new Date(11));
		panel.add(endTime);
	}
	
	private void initTFLocation() {
		location = new JTextField();
		location.setBounds(100, 181, 265, 20);
		panel.add(location);
		location.setColumns(10);
	}
	
	private void initTADescription() {
		description = new JTextArea();
		description.setBounds(100, 218, 265, 47);
		panel.add(description);
	}

	private void initCBReminder() {
		reminder = new JCheckBox("Reminder");
		reminder.setBounds(10, 271, 81, 25);
		reminder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(reminder);
	}



	private void initButtonSave() {
		btnSave = new JButton("Save");
		btnSave.setBounds(356, 296, 68, 23);
		panel.add(btnSave);
	}

	private void initButtonClear() {
		btnClear = new JButton("Clear");
		btnClear.setBounds(282, 296, 68, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				name.setText("");
				category.select(0);
				date.setDate(null);
				startTime.setText("");
				endTime.setText("");
				location.setText("");
				description.setText("");
				reminder.setSelected(false);

			}
		});
		panel.add(btnClear);
	}

	private void initReminderDate() {
		reminderDate = new JDateChooser();
		reminderDate.setBounds(100, 276, 95, 20);
		reminderDate.setEnabled(false);
		panel.add(reminderDate);
	}

	private void initReminderTime() {
		reminderTime = new JFormattedTextField(format);
		reminderTime.setBounds(100, 299, 73, 20);
		reminderTime.setEnabled(false);
		reminderTime.setValue(new Date(11));
		panel.add(reminderTime);

	}

	public String getName() {
		return name.getText();
	}

	public String getLocation() {
		return location.getText();
	}

	public String getDescription() {
		return description.getText();
	}

	public String getStartTime() {
		return startTime.getText();
	}

	public String getEndTime() {
		return endTime.getText();
	}

	public String getReminderTime() {
		return reminderTime.getText();
	}

	public String getCategory() {
		return category.getSelectedItem();
	}

	public String getDate() {
		return date.getDate().toString();
	}

	//!!!!!! work this through - date from JCalendar
	public void setDate() {
		if(this.organizerView.getCalendarDate() != null){
		this.date.setDate(this.organizerView.getCalendarDate());
		}
		else this.date.setDate(null);	
	}

	public boolean getReminder() {
		return reminder.isSelected();
	}

	public String getReminderDate() {
		return reminderDate.getDate().toString();
	}

	
	public void setName(String name) {
		this.name.setText(name);
	}

	//??
	public void setCategory(String category) {
		this.category.setName(category);
	}

	
	public void setDate(Date date) {
		this.date.setDate(date);
	}

	public void setLocation(String location) {
		this.location.setText(location);
	}

	public void setDescription(String description) {
		this.description.setText(description);
	}

	public void setStartTime(String startTime) {
		this.startTime.setText(startTime);
	}

	public void setEndTime(String endTime) {
		this.endTime.setText(endTime);
	}

	public void setReminderTime(String reminderTime) {
		this.reminderTime.setText(reminderTime);
	}

	public void setReminder(boolean reminder) {
		this.reminder.setSelected(reminder);
	}

	public void setReminderDate(JDateChooser reminderDate) {
		this.reminderDate = reminderDate;
	}

	/**
	 * Action listeners for Save and Clear buttons
	 */
	public void setSaveEventButtonListener(ActionListener saveEventButtonListener){
		this.btnSave.addActionListener(saveEventButtonListener);
	}

	public void setClearEventButtonListener(ActionListener clearEventButtonListener){
		this.btnClear.addActionListener(clearEventButtonListener);
	}
}
