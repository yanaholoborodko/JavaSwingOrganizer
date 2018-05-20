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

import model.ConnectDatabase;


import com.toedter.calendar.JDateChooser;

public class NewEvent {
	
	private MyOrganizer2 organizerView;

	// Layout
	SpringLayout springLayout = new SpringLayout();
	SpringLayout sl_panel = new SpringLayout();

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

	
	//????????????? here or not
	Connection con = null;
	ResultSet results = null;
	PreparedStatement ps = null;
	AtomicInteger id = new AtomicInteger(0);
	

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
	 */
	public NewEvent() {
		initialize();
		con = ConnectDatabase.connectDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initFrame() {
		frmNewEvent = new JFrame();
		frmNewEvent.setTitle("New Event");
		frmNewEvent.setBounds(100, 100, 450, 367);
		frmNewEvent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel.setLayout(sl_panel);
	}

	private void initLabelName() {
		lblName = new JLabel("Name:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblName, 10,
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblName, 20,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblName, -376,
				SpringLayout.EAST, panel);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelCategory() {
		lblCategory = new JLabel("Category:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategory, 17,
				SpringLayout.SOUTH, lblName);
		sl_panel.putConstraint(SpringLayout.WEST, lblCategory, 20,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCategory, -270,
				SpringLayout.SOUTH, panel);
		panel.add(lblCategory);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelDate() {
		lblDate = new JLabel("Date:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDate, 17,
				SpringLayout.SOUTH, lblCategory);
		sl_panel.putConstraint(SpringLayout.WEST, lblDate, 0,
				SpringLayout.WEST, lblName);
		panel.add(lblDate);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelStartTime() {
		lblStartTime = new JLabel("Start time:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblStartTime, 19,
				SpringLayout.SOUTH, lblDate);
		sl_panel.putConstraint(SpringLayout.WEST, lblStartTime, 0,
				SpringLayout.WEST, lblName);
		panel.add(lblStartTime);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelEndTime() {
		lblEndTime = new JLabel("End time:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEndTime, 19,
				SpringLayout.SOUTH, lblStartTime);
		sl_panel.putConstraint(SpringLayout.EAST, lblEndTime, 0,
				SpringLayout.EAST, lblCategory);
		panel.add(lblEndTime);
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelLocation() {
		lblLocation = new JLabel("Location:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblLocation, 19,
				SpringLayout.SOUTH, lblEndTime);
		sl_panel.putConstraint(SpringLayout.WEST, lblLocation, 0,
				SpringLayout.WEST, lblName);
		panel.add(lblLocation);
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initLabelDescription() {
		lblDescription = new JLabel("Description:");
		sl_panel.putConstraint(SpringLayout.NORTH, reminder, 37,
				SpringLayout.SOUTH, lblDescription);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescription, 21,
				SpringLayout.SOUTH, lblLocation);
		sl_panel.putConstraint(SpringLayout.WEST, lblDescription, 20,
				SpringLayout.WEST, panel);
		panel.add(lblDescription);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void initTFName() {
		name = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, name, 10,
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, name, 42, SpringLayout.EAST,
				lblName);
		sl_panel.putConstraint(SpringLayout.SOUTH, name, -299,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, name, -69, SpringLayout.EAST,
				panel);
		panel.add(name);
		name.setColumns(10);
	}

	private void initChoice() {
		category = new Choice();
		sl_panel.putConstraint(SpringLayout.NORTH, category, 13,
				SpringLayout.SOUTH, name);
		sl_panel.putConstraint(SpringLayout.WEST, category, 100,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, category, -217,
				SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblCategory, -24,
				SpringLayout.WEST, category);
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
		sl_panel.putConstraint(SpringLayout.NORTH, date, 76,
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, date, 49, SpringLayout.EAST,
				lblDate);
		sl_panel.putConstraint(SpringLayout.EAST, date, -217,
				SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, category, -13,
				SpringLayout.NORTH, date);
		sl_panel.putConstraint(SpringLayout.SOUTH, date, -233,
				SpringLayout.SOUTH, panel);
		panel.add(date);
	}

	private void initTFStartTime() {
		startTime = new JFormattedTextField(format);
		startTime.setValue(new Date(11));
		sl_panel.putConstraint(SpringLayout.NORTH, startTime, -20,
				SpringLayout.SOUTH, lblStartTime);
		sl_panel.putConstraint(SpringLayout.WEST, startTime, 18,
				SpringLayout.EAST, lblStartTime);
		sl_panel.putConstraint(SpringLayout.SOUTH, startTime, 0,
				SpringLayout.SOUTH, lblStartTime);
		sl_panel.putConstraint(SpringLayout.EAST, startTime, 104,
				SpringLayout.EAST, lblStartTime);
		panel.add(startTime);
	}

	private void initTFEndTime() {
		endTime = new JFormattedTextField(format);
		sl_panel.putConstraint(SpringLayout.NORTH, location, 19,
				SpringLayout.SOUTH, endTime);
		endTime.setValue(new Date(11));
		sl_panel.putConstraint(SpringLayout.NORTH, endTime, 15,
				SpringLayout.SOUTH, startTime);
		sl_panel.putConstraint(SpringLayout.WEST, endTime, 24,
				SpringLayout.EAST, lblEndTime);
		sl_panel.putConstraint(SpringLayout.EAST, endTime, 0,
				SpringLayout.EAST, startTime);
		panel.add(endTime);
	}
	
	private void initTFLocation() {
		location = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, location, 28,
				SpringLayout.EAST, lblLocation);
		sl_panel.putConstraint(SpringLayout.EAST, location, 0,
				SpringLayout.EAST, name);
		panel.add(location);
		location.setColumns(10);
	}
	
	private void initTADescription() {
		description = new JTextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, description, 218,
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, description, -64,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, location, -17,
				SpringLayout.NORTH, description);
		sl_panel.putConstraint(SpringLayout.WEST, description, 100,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, description, 277,
				SpringLayout.EAST, lblDescription);
		panel.add(description);
	}

	private void initCBReminder() {
		reminder = new JCheckBox("Reminder");
		sl_panel.putConstraint(SpringLayout.WEST, reminder, 10,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, reminder, -33,
				SpringLayout.SOUTH, panel);
		reminder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(reminder);
	}



	private void initButtonSave() {
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ці всі штуки мають бути в модел (датабейс)
				try {
					// AtomicInteger id = new AtomicInteger(0);
					java.sql.Date sqlDate;
					sqlDate = (java.sql.Date) date.getDate();

					String query = "insert into event(Name, Category, Date, StartTime, EndTime, Location, Description, Reminder) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
					ps = con.prepareStatement(query);
					// ps.setInt(1, id.incrementAndGet());
					ps.setString(1, name.getText());
					ps.setString(2, category.getSelectedItem().toString());
					// ps.setDate(4, (java.sql.Date) dateChooser.getDate());
					// ps.setDate(4, sqlDate);
					ps.setDate(3, null);
					ps.setString(4, startTime.getText());
					ps.setString(5, endTime.getText());
					ps.setString(6, location.getText());
					ps.setString(7, description.getText());
					ps.setBoolean(8, reminder.isSelected());
					ps.execute();

					JOptionPane.showMessageDialog(null, "The event is saved!");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, btnSave, -78,
				SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnSave, -10,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnSave, -10,
				SpringLayout.EAST, panel);
		panel.add(btnSave);
	}

	private void initButtonClear() {
		btnClear = new JButton("Clear");
		sl_panel.putConstraint(SpringLayout.WEST, btnClear, 282,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnClear, -6, SpringLayout.WEST,
				btnSave);
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
		sl_panel.putConstraint(SpringLayout.NORTH, btnClear, 0,
				SpringLayout.NORTH, btnSave);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnClear, -10,
				SpringLayout.SOUTH, panel);
		panel.add(btnClear);
	}

	private void initReminderDate() {
		reminderDate = new JDateChooser();
		reminderDate.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, reminderDate, 11,
				SpringLayout.SOUTH, description);
		sl_panel.putConstraint(SpringLayout.WEST, reminderDate, 0,
				SpringLayout.WEST, name);
		sl_panel.putConstraint(SpringLayout.SOUTH, reminderDate, 0,
				SpringLayout.SOUTH, reminder);
		sl_panel.putConstraint(SpringLayout.EAST, reminderDate, 9,
				SpringLayout.EAST, startTime);
		panel.add(reminderDate);
	}

	private void initReminderTime() {
		reminderTime = new JFormattedTextField(format);
		reminderTime.setEnabled(false);
		reminderTime.setValue(new Date(11));
		sl_panel.putConstraint(SpringLayout.NORTH, reminderTime, 3,
				SpringLayout.SOUTH, reminderDate);
		sl_panel.putConstraint(SpringLayout.WEST, reminderTime, 100,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, reminderTime, 173,
				SpringLayout.WEST, panel);
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

	
	//Action listeners for Save and Clear buttons
	public void saveEventButtonListener(ActionListener saveEventButtonListener){
		this.btnSave.addActionListener(saveEventButtonListener);
	}

	public void clearEventButtonListener(ActionListener clearEventButtonListener){
		this.btnClear.addActionListener(clearEventButtonListener);
	}
}
