import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSlider;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class TempConverter {

	private JFrame frame;
	private JTextField tempTextField;
	private JSlider celsiusSlider;
	private JLabel celsiusSliderLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempConverter window = new TempConverter();
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
	public TempConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tempTextField = new JTextField();
		tempTextField.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(tempTextField);
		tempTextField.setColumns(10);
		
		JLabel celsiusLabel = new JLabel("Celsius");
		celsiusLabel.setBounds(106, 17, 103, 14);
		frame.getContentPane().add(celsiusLabel);
		
		JLabel fahrenheitLabel = new JLabel("Fahrenheit");
		fahrenheitLabel.setBounds(106, 64, 103, 14);
		frame.getContentPane().add(fahrenheitLabel);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tempFahr = (int) ((Double.parseDouble(tempTextField.getText())) * 1.8 + 32);
				fahrenheitLabel.setText(tempFahr + " Fahrenheit");
			}
		});
		convertButton.setBounds(10, 60, 89, 23);
		frame.getContentPane().add(convertButton);
		
		celsiusSlider = new JSlider();
		celsiusSlider.setValue(0);
		celsiusSlider.setAlignmentX(Component.RIGHT_ALIGNMENT);
		celsiusSlider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int cels = celsiusSlider.getValue();
				int tempFahr = (int) (cels * 1.8 + 32);
				fahrenheitLabel.setText(tempFahr + " Fahrenheit");
				celsiusLabel.setText(cels + " Celsius");
			}
		});
		celsiusSlider.setPaintLabels(true);
		celsiusSlider.setPreferredSize(new Dimension(300, 23));
		celsiusSlider.setPaintTicks(true);
		celsiusSlider.setMajorTickSpacing(10);
		celsiusSlider.setMinorTickSpacing(5);
		celsiusSlider.setBounds(220, 11, 262, 42);
		frame.getContentPane().add(celsiusSlider);
		
		celsiusSliderLabel = new JLabel("Degrees Celsius");
		celsiusSliderLabel.setBounds(485, 14, 99, 14);
		frame.getContentPane().add(celsiusSliderLabel);
		
		tempTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					if(!tempTextField.getText().isEmpty()) {
						int tempFahr = (int) ((Double.parseDouble(tempTextField.getText())) * 1.8 + 32);
						fahrenheitLabel.setText(tempFahr + " Fahrenheit");
					}
				}
			}
		});
		
	}
}