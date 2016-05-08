import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Tour extends JFrame{
String bname = null;
//	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Tour window = new Tour();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public Tour(String string) {
		Procedures temp = new Procedures();
		ResultSet t = temp.tour_information(string);
		String time = null;
		String place = null;
		try {
			while(t!= null && t.next()){
//				System.out.println(rs.getString("Name"));
				time = t.getString("Time");
				place = t.getString("Place");
				bname = t.getString("bname");
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		initialize(string, time, place);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String time, String place) {
//		frame = new JFrame();
		
		this.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton btnNewButton_1 = new JButton("Search Again");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchAlbum window = new SearchAlbum();
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(243, 198, 101, 36);
		this.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(75, 49, 54, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(75, 96, 54, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Place:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(75, 144, 54, 15);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(name);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(161, 49, 171, 15);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(time);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(161, 96, 171, 15);
		this.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(place);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(161, 144, 171, 15);
		this.getContentPane().add(lblNewLabel_5);
		
		JButton btnViewBand = new JButton("View Band");
		btnViewBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Band window = new Band(bname);
				window.setVisible(true);
				dispose();
			}
		});
		btnViewBand.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnViewBand.setBounds(95, 198, 101, 36);
		getContentPane().add(btnViewBand);
	}

}
