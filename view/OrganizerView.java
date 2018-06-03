package view;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import javax.swing.JMenuItem;

public class OrganizerView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame frmOrganizer;
	private JTable table;
	private JScrollPane scrollPane;
	private JCalendar calendar;

	// Menu
	private JMenuBar menuBar;
	private JMenu mSettings;
	private JMenu mAbout;

	// buttons
	private JButton addEvent;
	private JButton editEvent;
	private JButton deleteEvent;
	private JButton readXMLButton;
	private JButton writeXMLButton;
	DefaultTableModel defaultTableModel;
	private JMenuItem aboutProgram;
	
	/**
	 * Create the application.
	 */
	public OrganizerView() {
		try {
			initialize();
			frmOrganizer.setVisible(true);
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
		frmOrganizer.setBounds(100, 100, 1230, 587);
		frmOrganizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeMenuBar() {
		menuBar = new JMenuBar();
		frmOrganizer.setJMenuBar(menuBar);

		mSettings = new JMenu("Settings");
		menuBar.add(mSettings);

		mAbout = new JMenu("About");
		menuBar.add(mAbout);
		
		aboutProgram = new JMenuItem("About program");
		mAbout.add(aboutProgram);
	}

	private void initScrollPane() {
		frmOrganizer.getContentPane().setLayout(null);
		
			
		scrollPane = new JScrollPane();
		scrollPane.setBounds(359, 64, 818, 422);
		frmOrganizer.getContentPane().add(scrollPane);
	}

	private void initTable() {
		
		String[] columnIDs = new String[] {	"Name", "Category", "Date", "Start Time", "End Time", "Location", "Description", "Reminder"	};
		defaultTableModel.setColumnIdentifiers(columnIDs);
		table = new JTable(defaultTableModel);
	
	/*	table.setModel(new DefaultTableModel(
			new Object[][] {
					
			},
			new String[] {
				"Name", "Category", "Date", "Start Time", "End Time", "Location", "Description", "Reminder"
			}
		));*/
		scrollPane.setViewportView(table);
	}

	private void initCalendar() {
		calendar = new JCalendar();
		calendar.setBounds(10, 64, 326, 342);
	}

	private void initAddEvent() {
	}

	private void initEditEvent() {
	}

	private void initDeleteEvent() {
		frmOrganizer.getContentPane().add(calendar);
		writeXMLButton = new JButton("Write to XML");
		writeXMLButton.setBounds(1035, 10, 142, 42);
		frmOrganizer.getContentPane().add(writeXMLButton);
		readXMLButton = new JButton("Read from XML");
		readXMLButton.setBounds(884, 10, 141, 42);
		frmOrganizer.getContentPane().add(readXMLButton);
		deleteEvent = new JButton("Delete event");
		deleteEvent.setBounds(227, 11, 105, 42);
		frmOrganizer.getContentPane().add(deleteEvent);
		editEvent = new JButton("Edit event");
		editEvent.setBounds(119, 10, 99, 42);
		frmOrganizer.getContentPane().add(editEvent);
		addEvent = new JButton("Add event");
		addEvent.setBounds(10, 10, 99, 42);
		frmOrganizer.getContentPane().add(addEvent);
	}
	
	
	private void initReadXMLButton(){
	}
	
	private void initWriteXMLButton(){
	}
	
	
	//Listeners
	/*public void openButtonListener(ActionListener openButtonListener ) {
		this.itemOpen.addActionListener(openButtonListener);
	}
	
	public void saveButtonListener(ActionListener saveButtonListener ) {
		this.itemSave.addActionListener(saveButtonListener);
	}
	
	public void closeButtonListener(ActionListener closeButtonListener ) {
		this.itemClose.addActionListener(closeButtonListener);
	}*/
	
	public void settingsButtonListener(ActionListener settingsMenuItemButtonListener ) {
		this.mSettings.addActionListener(settingsMenuItemButtonListener);
	}
	
	public void aboutButtonListener(ActionListener aboutButtonListener) {
		this.aboutProgram.addActionListener(aboutButtonListener);
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
	
	public void setCalendarPropertyListener(PropertyChangeListener calendarPropertyListener){
		this.calendar.getDayChooser().getDayPanel().addPropertyChangeListener(calendarPropertyListener);
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
