import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI to remove a homework assignment
 * @author Aaron Wang
 */
public class RemoveHomework extends JFrame {

	// declare instance variables
	private JPanel contentPane;
	private JComboBox listHmwk;
	private JLabel lblAssignments;
	private String[] hmwkNames;
	
	/**
	 * Create the frame.
	 */
	public RemoveHomework() {
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
		
		// create JComboBox with list of assignment names
		JComboBox listHmwk = new JComboBox(hmwkNames);
		listHmwk.setBounds(25, 60, 150, 25);
		contentPane.add(listHmwk);
		
		// create JButton to remove assignment
		JButton removeHmwk = new JButton("Remove Assignment");
		removeHmwk.setBounds(30, 200, 200, 25);
		contentPane.add(removeHmwk);
	}
}
