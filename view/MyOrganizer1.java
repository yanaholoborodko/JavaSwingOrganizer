package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import javax.swing.JMenuItem;

public class MyOrganizer1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyOrganizer1 window = new MyOrganizer1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyOrganizer1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 783, 438);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 783, 21);
		panel.add(menuBar);
		
		JMenu mnAddEvent = new JMenu("File");
		menuBar.add(mnAddEvent);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnAddEvent.add(mntmSave);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnAddEvent.add(mntmClose);
		
		JMenuItem mntmReadFromXml = new JMenuItem("Read from XML");
		mnAddEvent.add(mntmReadFromXml);
		
		JMenuItem mntmWriteToXml = new JMenuItem("Write to XML");
		mnAddEvent.add(mntmWriteToXml);
		
		JMenuItem mntmReadFromDatabase = new JMenuItem("Read from database");
		mnAddEvent.add(mntmReadFromDatabase);
		
		JMenuItem mntmWriteToDatabase = new JMenuItem("Write to database");
		mnAddEvent.add(mntmWriteToDatabase);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-23, 51, 202, 159);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(38, 5, 140, 153);
		panel_1.add(calendar);
	}
}
