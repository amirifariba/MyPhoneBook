package ViewWithSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entities.ContactEntity;
import RestClient.ContactClient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertContact extends JFrame {

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
					InsertContact frame = new InsertContact();
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
	public InsertContact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 209);
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
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactEntity contact = new ContactEntity(NameTextField.getText(), LastNameTextField.getText(),
						HomeNumberTextField.getText(), MobileNumberTextField.getText(), EmailTextField.getText());
				IOManger io=IOManger.getInstance();
				ContactClient contactClient=new ContactClient(io.getIp(),io.getUser(),io.getPass());
				boolean flag=contactClient.Save(contact);
				if(flag==true)
				{
					JOptionPane.showMessageDialog(null, "contact added successfuly");
				}
				else if(flag==false){
					JOptionPane.showMessageDialog(null, "insert was unsucceful");
				}
			}
		});
		InsertButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		InsertButton.setBounds(371, 81, 155, 33);
		contentPane.add(InsertButton);

		JLabel LastNameLabel = new JLabel(" LastName");
		LastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LastNameLabel.setBounds(272, 10, 73, 22);
		contentPane.add(LastNameLabel);

		LastNameTextField = new JTextField();
		LastNameTextField.setColumns(10);
		LastNameTextField.setBounds(371, 11, 155, 25);
		contentPane.add(LastNameTextField);

		JLabel MobileLabel = new JLabel(" Mobile Number");
		MobileLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MobileLabel.setBounds(272, 43, 101, 24);
		contentPane.add(MobileLabel);

		MobileNumberTextField = new JTextField();
		MobileNumberTextField.setColumns(10);
		MobileNumberTextField.setBounds(371, 44, 155, 26);
		contentPane.add(MobileNumberTextField);

		JLabel HomeNumberLabel = new JLabel(" Home Number");
		HomeNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		HomeNumberLabel.setBounds(0, 44, 101, 24);
		contentPane.add(HomeNumberLabel);

		HomeNumberTextField = new JTextField();
		HomeNumberTextField.setColumns(10);
		HomeNumberTextField.setBounds(99, 46, 155, 26);
		contentPane.add(HomeNumberTextField);

		JLabel EmailLabel = new JLabel(" Email Address");
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		EmailLabel.setBounds(0, 79, 101, 24);
		contentPane.add(EmailLabel);

		EmailTextField = new JTextField();
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(99, 80, 155, 26);
		contentPane.add(EmailTextField);
		
		JButton btnNewButton = new JButton("List of Contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContactPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(109, 117, 145, 43);
		contentPane.add(btnNewButton);
	}

}
