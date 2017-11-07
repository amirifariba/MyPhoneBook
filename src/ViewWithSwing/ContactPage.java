package ViewWithSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import RestClient.ContactClient;

public class ContactPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 567, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		String[] column=new String[] { "Name", "Last name", "Mobile Number", "Home Number", "Email" };
		
		contentPane.setLayout(null);
		table.setModel(new DefaultTableModel(getData(),column) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(21, 359, 520, -192);
		table.setCellSelectionEnabled(true);
		//table.setVisible(true);
		//contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 541, 356);
		getContentPane().add(scrollPane);
		
	}
	public String[][] getData(){
		IOManger io=IOManger.getInstance();
		ContactClient contact=new ContactClient(io.getIp(),io.getUser(),io.getPass());
		String[][] data = new String[contact.selectAll().length][5];
		System.out.println(contact.selectAll()[1].getContactName());
		for (int i = 0; i < contact.selectAll().length; i++) {
			data[i][0] = contact.selectAll()[i].getContactName();
		
			data[i][1] = contact.selectAll()[i].getContactLastName();
			data[i][2] = contact.selectAll()[i].getPhoneNumber();
			data[i][3] = contact.selectAll()[i].getHomePhoneNumber();
			data[i][4] = contact.selectAll()[i].getEmail();
		}
		return data;
	}
}
