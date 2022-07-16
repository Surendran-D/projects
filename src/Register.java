import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class Register {

	private JFrame frame;
	
	Connection con=null;
	PreparedStatement ps=null;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() throws ClassNotFoundException, SQLException  {
		initialize();
	   
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
			
			
		});
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 756, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kovai Hospital");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(218, 33, 257, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					Newregister1	reg = new Newregister1(); // new registration
					reg.Registrer();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(64, 158, 123, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Update	upd = new Update(); //update data
					upd.Update();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(281, 158, 123, 32);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete de;
				try {
					de = new Delete();
					de.delete();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(499, 158, 123, 32);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Down img\\entry img3.jpg"));
		lblNewLabel_1.setBounds(0, 0, 740, 453);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
