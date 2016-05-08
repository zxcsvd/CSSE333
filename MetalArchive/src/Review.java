import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Review extends JFrame{

//	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Review window = new Review();
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
	public Review(String string) {
		Procedures temp = new Procedures();
		ResultSet t = temp.comment(string);
		String Username = null;
		String Score = null;
		String Content = null;
		String aname = null;
		try {
			while(t!= null && t.next()){
//				System.out.println(rs.getString("Name"));
				Username = t.getString("name");
				Score = t.getString("Score");
				Content = t.getString("Content");
				aname = t.getString("Name");
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		initialize(string, Username, Score,Content,aname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String string,String Username,String Score,String Content,final String aname) {
//		frame = new JFrame();
		
		this.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.setBounds(100, 100, 453, 428);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("By");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(74, 51, 54, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Score");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(74, 94, 54, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Content");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(74, 139, 54, 15);
		this.getContentPane().add(lblNewLabel_2);
		
		JTextArea comment = new JTextArea();
		comment.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JScrollPane pane = new JScrollPane(comment);
		pane.setBounds(138, 139, 225, 176);
		comment.setLineWrap(true);
		comment.setWrapStyleWord(true);
		comment.setEditable(false); 
		comment.setText(string);
		this.getContentPane().add(pane);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Album window = new Album(aname);
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(173, 334, 98, 32);
		this.getContentPane().add(btnNewButton);
		
		JLabel byWho = new JLabel(Username);
		byWho.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		byWho.setBounds(138, 50, 155, 15);
		this.getContentPane().add(byWho);
		
		JLabel score = new JLabel(Score);
		score.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		score.setBounds(138, 93, 155, 15);
		this.getContentPane().add(score);
	}

}
