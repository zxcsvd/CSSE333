import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JList;


public class SearchAlbum extends JFrame{
	DefaultListModel model = new DefaultListModel();
	JList list = new JList(model);
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SearchAlbum window = new SearchAlbum();
//					window.frmSearch.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SearchAlbum() {
		initialize();
	}
	public void readData(){
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void close(){
		this.setVisible(false);
	}
	
	private void initialize() {
//		frmSearch = new JFrame();
		this.setTitle("Search");
		this.setBounds(100, 100, 540, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(69, 86, 201, 32);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JScrollPane pane = new JScrollPane(list);
		model.addElement("Album");
		model.addElement("Songs");
		model.addElement("Band");
		model.addElement("Member");
		model.addElement("Tour");
		pane.setBounds(300, 86, 143, 180);
		this.getContentPane().add(pane);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = list.getSelectedValue();
				if(selected == null){
					System.out.println("Please select a type.");
				}else if(textField.getText().length() == 0){
					System.out.println("Please give a keyword.");
				}
				else{
						Result window = new Result(textField.getText(), selected.toString());
						window.setVisible(true);
						close();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(66, 147, 97, 55);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblKeyword = new JLabel("Keyword:");
		lblKeyword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblKeyword.setBounds(72, 54, 54, 15);
		this.getContentPane().add(lblKeyword);
		

		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblType.setBounds(300, 53, 54, 15);
		getContentPane().add(lblType);
		
		JButton btnFavorite = new JButton("Favorite");
		btnFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LikeList window = new LikeList();
				window.setVisible(true);
				dispose();
			}
		});
		btnFavorite.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnFavorite.setBounds(173, 147, 97, 55);
		getContentPane().add(btnFavorite);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginInfo.setInfo(null);
				LoginWindow temp = new LoginWindow();
				temp.setVisible(true);
				close();
				dispose();
			}
		});
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLogOut.setBounds(173, 212, 97, 55);
		getContentPane().add(btnLogOut);
		
		JButton btnRecommand = new JButton("Recommend");
		btnRecommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Procedures temp = new Procedures();
				String result = temp.recommend(LoginInfo.userInfo());
				if(result != ""){
					Songs window = new Songs(result);
					window.setVisible(true);
					dispose();
				}
				else{
					System.out.println("No recommendation. You could add more songs and try again.");
				}
				
			}
		});
		btnRecommand.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRecommand.setBounds(69, 212, 97, 55);
		getContentPane().add(btnRecommand);
	}
}
