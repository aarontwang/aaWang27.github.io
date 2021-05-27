import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

import java.lang.Integer;


public class Calculator {
	
	// create the JFrame
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// initialize JFrame
		frame = new JFrame();
		frame.setBounds(100, 100, 330, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		double[] input1 = {0};
		String[] insert = {""};
		double[] input2 = {0};
		boolean[] left = {true};
		String[] op = {""};
		frame.getContentPane().setLayout(null);
		
		// initialize title of application
		JLabel calculator = new JLabel("Calculator");
		calculator.setHorizontalAlignment(SwingConstants.CENTER);
		calculator.setBounds(50, 15, 230, 25);
		calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(calculator);
		
		// initialize display
		JLabel display = new JLabel("0");
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setBounds(50, 51, 230, 14);
		display.setBackground(Color.WHITE);
		frame.getContentPane().add(display);
		
		
		// one button
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		one.setBounds(50, 70, 50, 25);
		one.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("1");
				} else {
					display.setText(display.getText() + "1");
				}
			}
		});
		frame.getContentPane().add(one);
		
		// two button
		JButton two = new JButton("2");
		two.setBounds(110, 70, 50, 25);
		two.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("2");
				} else {
					display.setText(display.getText() + "2");
				}
			}
		});
		frame.getContentPane().add(two);
		
		// three button
		JButton three = new JButton("3");
		three.setBounds(170, 70, 50, 25);
		three.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("3");
				} else {
					display.setText(display.getText() + "3");
				}
			}
		});
		frame.getContentPane().add(three);
		
		// four button
		JButton four = new JButton("4");
		four.setBounds(50, 100, 50, 25);
		four.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("4");
				} else {
					display.setText(display.getText() + "4");
				}
			}
		});
		frame.getContentPane().add(four);
		
		// five button
		JButton five = new JButton("5");
		five.setBounds(110, 100, 50, 25);
		five.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("5");
				} else {
					display.setText(display.getText() + "5");
				}
			}
		});
		frame.getContentPane().add(five);
		
		// six button
		JButton six = new JButton("6");
		six.setBounds(170, 100, 50, 25);
		six.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("6");
				} else {
					display.setText(display.getText() + "6");
				}
			}
		});
		frame.getContentPane().add(six);
		
		// seven button
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		seven.setBounds(50, 130, 50, 25);
		seven.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("7");
				} else {
					display.setText(display.getText() + "7");
				}
			}
		});
		frame.getContentPane().add(seven);
		
		// eight button
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		eight.setBounds(110, 130, 50, 25);
		eight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("8");
				} else {
					display.setText(display.getText() + "8");
				}
			}
		});
		frame.getContentPane().add(eight);
		
		// nine button
		JButton nine = new JButton("9");
		nine.setBounds(170, 130, 50, 25);
		nine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("9");
				} else {
					display.setText(display.getText() + "9");
				}
			}
		});
		frame.getContentPane().add(nine);
		
		// zero button
		JButton zero = new JButton("0");
		zero.setBounds(110, 160, 50, 25);
		zero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (display.getText().equals("0")) {
					display.setText("0");
				} else {
					display.setText(display.getText() + "0");
				}
			}
		});
		frame.getContentPane().add(zero);
		
		// addition button
		JButton add = new JButton("+");
		add.setBounds(230, 70, 50, 25);
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (left[0]) {
					op[0] = "add";
					input1[0] = Double.parseDouble(display.getText());
					left[0] = false;
					display.setText("0");
				} 
			}
		});
		frame.getContentPane().add(add);
		
		// subtraction button
		JButton subtract = new JButton("-");
		subtract.setBounds(230, 100, 50, 25);
		subtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (left[0]) {
					op[0] = "subtract";
					input1[0] = Double.parseDouble(display.getText());
					left[0] = false;
					display.setText("0");
				} 
			}
		});
		frame.getContentPane().add(subtract);
		
		// multiplication button
		JButton multiply = new JButton("x");
		multiply.setBounds(230, 130, 50, 25);
		multiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (left[0]) {
					op[0] = "multiply";
					input1[0] = Double.parseDouble(display.getText());
					left[0] = false;
					display.setText("0");
				} 
			}
		});
		frame.getContentPane().add(multiply);
		
		// division button
		JButton divide = new JButton("/");
		divide.setBounds(230, 160, 50, 25);
		divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (left[0]) {
					op[0] = "divide";
					input1[0] = Double.parseDouble(display.getText());
					left[0] = false;
					display.setText("0");
				} 
			}
		});
		frame.getContentPane().add(divide);
		
		// enter/equals button
		JButton enter = new JButton("=");
		enter.setBounds(50, 190, 50, 25);
		enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (left[0] == true) {
					display.setText(display.getText());
				} else if (left[0] == false) {
					input2[0] = Double.parseDouble(display.getText());
					double[] result = {0};
					
					if (op[0].equals("add")) {
						result[0] = input1[0] + input2[0];
					} else if (op[0].equals("subtract")) {
						result[0] = input1[0] - input2[0];
					} else if (op[0].equals("multiply")) {
						result[0] = input1[0] * input2[0];
					} else if (!(input2[0] == 0) && op[0].equals("divide")) {
						result[0] = input1[0]/input2[0];
					}
					
					display.setText(Double.toString(result[0]));

					left[0] = true;
					input1[0] = result[0];
					input2[0] = 0;
					result[0] = 0;
				}
			}
		});
		frame.getContentPane().add(enter);
		
		// delete button
		JButton delete = new JButton("C");
		delete.setBounds(170, 160, 50, 25);
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				left[0] = true;
				op[0] = "";
				input1[0] = 0;
				input2[0] = 0;
				display.setText("0");
			}
		});
		frame.getContentPane().add(delete);
		
		// decimal point button
		JButton decimal = new JButton(".");
		decimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!display.getText().contains(".")) {
					display.setText(display.getText()+".");
				}
			}
		});
		decimal.setBounds(50, 160, 50, 25);
		frame.getContentPane().add(decimal);
	}

}
