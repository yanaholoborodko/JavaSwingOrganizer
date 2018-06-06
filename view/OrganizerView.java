package view;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import controller.MainController;

/**
 * Main window of the application 
 * @author Yana Holoborodko 30379
 *
 */
public class OrganizerView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MainController mc;
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
	 * Create the window.
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

	/**
	 * Initializing the frame.
	 */
	private void initializeFrame() {
		frmOrganizer = new JFrame();
		frmOrganizer.setTitle("Organizer");
		frmOrganizer.setBounds(100, 100, 1230, 587);
		frmOrganizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initializing the menu bar.
	 */
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

	/**
	 * Initializing the scroll pane.
	 */
	private void initScrollPane() {
		frmOrganizer.getContentPane().setLayout(null);
		
			
		scrollPane = new JScrollPane();
		scrollPane.setBounds(359, 64, 818, 422);
		frmOrganizer.getContentPane().add(scrollPane);
	}

	/**
	 * Initializing the table.
	 */
	private void initTable() {
		
		String[] columnIDs = new String[] {	"ID", "Name", "Category", "Date", "Start Time", "End Time", "Location", "Description", "Reminder"	};
		defaultTableModel.setColumnIdentifiers(columnIDs);
		table = new JTable(defaultTableModel);
		table.setRowSelectionAllowed(true);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	System.out.println(table.getValueAt(table.getSelectedRow(), 0));
	        	String id = table.getValueAt(table.getSelectedRow(), 0).toString();
	        	int eventID = Integer.parseInt(id);
	        	mc.instance.setIdDelete(eventID);
	        }
	    });
		scrollPane.setViewportView(table);
	}

	/**
	 * Initializing the calendar.
	 */
	private void initCalendar() {
		calendar = new JCalendar();
		calendar.setBounds(10, 64, 326, 342);
		frmOrganizer.getContentPane().add(calendar);
	}

	/**
	 * Initializing the 'Add Event' button.
	 */
	private void initAddEvent() {
		addEvent = new JButton("Add event");
		addEvent.setBounds(10, 10, 99, 42);
		frmOrganizer.getContentPane().add(addEvent);
	}

	/**
	 * Initializing the 'Edit Event' button.
	 */
	private void initEditEvent() {
		editEvent = new JButton("Edit event");
		editEvent.setBounds(119, 10, 99, 42);
		frmOrganizer.getContentPane().add(editEvent);
	}

	/**
	 * Initializing the 'Delete Event' button.
	 */
	private void initDeleteEvent() {
		deleteEvent = new JButton("Delete event");
		deleteEvent.setBounds(227, 11, 105, 42);
		frmOrganizer.getContentPane().add(deleteEvent);
	}
	
	/**
	 * Initializing the 'Read from XML' button.
	 */
	private void initReadXMLButton(){
		readXMLButton = new JButton("Read from XML");
		readXMLButton.setBounds(884, 10, 141, 42);
		frmOrganizer.getContentPane().add(readXMLButton);
	}
	
	/**
	 * Initializing the 'Write to XML' button.
	 */
	private void initWriteXMLButton(){
		writeXMLButton = new JButton("Write to XML");
		writeXMLButton.setBounds(1035, 10, 142, 42);
		frmOrganizer.getContentPane().add(writeXMLButton);
	}
	
	/**
	 * set the ActionListener for the 'Settings' button
	 * @param settingsMenuItemButtonListener ActionListener for the 'Settings' button
	 */
	public void setSettingsButtonListener(ActionListener settingsMenuItemButtonListener ) {
		this.mSettings.addActionListener(settingsMenuItemButtonListener);
	}
	
	/**
	 * set the ActionListener for the 'About' button
	 * @param aboutButtonListener ActionListener for the 'About' button
	 */
	public void setAboutButtonListener(ActionListener aboutButtonListener) {
		this.aboutProgram.addActionListener(aboutButtonListener);
	}
	
	/**
	 * set the ActionListener for the 'Add Event' button
	 * @param addEventButtonListener ActionListener for the 'Add Event' button
	 */
	public void setAddEventButtonListener(ActionListener addEventButtonListener){
		this.addEvent.addActionListener(addEventButtonListener);
	}
	
	/**
	 * set the ActionListener for the 'Edit Event' button
	 * @param editEventButtonListener ActionListener for the 'Edit Event' button
	 */
	public void setEditEventButtonListener(ActionListener editEventButtonListener){
		this.editEvent.addActionListener(editEventButtonListener);
	}
	
	/**
	 * set the ActionListener for the 'Delete Event' button
	 * @param deleteEventButtonListener ActionListener for the 'Delete Event' button
	 */
	public void setDeleteEventButtonListener(ActionListener deleteEventButtonListener){
		this.deleteEvent.addActionListener(deleteEventButtonListener);
	}
	
	/**
	 * set the ActionListener for the 'Read from XML' button
	 * @param readXMLButtonListener ActionListener for the 'Read from XML' button
	 */
	public void setReadXMLButtonListener(ActionListener readXMLButtonListener){
		this.readXMLButton.addActionListener(readXMLButtonListener);
	}
	
	/**
	 * set the ActionListener for the 'Write to XML' button
	 * @param writeXMLButtonListener ActionListener for the 'Write to XML' button
	 */
	public void setWriteXMLButtonListener(ActionListener writeXMLButtonListener){
		this.writeXMLButton.addActionListener(writeXMLButtonListener);
	}
	
	/**
	 * set the PropertyChangeListener for the JCalendar
	 * @param calendarPropertyListener PropertyChangeListener for the JCalendar
	 */
	public void setCalendarPropertyListener(PropertyChangeListener calendarPropertyListener){
		this.calendar.getDayChooser().getDayPanel().addPropertyChangeListener(calendarPropertyListener);
	}
	
	
	public Date getCalendarDate(){
		return this.calendar.getDate();
	}
	
	/**
	 * Adds the row to the table
	 * @param rowData data of the row to be added to the table
	 */
	public void addRow(Object[] rowData) {
		defaultTableModel.addRow(rowData);
	}
	
	/**
	 * Clears the whole table
	 */
	public void clearTable() {
		for(int i = 0; i < defaultTableModel.getRowCount(); i++) {
			defaultTableModel.removeRow(i);	
		}
	}
	
	public void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
