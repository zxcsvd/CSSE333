import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class RegisterWindow extends JFrame{

	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {

		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//		frame = new JFrame();
		this.setBounds(100, 100, 480, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(160, 90, 216, 31);
		this.getContentPane().add(textField);
		
		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(67, 98, 68, 15);
		this.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1.setBounds(67, 148, 68, 15);
		this.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(160, 38, 216, 31);
		this.getContentPane().add(textField_2);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblName.setBounds(67, 46, 68, 15);
		this.getContentPane().add(lblName);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow window = new LoginWindow();
				window.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnBack.setBounds(257, 245, 93, 36);
		this.getContentPane().add(btnBack);
		
		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Procedures temp = new Procedures();
				System.out.println(textField_2.getText());
				if(textField_2.getText().replaceAll("\\p{C}", "?").length() > 0  && textField.getText().replaceAll("\\p{C}", "?").length() > 0 && passwordField_1.getText().replaceAll("\\p{C}", "?").length() > 0)
					if(passwordField_1.getText().equals(passwordField.getText())){
						System.out.println(temp.Register(textField_2.getText().replaceAll("\\p{C}", "?"), textField.getText().replaceAll("\\p{C}", "?"), passwordField_1.getText().replaceAll("\\p{C}", "?")));
					}
					else{
						System.out.println("Password must be the same.");
					}
				else{
					System.out.println("Name, username and password can't be blank.");
				}
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button.setBounds(107, 245, 93, 36);
		this.getContentPane().add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 193, 216, 31);
		getContentPane().add(passwordField);
		
		JLabel lblVerify = new JLabel("Verify:");
		lblVerify.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblVerify.setBounds(67, 201, 68, 15);
		getContentPane().add(lblVerify);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(160, 139, 216, 31);
		getContentPane().add(passwordField_1);
	}
}
