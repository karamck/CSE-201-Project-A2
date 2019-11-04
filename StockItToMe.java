import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.ListModel;
import javax.swing.JScrollPane;

public class StockItToMe extends JFrame {
	private JPanel loginPane;
	private JPasswordField passwordField;
	private JTextField textField;
    private JTable table;  
    private JPanel userPane;
    private login l;
	JList<String> list = new JList<String>();
	

    private User user=new User();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StockItToMe frame = new StockItToMe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(); //comment
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public StockItToMe() {
    	userScreen();
    }
    
    public void userScreen() {
    	setTitle("Stock It To Me");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 969, 555);
        userPane = new JPanel();
        userPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(userPane);
        userPane.setLayout(new BorderLayout(0, 0));
        
        
        //=====MAIN CATALOG=====//
        
        JPanel browser_panel = new JPanel();
        userPane.add(browser_panel);
        browser_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        JScrollPane mainScrollPane = new JScrollPane();
        mainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setPreferredSize(new Dimension(750, 450));
        mainScrollPane.setMaximumSize(new Dimension(950, 999999));
        browser_panel.add(mainScrollPane);
        
        
        String[] testlist = {"1", "2", "3"};
        JList<String> stockList = new JList<>(testlist);
        stockList.setPreferredSize(new Dimension(750, 440));
        stockList.setMaximumSize(new Dimension(950, 999999));
        mainScrollPane.add(stockList);
        
        
        
        JPanel panel = new JPanel();
        userPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JPanel topbar = new JPanel();
        userPane.add(topbar, BorderLayout.NORTH);
        topbar.setLayout(new BoxLayout(topbar, BoxLayout.X_AXIS));
        
        JPanel panelRight = new JPanel();
        topbar.add(panelRight);
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        JLabel lblStockItTo = new JLabel("Stock It To Me");
        panelRight.add(lblStockItTo);
        

        
        //=====TOP-RIGHT BUTTON GROUP=====//
        
        
        
        JPanel panel_1 = new JPanel();
        topbar.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        
        JButton btnLogin = new JButton("Login");
        /*
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loginScreen();
        	}
        });
        */
        panel_1.add(btnLogin);
        
        btnLogin.addActionListener(new ActionListener()
	    {
  	      public void actionPerformed(ActionEvent e)
  	      {
  	        l = new login();
  	        l.setVisible(true);
  	      }
  	    });
        
        JButton btnSignup = new JButton("Signup");
        btnSignup.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(user.getUserName());
        		for(int i=0;i<user.getStock().length;i++) {
        		System.out.println(user.getStock()[i]);
        		}
        	}
        });
        panel_1.add(btnSignup);
        
        
        //=====END TOP-RIGHT BUTTON GROUP=====//
        
        //=====SIDEBAR CODE=====//
        
        
        JPanel sidebar = new JPanel();
        userPane.add(sidebar, BorderLayout.EAST);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        /*
        JLabel lblStockItToIco = new JLabel();
        Icon icon = new ImageIcon(getClass().getResource("stockItIcon.png"));         
        lblStockItToIco.setIcon(icon);
        panel_2.add(lblStockItToIco);
        */
        JPanel panel_3 = new JPanel();
        sidebar.add(panel_3);
        panel_3.setMaximumSize(new Dimension(250, 99999));
        FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
        flowLayout.setVgap(15);
        flowLayout.setHgap(15);
        flowLayout.setAlignment(FlowLayout.LEFT);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setPreferredSize(new Dimension(150, 450));
        scrollPane_1.setMaximumSize(new Dimension(250, 999999));
        panel_3.add(scrollPane_1);
        scrollPane_1.setAlignmentY(Component.TOP_ALIGNMENT);
        scrollPane_1.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane_1.setColumnHeaderView(lblStockBowse_1);
        
    	list.setPreferredSize(new Dimension(150, 440));
    	list.setMaximumSize(new Dimension(75, 590));
    	list.setBounds(48, 39, 1, 1);
    	scrollPane_1.setViewportView(list);
    	
        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(150, 400));

        //=====END SIDEBAR=====//
}
    //===SCARY EXPERIMENTAL UNKNOWN STUFF BELOW===//
	/**
	 * Create the frame.
	 */
	public void loginScreen() {
		setTitle("StockItToMe");
		loginPane = new JPanel();
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
		setContentPane(loginPane);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel ErrorMsg = new JLabel("");
		ErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorMsg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ErrorMsg.setForeground(Color.RED);
		
		
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
	    	  String usName=textField.getText();
	        // print login attempt
	        //System.out.print("Username: " + textField.getText() + "\nPassword: " + passwordField.getText());
	    	  if (UserNameDB.checkUser(usName, passwordField.getText())) {
	    		  System.out.println(usName);
	    		  user = populateData(usName);
	    		  setBounds(100, 100, 723, 610);
	              list=new JList(user.getStock());
	              list.repaint();
	    		  setContentPane(userPane);
	    		  userPane.repaint();
//	    		  userScreen();
//	    		  System.exit(0);
	    	  }
	    	  else {
	    		  ErrorMsg.setText("Incorrect Username or Password");
	    		  //System.out.println("nope");
	    	  }
	    		  
	      }
	    });
		

		GroupLayout gl_contentPane = new GroupLayout(loginPane);
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
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(132)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addComponent(ErrorMsg, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
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
					.addComponent(ErrorMsg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		loginPane.setLayout(gl_contentPane);
	}
    
	private User populateData(String username) {
		User user = new User(username);
    	//populate data
		for(int i=0; i<25;i++) {
			user.addStock(new Stock("stock" + i));
		}
		
		return user;
	}

}
