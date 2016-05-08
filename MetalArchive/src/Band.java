import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;


public class Band extends JFrame{
	DefaultListModel model1 = new DefaultListModel();
	DefaultListModel model2 = new DefaultListModel();
	DefaultListModel model3 = new DefaultListModel();
	JList tourL = new JList(model1);
	JList memL = new JList(model2);
	JList albumL = new JList(model3);
//	private JFrame frame;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Band window = new Band();
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
	public Band(String string) {
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		Procedures temp = new Procedures();
		ResultSet t = temp.Detail(string, "Band");
		String country = null;
		String time = null;
		try {
			while(t!= null && t.next()){
//				System.out.println(rs.getString("Name"));
				country = t.getString("Country");
				time = t.getString("Founded");
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		initialize(string, country, time);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String country, String founded) {

//		JList resultList = new JList(model1);
//		frame = new JFrame();
		this.setBounds(100, 100, 721, 469);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(88, 53, 44, 25);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCountry.setBounds(68, 87, 54, 25);
		this.getContentPane().add(lblCountry);
		
		JLabel lblDateFounded = new JLabel("Date Founded");
		lblDateFounded.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDateFounded.setBounds(36, 122, 86, 26);
		this.getContentPane().add(lblDateFounded);
		
		JLabel lblTour = new JLabel("Tour");
		lblTour.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTour.setBounds(81, 179, 31, 15);
		this.getContentPane().add(lblTour);
		
		
		Procedures a1 = new Procedures();
		ResultSet rs1 = a1.Relation(name,"Band", "Tour" );
		try {
			while(rs1!= null && rs1.next()){
				model1.addElement(rs1.getString("Name"));
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		tourL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JScrollPane pane1 = new JScrollPane(tourL);
		pane1.setBounds(124, 178, 195, 138);
		this.getContentPane().add(pane1);
		
		JLabel lblMember = new JLabel("Member");
		lblMember.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMember.setBounds(329, 179, 50, 15);
		this.getContentPane().add(lblMember);
		
		
		Procedures a2 = new Procedures();
		ResultSet rs2 = a1.Relation(name, "Band", "Member" );
		try {
			while(rs2!= null && rs2.next()){
				model2.addElement(rs2.getString("Name"));
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		memL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JScrollPane pane2 = new JScrollPane(memL);
		pane2.setBounds(389, 178, 99, 138);
		this.getContentPane().add(pane2);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAlbum.setBounds(498, 179, 43, 15);
		this.getContentPane().add(lblAlbum);
		
		
		Procedures a3 = new Procedures();
		ResultSet rs3 = a1.Relation(name, "Band", "Album" );
		try {
			while(rs3!= null && rs3.next()){
				model3.addElement(rs3.getString("Name"));
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		albumL.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JScrollPane pane3 = new JScrollPane(albumL);
		pane3.setBounds(551, 178, 99, 138);
		this.getContentPane().add(pane3);
		
		JButton btnNewButton = new JButton("View Tour");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tour window = new Tour(tourL.getSelectedValue().toString());
				window.setVisible(true);
			}
		});
		btnNewButton.setBounds(174, 326, 93, 23);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Member");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member window = new Member(memL.getSelectedValue().toString());
				window.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(389, 326, 99, 23);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Album");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Album window = new Album(albumL.getSelectedValue().toString());
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(551, 327, 99, 23);
		this.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search Again");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchAlbum window = new SearchAlbum();
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(318, 369, 122, 36);
		this.getContentPane().add(btnNewButton_3);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		nameLabel.setBounds(142, 58, 168, 15);
		getContentPane().add(nameLabel);
		
		JLabel countryLabel = new JLabel(country);
		countryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		countryLabel.setBounds(142, 92, 168, 15);
		getContentPane().add(countryLabel);
		
		JLabel dateLabel = new JLabel(founded);
		dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		dateLabel.setBounds(142, 128, 168, 15);
		getContentPane().add(dateLabel);
	}
}
