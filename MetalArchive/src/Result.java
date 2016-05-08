import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Result extends JFrame{
	DefaultListModel model = new DefaultListModel();
	JList resultList = new JList(model);
	ResultSet rs = null;
	String type = null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Result window = new Result();
//					window.frmResult.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param selected 
	 * @param string 
	 */
	public Result(String keyword, String type) {
		this.type = type;
		Procedures temp = new Procedures();
		rs = temp.Search(keyword, type);
		if (rs == null){
			System.out.println("No result found");
		}
		try {
			while(rs!= null && rs.next()){
//				System.out.println(rs.getString("Name"));
				model.addElement(rs.getString("Name"));
			}
		}catch (SQLException e) {
			
			System.out.println(e);
		}
		if (model == null){
			System.out.println("No result found");
		}
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void close(){
		this.setVisible(false);
	}
	private void initialize(){
		this.setTitle("Result");
		this.setBounds(100, 100, 365, 555);
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
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(resultList.getSelectedValue() != null){
					if(type == "Album"){
						Album window = new Album(resultList.getSelectedValue().toString());
						window.setVisible(true);
					}else if (type == "Songs"){
						Songs window = new Songs(resultList.getSelectedValue().toString());
						window.setVisible(true);
					}else if (type == "Member"){
						Member window = new Member(resultList.getSelectedValue().toString());
						window.setVisible(true);
					}else if (type == "Tour"){
						Tour window = new Tour(resultList.getSelectedValue().toString());
						window.setVisible(true);
					}else if (type == "Band"){
						Band window = new Band(resultList.getSelectedValue().toString());
						window.setVisible(true);
					}else {
						System.out.println("Search type error! Please try again.");
						
					}
						
					
					close();
					dispose();
				}
				else{
					System.out.println("Please select one result to view");
				}

			}
			
		});
		btnView.setBounds(46, 419, 116, 41);
		this.getContentPane().add(btnView);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(32, 39, 54, 15);
		this.getContentPane().add(lblNewLabel);
		
		JButton btnSearchAgain = new JButton("Search Again");
		btnSearchAgain.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearchAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchAlbum window = new SearchAlbum();
				window.setVisible(true);
				close();
				dispose();
				
			}
		});
		btnSearchAgain.setBounds(190, 419, 116, 41);
		this.getContentPane().add(btnSearchAgain);
	}
}
