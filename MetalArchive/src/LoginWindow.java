import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;


public class LoginWindow extends JFrame{
	private JTextField userText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginWindow window = new LoginWindow();
//					window.frmLogin.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void close(){
		this.setVisible(false);
	}
	
	private void initialize() {
		setBounds(100, 100, 450, 300);
		
		this.setTitle("Login");
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		JButton exitButton = new JButton("Exit");
		exitButton.setIcon(new ImageIcon(LoginWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				dispose();
			}
		});
		exitButton.setBounds(302, 192, 93, 36);
		this.getContentPane().add(exitButton);
		
		JButton loginButton = new JButton("Login");
		loginButton.setIcon(new ImageIcon(LoginWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/maximize-pressed.gif")));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Procedures log = new Procedures();
				String tem = userText.getText().replaceAll("\\p{C}", "?");
				String name = log.login(tem, passwordField.getText().replaceAll("\\p{C}", "?"));
				
				System.out.println(name);
				
				if (name != "No valid username/password found!" && name != "Error! username contains special characters."){
					LoginInfo.setInfo(name);
					SearchAlbum window = new SearchAlbum();
					window.setVisible(true);
					close();
					dispose();
				}
				
				
			}
		});
		loginButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		loginButton.setBounds(61, 192, 93, 36);
		this.getContentPane().add(loginButton);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(75, 75, 68, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(75, 138, 68, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		userText = new JTextField();
		userText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		userText.setColumns(10);
		userText.setBounds(168, 72, 216, 31);
		this.getContentPane().add(userText);
		
		JButton regButton = new JButton("Register");
		regButton.setIcon(new ImageIcon(LoginWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		regButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterWindow window = new RegisterWindow();
				window.setVisible(true);
				close();
				dispose();
			}
		});
		regButton.setBounds(180, 192, 93, 36);
		getContentPane().add(regButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 134, 217, 31);
		getContentPane().add(passwordField);
	}
}
