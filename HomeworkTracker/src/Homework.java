/**
 * stores the data for each homework assignment
 * @author Aaron Wang
 * @since 03-24-2021
 */
public class Homework {
	
	// create instance variables
	private String name;
	private String dueDate;
	private int date;
	private int month;
	private int year;
	private boolean complete;
	private boolean overdue;
	private String status;
	
	
	public Homework(String name, int month, int date, int year) {
		this.name = name;
		this.date = date;
		this.month = month;
		this.year = year;
		dueDate = month + "/" + date + "/" + year;
		complete = false;
		overdue = false;
		status = "Incomplete";
	}
	
	public Homework() {
		
	}
	
	/**
	 * Returns the name of the assignment
	 * @return Name of the assignment
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the status of the assignment
	 * @return Status of the assignment
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Returns the due date as a string
	 * @return Due date of the assignment in "MM/dd/yyyy" format
	 */
	public String getDueDate() {
		return dueDate;
	}
	
	/**
	 * Returns the day that the assignment is due
	 * @return Day the assignment is due
	 */
	public int getDate() {
		return date;
	}
	
	/**
	 * Returns the month that the assignment is due
	 * @return Month the assignment is due
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Returns the year that the assignment is due
	 * @return Year the assignment is due
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @return overdue whether or not the assignment is overdue
	 */
	public boolean overdue() {
		return overdue;
	}
	
	/**
	 * @return complete whether or not the assignment is complete
	 */
	public boolean complete() {
		return complete;
	}
	
	/**
	 * Changes the name of the assignment
	 * @param name
	 */
	public void changeName(String name) {
		this.name = name;
	}
	
	/**
	 * Changes the status of the assignment
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Changes the date of the due date
	 * @param date
	 */
	public void changeDate(int date) {
		this.date = date;
	}
	
	/**
	 * Changes the month of the due date
	 * @param month
	 */
	public void changeMonth(int month) {
		this.month = month;
	}
	
	/**
	 * Changes the year of the due date
	 * @param year
	 */
	public void changeYear(int year) {
		this.year = year;
	}
	
	/**
	 * completes the homework
	 */
	public void doHomework() {
		complete = true;
	}
	
	/**
	 * changes complete to false
	 */
	public void undoHomework() {
		complete = false;
	}
	
	/**
	 * changes if the assignment is overdue or not
	 * @param overdue
	 */
	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}
	
}
