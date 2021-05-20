import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 * Main class for the Homework Tracker. Displays a list of homework assignments with due dates.
 * @author Aaron Wang
 * @since 03-25-2021
 */

public class HomeworkTracker extends JFrame {
	
	// create instance variables
	private JPanel contentPane;
	private ArrayList<Homework> assignments;
	private String[] columnNames = {"Assignment Name", "Due Date", "Status"};;
	private JLabel lblHomework;
	private JLabel lblTodayDate;
	private JScrollPane tableScrollPane;
	private JButton btnAddHmwk;
	private JButton btnRemoveHmwk;
	private JButton btnStatus;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeworkTracker frame = new HomeworkTracker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public HomeworkTracker() {
		
		// initialize Homework ArrayList
		assignments = new ArrayList<Homework>();
		
		// assign column names
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date d = new Date();
		String date = formatter.format(d);
		
		// initialize JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// create Homework label
		lblHomework = new JLabel("Homework Assignments");
		lblHomework.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHomework.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomework.setBounds(25, 10, 375, 20);
		contentPane.add(lblHomework);
		
		lblTodayDate = new JLabel("Today's Date: " + date);
		lblTodayDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodayDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTodayDate.setBounds(415, 10, 160, 20);
		contentPane.add(lblTodayDate);
		
		// create JScrollPane to hold table
		tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(25, 40, 375, 350);
		contentPane.add(tableScrollPane);
		
		// create Add Homework button
		btnAddHmwk = new JButton("Add Homework");
		btnAddHmwk.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		// when clicked, add new homework to ArrayList, and add names and due date to TextArea
		btnAddHmwk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JFrame that will allow user to add assignment
				class AddAssignment extends AddHomework {
					
					private Homework hmwk;
					private JPanel contentPane;
					private JLabel lblHmwkName;
					private JLabel lblDateDue;
					private JLabel lblMonthDue;
					private JLabel lblYearDue;
					private JTextField hmwkName;
					private JComboBox monthDue;
					private JComboBox dateDue;
					private JComboBox yearDue;
					
					
					/**
					 * Create the frame.
					 */
					public AddAssignment() {
						
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
						
						// create JButton to add assignments
						JButton btnAddAssignment = new JButton("Add Homework");
						btnAddAssignment.addMouseListener(new MouseAdapter() {
							@Override
							// if mouse is clicked
							public void mouseClicked(MouseEvent e) {
								// check if all the text fields are filled in
								boolean notFilledIn = hmwkName.getText().equals("");
								
								// ternary statement
								String message = (notFilledIn) ? "Please fill in all fields" : "Assignment Successfully Created!";
								if (notFilledIn) {
									// if not filled in, notify user
									JOptionPane.showMessageDialog(contentPane, message);
								} else {
									
									// create homework assignment
									int mDue = monthNumber(monthDue.getSelectedItem().toString());
									hmwk = new Homework(hmwkName.getText(), mDue, Integer.parseInt(dateDue.getSelectedItem().toString()), Integer.parseInt(yearDue.getSelectedItem().toString()));
									
									// order assignment by date
									orderHomework(hmwk);
									
									// update Homework Table
									updateTable(tableScrollPane);
									
									// show message
									JOptionPane.showMessageDialog(contentPane, message);
									
									// clear text fields for new entries
									hmwkName.setText("");
								}
							}
						});
						btnAddAssignment.setBounds(50, 150, 150, 25);
						contentPane.add(btnAddAssignment);
					}
				}
				
				// create addHmwk and set visible
				AddAssignment addHmwk = new AddAssignment();
				addHmwk.setVisible(true);
			}
			
		});
		btnAddHmwk.setBounds(425, 40, 150, 20);
		contentPane.add(btnAddHmwk);
		
		// Create button to remove homework
		btnRemoveHmwk = new JButton("Remove Homework");
		btnRemoveHmwk.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRemoveHmwk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				class RemoveAssignment extends JFrame {
					
					// declare instance variables
					private JPanel contentPane;
					private JComboBox listHmwk;
					private JLabel lblAssignments;
					private String[] hmwkNames;
					
					/**
					 * Create the frame.
					 */
					public RemoveAssignment() {
						// create JPanel
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						setBounds(100, 100, 450, 300);
						contentPane = new JPanel();
						contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						setContentPane(contentPane);
						contentPane.setLayout(null);
						
						// create JLabel
						JLabel lblAssignments = new JLabel("Select the assignment you would like to remove.");
						lblAssignments.setBounds(25, 20, 300, 50);
						contentPane.add(lblAssignments);
						
						// create list of assignment names
						hmwkNames = new String[assignments.size()];
						int place = 0;
						for(Homework assignment : assignments) {
							hmwkNames[place] = assignment.getName();
							place++;
						}
						
						// create JComboBox with list of assignment names
						JComboBox listHmwk = new JComboBox(hmwkNames);
						listHmwk.setBounds(25, 60, 150, 25);
						contentPane.add(listHmwk);
						
						// create JButton to remove assignment
						JButton removeHmwk = new JButton("Remove Assignment");
						removeHmwk.addMouseListener(new MouseAdapter() {
							@Override
							// if mouse is clicked
							public void mouseClicked(MouseEvent e) {
								// find assignment based on name
								String name = listHmwk.getSelectedItem().toString();
								for(int i = 0; i < assignments.size(); i ++) {
									// remove selected assignment from assignments ArrayList
									Homework hmwk = assignments.get(i);
									if (hmwk.getName().equals(name)) {
										assignments.remove(i);
										hmwkNames[i] = "";
										break;
									}
								}

								// update table
								updateTable(tableScrollPane);
								
								// show message that assignment has been removed
								JOptionPane.showMessageDialog(contentPane, "Assignment Successfully Removed!");
							}
						});
						removeHmwk.setBounds(30, 200, 200, 25);
						contentPane.add(removeHmwk);
					}
				}
				
				// create RemoveHomework and set visible
				RemoveAssignment remHmwk = new RemoveAssignment();
				remHmwk.setVisible(true);
			}
		});
		btnRemoveHmwk.setBounds(425, 70, 150, 20);
		contentPane.add(btnRemoveHmwk);
		
		// create JButton to change status
		btnStatus = new JButton("Change Status");
		btnStatus.addMouseListener(new MouseAdapter() {
			@Override
			// if button is clicked
			public void mouseClicked(MouseEvent e) {
				class SetStatus extends ChangeStatus {
					
					// create instance variables
					private JPanel contentPane;
					private String[] homeworkNames = new String[assignments.size()];
					private String[] statuses = {"Incomplete", "Complete", "Overdue"};
					
					/**
					 * Create the frame.
					 */
					public SetStatus() {
						
						// create JPanel
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						setBounds(100, 100, 450, 300);
						contentPane = new JPanel();
						contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						setContentPane(contentPane);
						contentPane.setLayout(null);
						
						// create JLabel
						JLabel lblAssignment = new JLabel("Select assignment to change status");
						lblAssignment.setFont(new Font("Times New Roman", Font.BOLD, 14));
						lblAssignment.setBounds(25, 40, 300, 20);
						contentPane.add(lblAssignment);
						
						// add homework names to the homeworkNames Array
						int i = 0;
						for (Homework hmwk : assignments) {
							homeworkNames[i] = hmwk.getName();
							i++;
						}
						
						// create a new JComboBox with the contents of homeworkNames
						JComboBox comboAssignment = new JComboBox(homeworkNames);
						comboAssignment.setFont(new Font("Times New Roman", Font.PLAIN, 12));
						comboAssignment.setBounds(25, 60, 150, 25);
						contentPane.add(comboAssignment);
						
						// create JLabel
						JLabel lblNewStatus = new JLabel("New Status");
						lblNewStatus.setFont(new Font("Times New Roman", Font.BOLD, 14));
						lblNewStatus.setBounds(25, 115, 150, 20);
						contentPane.add(lblNewStatus);
						
						// create a new JComboBox with the contents of statuses
						JComboBox comboStatus = new JComboBox(statuses);
						comboStatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
						comboStatus.setBounds(25, 135, 150, 25);
						contentPane.add(comboStatus);
						
						// create JButton to change status
						JButton btnStatus = new JButton("Change Status");
						btnStatus.setFont(new Font("Times New Roman", Font.BOLD, 12));
						// if mouse is clicked
						btnStatus.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// change status of selected assignment to selected status
								assignments.get(comboAssignment.getSelectedIndex()).setStatus(comboStatus.getSelectedItem().toString());
								if (comboStatus.getSelectedItem().toString().equals("Complete")) {
									assignments.get(comboAssignment.getSelectedIndex()).doHomework();
								} else if (comboStatus.getSelectedItem().toString().equals("Incomplete")) {
									assignments.get(comboAssignment.getSelectedIndex()).undoHomework();
								}
								updateTable(tableScrollPane);
								JOptionPane.showMessageDialog(contentPane, "Status changed!");
							}
						});
						btnStatus.setBounds(25, 200, 125, 25);
						contentPane.add(btnStatus);
					}
				}
				
				// create setStatus and set visible
				SetStatus setStatus = new SetStatus();
				setStatus.setVisible(true);
			}
		});
		btnStatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnStatus.setBounds(425, 100, 150, 20);
		contentPane.add(btnStatus);
	}
	
	/**
	 * Updates the JTable that displays the homework so that it displays all assignments.
	 * @param tableScrollPane The JScrollPane that contains the JTable to display the assignments
	 */
	private void updateTable(JScrollPane scrollPane) {
		// create 2 dimensional array with assignment name
		String[][] hmwkData = new String[assignments.size()][3];
		int i = 0;
		for (Homework assignment : assignments) {
			// for each Homework in assignments, add the name and date to an array of length 3
			updateStatus(assignment);
			String[] data = {assignment.getName(), assignment.getDueDate(), assignment.getStatus()};
			// add each array containing homework data to the multidimensional array
			hmwkData[i] = data;
			i++;
		}
		
		// update table
		JTable hmwkTable = new JTable(hmwkData, columnNames);
		hmwkTable.disable();
		scrollPane.setViewportView(hmwkTable);
		scrollPane.setVisible(true);
	}
	
	/**
	 * Updates the status of each homework assignment (overdue or not).
	 * Marks whether the homework assignment is overdue
	 * @param hmwk The homework assignment being updated.
	 */
	private void updateStatus(Homework hmwk) {
		// get current date and format
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date d = new Date();
		String date = formatter.format(d);
		
		// get current year, month, and date
		int curYear = Integer.parseInt(date.substring(6));
		int curMonth = Integer.parseInt(date.substring(0, 2));
		int curDate = Integer.parseInt(date.substring(3, 5));
		
		if(!hmwk.getStatus().equals("Complete")) {
			// if year is greater than due date year, mark as overdue
			if (curYear > hmwk.getYear()) {
				hmwk.setStatus("Overdue");
				hmwk.setOverdue(true);
			} else if (curYear == hmwk.getYear()) { 
				// if current year is the same as due date year, check month
				if (curMonth > hmwk.getMonth()) { 
					// if current month is greater than due date month, mark as overdue
					hmwk.setStatus("Overdue");
					hmwk.setOverdue(true);
				} else if (curMonth == hmwk.getMonth()) { 
					// if current month is the same as due date year, check date
					if (curDate > hmwk.getDate()) { 
						// if current date is greater than due date day, mark as overdue
						hmwk.setStatus("Overdue");
						hmwk.setOverdue(true);
					} else { 
						// if current day is less than due date day, do  not mark as overdue
						hmwk.setOverdue(false);
					}
				} else { 
					// if current month is less than due date month, do not mark as overdue
					hmwk.setOverdue(false);
				}
			} else { 
				// if current year is less than due date year, do not mark as overdue
				hmwk.setOverdue(false);
			}
		}
	}
	
	/**
	 * Adds a new assignment into the ArrayList based on due date.
	 * Inserted into the spot where it is due later than the assignment before it but earlier than the assignment after it
	 * @param hmwk The assignment being added to the ArrayList
	 */
	private void orderHomework(Homework hmwk) {
		if (assignments.size() == 0) {
			assignments.add(hmwk);
		} else {
			for(int i = 0; i < assignments.size(); i ++) {
				if (compareDueDate(hmwk, assignments.get(i))) {
					ArrayList<Homework> updateHmwk = new ArrayList<>();
					int index = i;
					for(int j = 0; j < index; j ++) {
						updateHmwk.add(assignments.get(j));
					}
					updateHmwk.add(hmwk);
					for (int j = index; j < assignments.size(); j ++) {
						updateHmwk.add(assignments.get(j));
					}
					assignments = updateHmwk;
					break;
				} else if (i == assignments.size()-1) {
					assignments.add(hmwk);
					break;
				}
			}
		}
	}
	
	/**
	 * Compares two homework assignments and determines which one is due earlier.
	 * @param hmwk1 The first homework assignment.
	 * @param hmwk2 The second homework assignment.
	 * @return earlier Returns true if hmwk1 is due earlier than hmwk2, returns false if hmwk1 is due later than hmwk2
	 */
	private boolean compareDueDate(Homework hmwk1, Homework hmwk2) {
		boolean earlier = false;
		
		// get year, month, and day that hmwk1 is due
		int year1 = hmwk1.getYear();
		int month1 = hmwk1.getMonth();
		int day1 = hmwk1.getDate();
		
		// get year, month, and day that hmwk2 is due
		int year2 = hmwk2.getYear();
		int month2 = hmwk2.getMonth();
		int day2 = hmwk2.getDate();
		
		if (year1 < year2) {
			// if hmwk1 year is less than hmwk2 year, hmwk1 is due before hmwk2
			earlier = true;
		} else if (year1 == year2) {
			if (month1 < month2) { 
				// if hmwk1 month is less than hmwk2 month, hmwk1 is due before hmwk2
				earlier = true;
			} else if (month1 == month2) { 
				// if hmwk1 month is the same as hmwk2 month, check date
				if (day1 <= day2) { 
					// if hmwk1 day is less than or equal to hmwk2 day, hwmk1 is due before hmwk2
					earlier = true;
				} else { 
					// if hmwk1 day is greater than hmwk2 day, hmwk1 is due after hmwk2
					earlier = false;
				}
			} else { 
				// if hmwk1 month is greater than hmwk2 month, hmwk1 is due after hmwk2
				earlier = false;
			}
		} else {
			// if hmwk1 year is greater than hmwk2 year, hmwk1 is due after hmwk2
			earlier = false;
		}
		
		// return the boolean
		return earlier;
	}
}
