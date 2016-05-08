import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JList;


public class Member extends JFrame{
	DefaultListModel model1 = new DefaultListModel();
	JList list = new JList(model1);
	String bname = null;
//	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Member window = new Member();
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
	public Member(String string) {
		Procedures temp = new Procedures();
		ResultSet t = temp.Detail(string, "Member");
		String position = null;
		try {
			while(t!= null && t.next()){
//				System.out.println(rs.getString("Name"));
				position = t.getString("Position");
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		initialize(string, position);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name, String position) {
//		frame = new JFrame();
		this.setBounds(100, 100, 400, 394);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(43, 58, 54, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Position:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(43, 108, 54, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		JButton bkButton = new JButton("Searcch Again");
		bkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchAlbum window = new SearchAlbum();
				window.setVisible(true);
				dispose();
			}
		});
		bkButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bkButton.setBounds(252, 302, 106, 34);
		this.getContentPane().add(bkButton);
		

		
		JLabel nameLabel2 = new JLabel(name);
		nameLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		nameLabel2.setBounds(127, 58, 160, 15);
		this.getContentPane().add(nameLabel2);
		
		JLabel lblNewLabel_3 = new JLabel(position);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(127, 108, 160, 15);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAlbum.setBounds(43, 157, 50, 15);
		getContentPane().add(lblAlbum);
		
		Procedures a1 = new Procedures();
		ResultSet rs1 = a1.member_information(name);
		try {
			while(rs1!= null && rs1.next()){
				model1.addElement(rs1.getString("aname"));
				bname = rs1.getString("bname");
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		list.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(127, 156, 176, 122);
		getContentPane().add(pane);
		
		JButton btnViewAlbum = new JButton("View Album");
		btnViewAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (list.getSelectedValue()!=null){
					Album window = new Album(list.getSelectedValue().toString());
					window.setVisible(true);
					dispose();
					
				}}
		});
		btnViewAlbum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnViewAlbum.setBounds(20, 302, 106, 34);
		getContentPane().add(btnViewAlbum);
		
		JButton btnViewBand = new JButton("View Band");
		btnViewBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Band window = new Band(bname);
				window.setVisible(true);
				dispose();
			}
		});
		btnViewBand.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnViewBand.setBounds(136, 301, 106, 36);
		getContentPane().add(btnViewBand);
	}
}
