import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
/**
 * GUI to change the status of a homework assignment
 * @author Aaron Wang
 */
public class ChangeStatus extends JFrame {

	private JPanel contentPane;
	private String[] statuses = {"Incomplete", "Complete", "Overdue"};
	/**
	 * Create the frame.
	 */
	public ChangeStatus() {
		
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
		
		// create a new JComboBox with the contents of homeworkNames
		JComboBox comboAssignment = new JComboBox();
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
		btnStatus.setBounds(25, 200, 125, 25);
		contentPane.add(btnStatus);
	}
}
