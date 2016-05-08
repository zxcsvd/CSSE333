import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LikeList extends JFrame{

	private JFrame frame;
	DefaultListModel model = new DefaultListModel();
	JList resultList = new JList(model);
	ResultSet rs = null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LikeList window = new LikeList();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public LikeList() {
		Procedures temp = new Procedures();
		LoginInfo tem = new LoginInfo();
		rs =temp.fav(tem.userInfo());
		try {
			while(rs!= null && rs.next()){
//				System.out.println(rs.getString("Name"));
				model.addElement(rs.getString(1));
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 400, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		resultList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JScrollPane pane = new JScrollPane(resultList);
//		resultList.setBounds(69, 74, 210, 316);
		pane.setBounds(69, 74, 210, 316);
//		add(resultList);
//		add(pane);
		this.getContentPane().add(pane);
		
		JLabel lblLike = new JLabel("Like:");
		lblLike.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLike.setBounds(49, 54, 54, 15);
		this.getContentPane().add(lblLike);
		
		JButton button = new JButton("View");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(resultList.getSelectedValue() != null){
					Songs window = new Songs(resultList.getSelectedValue().toString());
					window.setVisible(true);
					dispose();
				}
				else{
					System.out.println("Please select one to view");
				}
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button.setBounds(49, 434, 85, 41);
		this.getContentPane().add(button);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Procedures temp = new Procedures();
				System.out.println(resultList.getSelectedValue());
				System.out.println(temp.del((String) resultList.getSelectedValue()));
				model.removeElement(resultList.getSelectedValue());
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDelete.setBounds(144, 434, 85, 41);
		this.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchAlbum window = new SearchAlbum();
				window.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnBack.setBounds(239, 434, 85, 41);
		this.getContentPane().add(btnBack);
	}
}
