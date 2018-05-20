package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import javax.swing.JTabbedPane;

public class MyOrganizer2 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame frmOrganizer;
	private JPanel panel_1;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private JCalendar calendar;

	// Menu
	private JMenuBar menuBar;
	private JMenu mFile;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemClose;
	private JMenu mSettings;
	private JMenu mAbout;

	// buttons
	private JButton addEvent;
	private JButton editEvent;
	private JButton deleteEvent;
	private JButton readXMLButton;
	private JButton writeXMLButton;
	DefaultTableModel defaultTableModel;
	

	SpringLayout springLayout = new SpringLayout();
	SpringLayout sl_panel_1 = new SpringLayout();
	SpringLayout sl_panel = new SpringLayout();

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyOrganizer2 window = new MyOrganizer2();
					window.frmOrganizer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Create the application.
	 */
	public MyOrganizer2() {
		try {
			initialize();
		}catch(Exception message) {
			System.out.println(message.getMessage());
			JOptionPane.showMessageDialog(frmOrganizer, message.getMessage(),"Initialize Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		defaultTableModel = new DefaultTableModel(); 
		initializeFrame();
		initPanel();
		initPanel2();
		initializeMenuBar();

		initScrollPane();
		initTable();
		initCalendar();

		initAddEvent();
		initEditEvent();
		initDeleteEvent();
		initReadXMLButton();
		initWriteXMLButton();
		
	}

	private void initializeFrame() {
		frmOrganizer = new JFrame();
		frmOrganizer.setTitle("Organizer");
		frmOrganizer.setBounds(100, 100, 833, 499);
		frmOrganizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOrganizer.getContentPane().setLayout(springLayout);
	}

	private void initializeMenuBar() {
		menuBar = new JMenuBar();
		frmOrganizer.setJMenuBar(menuBar);

		mFile = new JMenu("File");
		menuBar.add(mFile);

		itemOpen = new JMenuItem("Open");
		mFile.add(itemOpen);

		itemSave = new JMenuItem("Save");
		mFile.add(itemSave);

		itemClose = new JMenuItem("Close");
		mFile.add(itemClose);

		mSettings = new JMenu("Settings");
		menuBar.add(mSettings);

		mAbout = new JMenu("About");
		menuBar.add(mAbout);
	}

	private void initPanel() {
		panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 52,
				SpringLayout.NORTH, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 10,
				SpringLayout.NORTH, frmOrganizer.getContentPane());
		frmOrganizer.getContentPane().add(panel_1);
		panel_1.setLayout(sl_panel_1);
	}

	private void initScrollPane() {
		
			
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -41,
				SpringLayout.SOUTH, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -37, SpringLayout.EAST, frmOrganizer.getContentPane());
		scrollPane.setBounds(793, 70, -449, 335);
		frmOrganizer.getContentPane().add(scrollPane);
	}

	private void initTable() {
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Category", "Date", "Start Time", "End Time", "Location", "Description", "Reminder"
			}
		));
		scrollPane.setViewportView(table);
		springLayout.putConstraint(SpringLayout.NORTH, table, 18,
				SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, table, -24,
				SpringLayout.EAST, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 353,
				SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, table, -473,
				SpringLayout.EAST, frmOrganizer.getContentPane());
	}

	private void initCalendar() {
		calendar = new JCalendar();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, calendar);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 17, SpringLayout.EAST, calendar);
		springLayout.putConstraint(SpringLayout.NORTH, calendar, 12, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, calendar, -121, SpringLayout.SOUTH, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, calendar, 10,
				SpringLayout.WEST, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, calendar, 311,
				SpringLayout.WEST, frmOrganizer.getContentPane());
	}

	private void initAddEvent() {
		addEvent = new JButton("Add event");
		sl_panel_1.putConstraint(SpringLayout.EAST, addEvent, 99,
				SpringLayout.WEST, panel_1);
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// відкриваємо діалогове вікно, де вводимо інфу про івент
				// new event з інфою звідти
				NewEvent newEvent = new NewEvent();
				newEvent.newScreen();
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, addEvent, 0,
				SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, addEvent, 0,
				SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, addEvent, 0,
				SpringLayout.SOUTH, panel_1);
		panel_1.add(addEvent);
	}

	private void initEditEvent() {
		editEvent = new JButton("Edit event");
		sl_panel_1.putConstraint(SpringLayout.NORTH, editEvent, 0,
				SpringLayout.NORTH, addEvent);
		sl_panel_1.putConstraint(SpringLayout.WEST, editEvent, 3,
				SpringLayout.EAST, addEvent);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, editEvent, 0,
				SpringLayout.SOUTH, addEvent);
		sl_panel_1.putConstraint(SpringLayout.EAST, editEvent, 102,
				SpringLayout.EAST, addEvent);
		panel_1.add(editEvent);
	}

	private void initDeleteEvent() {
		deleteEvent = new JButton("Delete event");
		sl_panel_1.putConstraint(SpringLayout.NORTH, deleteEvent, 0,
				SpringLayout.NORTH, addEvent);
		sl_panel_1.putConstraint(SpringLayout.WEST, deleteEvent, 2,
				SpringLayout.EAST, editEvent);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, deleteEvent, 0,
				SpringLayout.SOUTH, addEvent);
		sl_panel_1.putConstraint(SpringLayout.EAST, deleteEvent, 101,
				SpringLayout.EAST, editEvent);
		panel_1.add(deleteEvent);
		frmOrganizer.getContentPane().add(calendar);
	}
	
	private void initPanel2(){
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -259, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel, 570, SpringLayout.WEST, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -31, SpringLayout.EAST, frmOrganizer.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 52, SpringLayout.NORTH, frmOrganizer.getContentPane());
		frmOrganizer.getContentPane().add(panel);
		panel.setLayout(sl_panel);
	}
	
	private void initReadXMLButton(){
		readXMLButton = new JButton("Read from XML");
		sl_panel.putConstraint(SpringLayout.NORTH, readXMLButton, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, readXMLButton, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, readXMLButton, 42, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, readXMLButton, 105, SpringLayout.WEST, panel);
		panel.add(readXMLButton);
	}
	
	private void initWriteXMLButton(){
		writeXMLButton = new JButton("Write to XML");
		sl_panel.putConstraint(SpringLayout.NORTH, writeXMLButton, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, writeXMLButton, 3, SpringLayout.EAST, readXMLButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, writeXMLButton, 0, SpringLayout.SOUTH, readXMLButton);
		sl_panel.putConstraint(SpringLayout.EAST, writeXMLButton, 108, SpringLayout.EAST, readXMLButton);
		panel.add(writeXMLButton);
	}
	
	
	//Listeners
		
	public void openButtonListener(ActionListener openButtonListener ) {
		this.itemOpen.addActionListener(openButtonListener);
	}
	
	public void saveButtonListener(ActionListener saveButtonListener ) {
		this.itemSave.addActionListener(saveButtonListener);
	}
	
	public void closeButtonListener(ActionListener closeButtonListener ) {
		this.itemClose.addActionListener(closeButtonListener);
	}
	
	public void settingsButtonListener(ActionListener settingsMenuItemButtonListener ) {
		this.mSettings.addActionListener(settingsMenuItemButtonListener);
	}
	
	public void aboutButtonListener(ActionListener aboutButtonListener) {
		this.mAbout.addActionListener(aboutButtonListener);
	}
	
	public void addEventButtonListener(ActionListener addEventButtonListener){
		this.addEvent.addActionListener(addEventButtonListener);
	}
	
	public void editEventButtonListener(ActionListener editEventButtonListener){
		this.editEvent.addActionListener(editEventButtonListener);
	}
	
	public void deleteEventButtonListener(ActionListener deleteEventButtonListener){
		this.deleteEvent.addActionListener(deleteEventButtonListener);
	}
	
	public void readXMLButtonListener(ActionListener readXMLButtonListener){
		this.readXMLButton.addActionListener(readXMLButtonListener);
	}
	
	public void writeXMLButtonListener(ActionListener writeXMLButtonListener){
		this.writeXMLButton.addActionListener(writeXMLButtonListener);
	}
	
	public Date getCalendarDate(){
		return this.calendar.getDate();
	}
	//?
	public void addRow(Object[] rowData) {
		defaultTableModel.addRow(rowData);
	}
	
	public void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
