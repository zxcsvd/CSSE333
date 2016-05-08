import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JTextArea;


public class Comment extends JFrame{

//	private JFrame frame;
	private JTextField score;
	JTextArea commentArea = new JTextArea();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Comment window = new Comment();
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
	public Comment(String aid,String uid,String aname) {
		initialize(aid,uid,aname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String aid,final String uid,final String aname) {
//		frame = new JFrame();
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Score:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(66, 66, 54, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Comment:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(66, 122, 54, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		score = new JTextField();
		score.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		score.setBounds(141, 58, 76, 31);
		this.getContentPane().add(score);
		score.setColumns(10);
		
		JScrollPane pane = new JScrollPane(commentArea);
		pane.setBounds(139, 122, 247, 223);
		commentArea.setLineWrap(true);
		commentArea.setWrapStyleWord(true);
		getContentPane().add(pane);
		
		JButton btnNewButton = new JButton("Submit Comment");
		btnNewButton.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				if (!isNumeric(score.getText())){
					System.out.println("Invalid score");
				}
				else if (Integer.parseInt(score.getText())>100|| Integer.parseInt(score.getText())<0){
					System.out.println("Invalid score");
				}
				else{
				
				Procedures tem = new Procedures();
				tem.g_comment(score.getText(), commentArea.getText(), aid, uid);
				Album window = new Album(aname);
				window.setVisible(true);
				dispose();}
				//Give comment, need to write procedure
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(103, 373, 130, 38);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Album window = new Album(aname);
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(300, 373, 130, 38);
		this.getContentPane().add(btnNewButton_1);
		
		
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
