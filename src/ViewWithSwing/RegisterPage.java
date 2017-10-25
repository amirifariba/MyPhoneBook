package ViewWithSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameTextField;
	private JPasswordField passwordTextField;
	private JPasswordField RetypepasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UserNameLabel = new JLabel(" UserName ");
		UserNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UserNameLabel.setBounds(53, 24, 90, 27);
		contentPane.add(UserNameLabel);
		
		UserNameTextField = new JTextField();
		UserNameTextField.setBounds(165, 24, 129, 30);
		contentPane.add(UserNameTextField);
		UserNameTextField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel(" Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordLabel.setBounds(53, 65, 90, 27);
		contentPane.add(PasswordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(165, 65, 129, 30);
		contentPane.add(passwordTextField);
		
		RetypepasswordField = new JPasswordField();
		RetypepasswordField.setBounds(165, 106, 129, 30);
		contentPane.add(RetypepasswordField);
		
		JLabel RetypePasswordLabel = new JLabel("Retype Password");
		RetypePasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RetypePasswordLabel.setBounds(53, 106, 114, 27);
		contentPane.add(RetypePasswordLabel);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RegisterButton.setBounds(165, 174, 129, 39);
		contentPane.add(RegisterButton);
	}
}
