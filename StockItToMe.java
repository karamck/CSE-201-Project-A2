import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import yahoofinance.YahooFinance;
import java.math.BigDecimal;

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
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.ListModel;
import javax.swing.JScrollPane;

public class StockItToMe extends JFrame{
	private JPanel loginPane;
	private JPasswordField passwordField;
	private JTextField textField;
    private JTable table;  
    private JPanel userPane;
    private login l;
    private String currentUser;
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
     * @throws IOException 
     */
    public StockItToMe() throws IOException {
    	userScreen();
    }
    
    public void userScreen() throws IOException {
    	
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
        
        
        //generate data
        //String indexes[] = { "GOOGL", "AAPL", "AMD", "CLDR", "TWTR", "TSLA","FB", "DIS" };
        ArrayList<Stock> market = populateMarket();
        String indexes[] = new String[market.size()];
        int counter = 0;
        for(Stock s : market) {
        	indexes[counter] = s.getIndex();
        	counter++;
        }
        
        
        //create list
        JList<String> stockList = new JList<String>(indexes);
        stockList.setPreferredSize(new Dimension(750, 440));
        stockList.setMaximumSize(new Dimension(950, 999999));
       
        
        //create pane using list
        JScrollPane mainScrollPane = new JScrollPane(stockList);
        mainScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setPreferredSize(new Dimension(750, 450));
        mainScrollPane.setMaximumSize(new Dimension(950, 999999));
        
        browser_panel.add(mainScrollPane);
        
        
        
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
  	        l.addWindowListener(new WindowListener() {

		  	    @Override
		  	  	public void windowActivated(WindowEvent arg0) {
		  	  		// TODO Auto-generated method stub
		  	  		
		  	  	}
		
		  	  	@Override
		  	  	public void windowClosed(WindowEvent j) {
		  	  		// TODO Auto-generated method stub
		  	  		currentUser = l.getUser();
	  				System.out.println(currentUser);
		  	  		//System.out.println("closed");
		  	  	}
		
		  	  	@Override
		  	  	public void windowClosing(WindowEvent e) {
		  	  		ActionListener task = new ActionListener() {
		  	  			public void actionPerformed(ActionEvent e)
		  	  		      {
		  	  				currentUser = l.getUser();
		  	  				System.out.println(currentUser);
		  	  				l.dispose();
		  	  		      }
		  	  			};
		  	  	}
		
		  	  	@Override
		  	  	public void windowDeactivated(WindowEvent e) {
		  	  		// TODO Auto-generated method stub
		  	  		//System.out.print("deactivated");
		  	  	}
		
		  	  	@Override
		  	  	public void windowDeiconified(WindowEvent e) {
		  	  		// TODO Auto-generated method stub
		  	  		
		  	  	}
		
		  	  	@Override
		  	  	public void windowIconified(WindowEvent e) {
		  	  		// TODO Auto-generated method stub
		  	  		System.out.print("minimized");
		  	  	}
		
		  	  	@Override
		  	  	public void windowOpened(WindowEvent e) {
		  	  		// TODO Auto-generated method stub
		  	  		System.out.print("opened");
		  	  	}
  	        	
  	        });
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
  
	
	private ArrayList<Stock> populateMarket() throws IOException {
		Scanner scnr = new Scanner(new File("Market.txt"));
		ArrayList<Stock> market = new ArrayList<Stock>();
		while(scnr.hasNextLine()) {
			String index = scnr.nextLine();
			yahoofinance.Stock s = YahooFinance.get(index);
			Stock stock = new Stock();
			stock.setIndex(index);
			stock.setName(s.getName());
			stock.setValue(s.getQuote().getPrice());
			stock.setTrend(0.00);
			stock.setNQE(s.getStats().getEarningsAnnouncement().toString());
			market.add(stock);
		}
		scnr.close();
		return market;
	}
	
	
	private ArrayList<Stock> populatePortfolio(String username) throws IOException {
		ArrayList<Stock> portfolio = new ArrayList<Stock>();
		String file = username + ".txt";
		Scanner scnr = new Scanner(file);
    	//populate data
		while(scnr.hasNextLine()) {
			String index = scnr.nextLine();
			yahoofinance.Stock s = YahooFinance.get(index);
			Stock stock = new Stock();
			stock.setIndex(index);
			stock.setName(s.getName());
			stock.setValue(s.getQuote().getPrice());
			stock.setTrend(0.00);
			stock.setNQE(s.getStats().getEarningsAnnouncement().toString());
			portfolio.add(stock);
		}
		scnr.close();
		return portfolio;
	}
	
	private boolean addStockToMarket(String index) throws IOException {
		FileWriter filewriter = new FileWriter("Market.txt",true);
		filewriter.write(index);
		filewriter.close();
		return true;
	}
	private boolean addStockToPortfolio(String index, String username) throws IOException {
		String file = username + ".txt";
		FileWriter filewriter = new FileWriter(file,true);
		filewriter.write(index);
		filewriter.close();
		return true;
	}
	
	private User populateData(String username) {
		User user = new User(username);
		return user;
	}


}
