import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

/**
 * GUI to add a homework assignment
 * @author Aaron Wang
 */
public class AddHomework extends JFrame {
	
	private Homework hmwk;
	private JPanel contentPane;
	private JTextField hmwkName;
	private JComboBox monthDue;
	private JComboBox dateDue;
	private JComboBox yearDue;
	private JButton btnAddHmwk;
	
	/**
	 * Create the frame.
	 */
	public AddHomework() {
		// create JPanel
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// create JLabel
		JLabel lblHmwkName = new JLabel("Homework Name");
		lblHmwkName.setBounds(50, 15, 100, 20);
		contentPane.add(lblHmwkName);
		
		// create JTextField to enter homework name
		hmwkName = new JTextField();
		hmwkName.setBounds(50, 45, 200, 20);
		contentPane.add(hmwkName);
		
		// create JLabel
		JLabel lblMonthDue = new JLabel("Month Due");
		lblMonthDue.setBounds(50, 75, 75, 20);
		contentPane.add(lblMonthDue);
		
		// create JLabel
		JLabel lblDateDue = new JLabel("Date Due");
		lblDateDue.setBounds(175, 75, 75, 20);
		contentPane.add(lblDateDue);
		
		// create JLabel
		JLabel lblYearDue = new JLabel("Year Due");
		lblYearDue.setBounds(300, 75, 75, 20);
		contentPane.add(lblYearDue);
		
		// add month names to months Array
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		// add dates and years to arrays
		String[] dates = new String[31];
		String[] years = new String[31];
		for(int i = 0; i < 31; i ++) {
			dates[i] = "" + (int)(i+1);
			years[i] = "" + (int)(2021 + i);
		}
		
		// create JComboBox with month names
		JComboBox monthDue = new JComboBox(months);
		contentPane.add(monthDue);
		monthDue.setBounds(50, 100, 100, 20);
		monthDue.setVisible(true);
		
		// create JComboBox with dates of months
		JComboBox dateDue = new JComboBox(dates);
		contentPane.add(dateDue);
		dateDue.setBounds(175, 100, 100, 20);
		dateDue.setVisible(true);
		
		// create JComboBox with years from 2021 to 2051
		JComboBox yearDue = new JComboBox(years);
		contentPane.add(yearDue);
		yearDue.setBounds(300, 100, 100, 20);
		yearDue.setVisible(true);
		
		// create JButton to add homework
		JButton btnAddHmwk = new JButton("Add Homework");
		btnAddHmwk.setBounds(50, 150, 150, 25);
		contentPane.add(btnAddHmwk);
	}
	
	/**
	 * Returns the number of the given month
	 * @param monthName
	 * @return the number of the month
	 */
	public int monthNumber(String monthName) {
		int mDue;
		switch (monthName) {
			case "January":  
				mDue = 1;
				break;
			case "February":  
				mDue = 2;
				break;
			case "March":  
				mDue = 3;
				break;
			case "April":  
				mDue = 4;
				break;
			case "May":  
				mDue = 5;
				break;
			case "June":  
				mDue = 6;
				break;
			case "July":  
				mDue = 7;
				break;
			case "August":  
				mDue = 8;
				break;
			case "September":  
				mDue = 9;
				break;
			case "October":  
				mDue = 10;
				break;
			case "November":  
				mDue = 11;
				break;
			case "December":  
				mDue = 12;
				break;
			default:
				mDue = 1;
		}
		return mDue;
	}
	

}
