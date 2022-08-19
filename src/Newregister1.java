import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Newregister1 {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtaddress;
	private JTextField txtmob;
	private String Name,Address,mobileno;
	Connection con=null;
	PreparedStatement ps=null;

	/**
	 * Launch the application.
	 */
	public void Registrer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newregister1 window = new Newregister1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Newregister1() throws ClassNotFoundException, SQLException {
		initialize();
		connect();
	}

	private void connect() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(con!=null)
			System.out.println("connected !!!!!");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Kovai Hospital");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(182, 31, 304, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(234, 104, 73, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(214, 174, 93, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MobileNo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(225, 246, 98, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setBounds(408, 103, 169, 27);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(409, 164, 168, 27);
		frame.getContentPane().add(txtaddress);
		txtaddress.setColumns(10);
		
		txtmob = new JTextField();
		txtmob.setBounds(408, 243, 169, 27);
		frame.getContentPane().add(txtmob);
		txtmob.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				try {
					connect();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
					Name=txtName.getText();
					Address=txtaddress.getText();
					mobileno=txtmob.getText();
					try {
						
						String sql="insert into kovai (Name,Address,mobileno) values (?,?,?)";
						ps=con.prepareStatement(sql);
						ps.setString(1, Name);
						ps.setString(2, Address);
						ps.setString(3, mobileno);
						ps.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				JOptionPane.showMessageDialog(null, "Registerd successfully!!!");
				txtName.setText(" ");
				txtaddress.setText(" ");
				txtmob.setText(" ");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(182, 346, 177, 41);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Down img\\reg12.jpg"));
		lblNewLabel_4.setBounds(0, 0, 623, 410);
		frame.getContentPane().add(lblNewLabel_4);
		
		JList list = new JList();
		list.setBounds(44, 31, 128, 124);
		frame.getContentPane().add(list);
	}
}
