package ViewWithSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;

public class ContactPage extends JFrame {

	private JPanel contentPane;
	private JTextField NameTextField;
	private JTextField LastNameTextField;
	private JTextField MobileNumberTextField;
	private JTextField HomeNumberTextField;
	private JTextField EmailTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactPage frame = new ContactPage();
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
	public ContactPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ContactNameLabel = new JLabel(" Name");
		ContactNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ContactNameLabel.setBounds(0, 10, 46, 23);
		contentPane.add(ContactNameLabel);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(99, 10, 155, 26);
		contentPane.add(NameTextField);
		NameTextField.setColumns(10);
		
		JButton InsertButton = new JButton("Insert");
		InsertButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		InsertButton.setBounds(327, 78, 155, 33);
		contentPane.add(InsertButton);
		
		JLabel label = new JLabel(" LastName");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(272, 10, 73, 22);
		contentPane.add(label);
		
		LastNameTextField = new JTextField();
		LastNameTextField.setColumns(10);
		LastNameTextField.setBounds(371, 11, 155, 25);
		contentPane.add(LastNameTextField);
		
		JLabel label_1 = new JLabel(" Mobile Number");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(272, 43, 101, 24);
		contentPane.add(label_1);
		
		MobileNumberTextField = new JTextField();
		MobileNumberTextField.setColumns(10);
		MobileNumberTextField.setBounds(371, 44, 155, 26);
		contentPane.add(MobileNumberTextField);
		
		JLabel label_2 = new JLabel(" Home Number");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(0, 44, 101, 24);
		contentPane.add(label_2);
		
		HomeNumberTextField = new JTextField();
		HomeNumberTextField.setColumns(10);
		HomeNumberTextField.setBounds(99, 46, 155, 26);
		contentPane.add(HomeNumberTextField);
		
		JLabel label_3 = new JLabel(" Email Address");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(0, 79, 101, 24);
		contentPane.add(label_3);
		
		EmailTextField = new JTextField();
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(99, 80, 155, 26);
		contentPane.add(EmailTextField);
	}
}
