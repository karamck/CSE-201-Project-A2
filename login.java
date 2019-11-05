import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.SwingConstants;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private String un;
	private String user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getUser() {
		return user;
	}

	/**
	 * Create the frame.
	 */
	public login() {

		setTitle("StockItToMe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel Msg = new JLabel("");
		Msg.setHorizontalAlignment(SwingConstants.CENTER);
		Msg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Msg.setForeground(Color.RED);
		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
	
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnLogin.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        // print login attempt
	        //System.out.print("Username: " + textField.getText() + "\nPassword: " + passwordField.getText());
	    	  if (UserNameDB.checkUser(textField.getText(), passwordField.getText())) {
	    		  user = textField.getText();
	    		  System.out.println("Login Success");
	    		  dispose();
	    		  //closeFrame();
	    		  //System.exit(0);
	    	  }
	    	  else {
	    		  Msg.setForeground(Color.RED);
	    		  Msg.setText("Incorrect Username or Password");
	    		  //System.out.println("nope");
	    	  }
	    		  
	      }
	    });
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnRegister.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        // print login attempt
	        //System.out.print("Username: " + textField.getText() + "\nPassword: " + passwordField.getText());
	    	  int temp;
    		  Msg.setText("");
			try {
				temp = UserNameDB.addUser(textField.getText(), passwordField.getText());
		    	  if (temp == 0) {
		    		  Msg.setForeground(Color.GREEN);
		    		  Msg.setText("User Created");
		    	  }
		    	  else if (temp == 2) {
		    		  Msg.setForeground(Color.RED);
		    		  Msg.setText("Username taken");
		    	  }
		    	  else {
		    		  Msg.setForeground(Color.RED);
		    		  Msg.setText("Invaild. No spaces in username or password.");
		    		  //System.out.println("nope");
		    	  }
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	  
	      }
	    });
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(40))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(20)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, 258, 258, 258)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)))
						.addComponent(Msg, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(Msg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void closeFrame() {
	    this.dispose();
	}
}
