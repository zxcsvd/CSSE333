import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Album extends JFrame{
	DefaultListModel model1 = new DefaultListModel();
	DefaultListModel model2 = new DefaultListModel();
	JList list_1 = new JList(model1);
	JList list_2 = new JList(model2);
	String aid = null;
	String bname = null;
//	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Album window = new Album();
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
	public Album(String string) {
		Procedures temp = new Procedures();
		ResultSet t = temp.album_information(string);
		String genre = null;
		String release = null;
		
		try {
			while(t!= null && t.next()){
//				System.out.println(rs.getString("Name"));
				aid = t.getString("Aid");
				genre = t.getString("Genre");
				release = t.getString("Release");
				bname = t.getString("bname");
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		//System.out.println(aid);
		initialize(string, genre, release);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String name, String genre, String release) {
//		frame = new JFrame();
		this.setBounds(100, 100, 670, 427);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null); 
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(38, 24, 83, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Genre");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 74, 83, 23);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Release Date");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(38, 107, 83, 15);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblBand = new JLabel("Band");
		lblBand.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBand.setBounds(38, 49, 31, 15);
		this.getContentPane().add(lblBand);
		
		JLabel lblSongs = new JLabel("Songs");
		lblSongs.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSongs.setBounds(38, 147, 50, 15);
		this.getContentPane().add(lblSongs);
		
		Procedures a1 = new Procedures();
		ResultSet rs1 = a1.Relation(name,"Album", "Songs" );
		try {
			while(rs1!= null && rs1.next()){
				model1.addElement(rs1.getString("Name"));
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		//Similar to Band class, need to add details into the list 
		list_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JScrollPane pane1 = new JScrollPane(list_1);
		pane1.setBounds(90, 145, 200, 138);
		this.getContentPane().add(pane1);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblReview.setBounds(300, 147, 56, 15);
		this.getContentPane().add(lblReview);
		
		
		Procedures a2 = new Procedures();
		ResultSet rs2 = a2.get_comment(name,"Album", "Review" );
		try {
			while(rs2!= null && rs2.next()){
				model2.addElement(rs2.getString("Content"));
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		//Similar to Band class, need to add details into the list 
		list_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JScrollPane pane2 = new JScrollPane(list_2);
		pane2.setBounds(365, 146, 201, 138);
		this.getContentPane().add(pane2);
		
		JButton btnViewBand = new JButton("View Band");
		btnViewBand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Band window = new Band(bname);
				window.setVisible(true);
				dispose();
				
			}
		});
		btnViewBand.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnViewBand.setBounds(90, 326, 121, 36);
		this.getContentPane().add(btnViewBand);
		
		JButton btnViewSong = new JButton("View Song");
		btnViewSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_1.getSelectedValue()!=null){
				Songs window = new Songs(list_1.getSelectedValue().toString());
				window.setVisible(true);
				dispose();
				
			}}
		});
		btnViewSong.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnViewSong.setBounds(131, 293, 106, 23);
		this.getContentPane().add(btnViewSong);
		
		JButton btnViewReview = new JButton("View Review");
		btnViewReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_2.getSelectedValue()!=null){
				Review window = new Review(list_2.getSelectedValue().toString());
				window.setVisible(true);
				dispose();
				}
			}
		});
		btnViewReview.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnViewReview.setBounds(412, 294, 106, 23);
		this.getContentPane().add(btnViewReview);
		
		JButton btnSearchAgain = new JButton("Search Again");
		btnSearchAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchAlbum window = new SearchAlbum();
				window.setVisible(true);
				dispose();
			}
		});
		btnSearchAgain.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearchAgain.setBounds(434, 327, 135, 36);
		this.getContentPane().add(btnSearchAgain);
		
		JButton btnGiveComment = new JButton("Give Comment");
		btnGiveComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginInfo.userType().equals("1") || LoginInfo.userType().equals("0")){
					System.out.println("new user cannot give a comment");
				}else{
				LoginInfo tem = new LoginInfo();
				//System.out.println(tem.userInfo());
				Comment window = new Comment(aid,tem.userInfo(),name);
				window.setVisible(true);
				dispose();}
			}
		});
		btnGiveComment.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnGiveComment.setBounds(251, 327, 146, 36);
		this.getContentPane().add(btnGiveComment);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		nameLabel.setBounds(119, 24, 436, 15);
		this.getContentPane().add(nameLabel);
		
		JLabel bandLabel = new JLabel(bname);
		bandLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		bandLabel.setBounds(119, 49, 436, 15);
		this.getContentPane().add(bandLabel);
		
		JLabel gebreLabel = new JLabel(genre);
		gebreLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		gebreLabel.setBounds(119, 82, 436, 15);
		this.getContentPane().add(gebreLabel);
		
		JLabel releaseLabel = new JLabel(release);
		releaseLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		releaseLabel.setBounds(119, 107, 436, 15);
		getContentPane().add(releaseLabel);
		
		JButton btnNewButton = new JButton("D");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Procedures temp = new Procedures();
				temp.del_com(list_2.getSelectedValue().toString());
				String t = list_2.getSelectedValue().toString();
				for(int i= 0; i< model2.size() ; i++){
//					System.out.println(model2.size() + " " + model2.get(i).toString());
					
					if (model2.get(i).toString().equals(t)){
						model2.removeElement(model2.get(i));
						i--;
					}
					
				}
				
			}
		});
		btnNewButton.setBounds(576, 143, 56, 140);
//		if(Integer.parseInt(LoginInfo.userType()) == 3){
			getContentPane().add(btnNewButton);
//		}
		
	}
}
