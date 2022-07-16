import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtaddress;
	private JTextField txtmob;
	private String Name,Address,mobileno,sNo;
	Connection con=null;
	PreparedStatement ps=null;
	private JTextField txtsNo;

	/**
	 * Launch the application.
	 */
	public  void Update() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
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
	public Update() throws ClassNotFoundException, SQLException {
		initialize();
		connectup();
	}

	private void connectup() throws ClassNotFoundException, SQLException {
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
		frame.setBounds(100, 100, 655, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Kovai Hospital");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(144, 38, 304, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(169, 135, 73, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(291, 134, 169, 27);
		frame.getContentPane().add(txtName);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(291, 196, 169, 27);
		frame.getContentPane().add(txtaddress);
		
		txtmob = new JTextField();
		txtmob.setColumns(10);
		txtmob.setBounds(291, 263, 169, 27);
		frame.getContentPane().add(txtmob);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(169, 199, 93, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MobileNo");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(169, 262, 98, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connectup();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Name=txtName.getText();
				Address=txtaddress.getText();
				mobileno=txtmob.getText();
				sNo=txtsNo.getText();
				try {
					
					String sql="update kovai set Name=?,Address=?,mobileno=? where sNo=?";
					ps=con.prepareStatement(sql);
					ps.setString(1, Name);
					ps.setString(2, Address);
					ps.setString(3, mobileno);
					ps.setString(4, sNo);
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "updated successfully!!!");
				txtName.setText(" ");
				txtaddress.setText(" ");
				txtmob.setText(" ");
				txtsNo.setText(" ");
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(235, 389, 177, 41);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_3_2 = new JLabel("sNo");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(164, 318, 98, 24);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		txtsNo = new JTextField();
		txtsNo.setColumns(10);
		txtsNo.setBounds(291, 322, 169, 27);
		frame.getContentPane().add(txtsNo);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Down img\\reg img.jpg"));
		lblNewLabel_4.setBounds(0, 0, 639, 458);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
