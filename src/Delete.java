import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
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

public class Delete {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtsNo;
	private String sNo,Name;
	Connection con=null;
	PreparedStatement ps=null;
	/**
	 * Launch the application.
	 */
	public  void delete() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() throws ClassNotFoundException, SQLException {
		initialize();
		connectde();
	}

	private void connectde() throws ClassNotFoundException, SQLException {
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
		frame.setBounds(100, 100, 683, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Kovai Hospital");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(159, 28, 304, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(187, 173, 73, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(316, 172, 169, 27);
		frame.getContentPane().add(txtName);
		
		JLabel lblNewLabel_3_2 = new JLabel("sNo");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(172, 246, 98, 24);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		txtsNo = new JTextField();
		txtsNo.setColumns(10);
		txtsNo.setBounds(316, 247, 169, 27);
		frame.getContentPane().add(txtsNo);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connectde();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Name=txtName.getText();
				sNo=txtsNo.getText();
try {
					
					String sql="delete from kovai where sNo=?";
					ps=con.prepareStatement(sql);
					
					ps.setString(1, sNo);
					
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Deleted successfully!!!");
				txtName.setText(" ");
				txtsNo.setText(" ");
			}
		
			
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(244, 375, 177, 41);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Down img\\reg img.jpg"));
		lblNewLabel_2.setBounds(0, 0, 667, 458);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
