package ViewWithSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import RestClient.UserClient;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField IPAddressTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userNamLabel = new JLabel(" UserName");
		userNamLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNamLabel.setBounds(103, 56, 74, 30);
		contentPane.add(userNamLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(187, 58, 128, 30);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel(" Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(103, 97, 74, 30);
		contentPane.add(passwordLabel);
		
		IPAddressTextField = new JTextField();
		IPAddressTextField.setColumns(10);
		IPAddressTextField.setBounds(187, 142, 128, 30);
		contentPane.add(IPAddressTextField);
		
		JLabel IPAddressLabel = new JLabel(" IP Address");
		IPAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IPAddressLabel.setBounds(103, 140, 74, 30);
		contentPane.add(IPAddressLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 99, 128, 28);
		contentPane.add(passwordField);
		
		JButton signInButton = new JButton("sign in");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserClient user=new UserClient(	IPAddressTextField.getText(),userNameTextField.getText(),passwordField.getText());
				String roleName=user.validateUser();
				if(roleName.equals("guest"))
				{
					JOptionPane.showMessageDialog(null, "user or pass is not valid");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "welcome");
					new InsertContact().setVisible(true);
					dispose();
			IOManger.getInstance().setUser(userNameTextField.getText());
			IOManger.getInstance().setPass(passwordField.getText());
			IOManger.getInstance().setIp(IPAddressTextField.getText());
				}	
			}
		});
		signInButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		signInButton.setBounds(191, 210, 89, 30);
		contentPane.add(signInButton);
	}
}
