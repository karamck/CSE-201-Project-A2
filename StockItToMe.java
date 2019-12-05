import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.event.*;

import yahoofinance.YahooFinance;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	private JPanel userPane;
	private login l;
	private User currentUser = new User();
	private ArrayList<Stock> market;
	private JLabel runningTotalDisplay;
	private BigDecimal totalValue;

	JList<String> list = new JList<String>();

	private User user=new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("hi");
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
		setForeground(Color.GREEN);
		setBackground(Color.BLACK);
		userScreen();
	}

	@SuppressWarnings("unchecked")
	public void userScreen() throws IOException {


		setTitle("Stock It To Me");
		setIconImage(Toolkit.getDefaultToolkit().getImage(addRequest.class.getResource("AppsyntheIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 555);
		userPane = new JPanel();
		userPane.setForeground(new Color(0, 255, 0));
		userPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(userPane);
		userPane.setLayout(new BorderLayout(0, 0));
		DefaultListModel<String> portfolio = new DefaultListModel<String>();
		DefaultListModel<String> indexes = new DefaultListModel<String>();
		JScrollPane scrollPane_1;
		JList<DefaultListModel<String>> portfolioList;
		JList<DefaultListModel<String>> stockList;
		market = populateMarket();
		portfolio.addElement("Your Stocks will be listed here");
		fillMarketModel(market, indexes);
		//=====MAIN CATALOG=====//

		JPanel browser_panel = new JPanel();
		userPane.add(browser_panel);
		browser_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));


		//create list
		stockList = new JList(indexes);
		stockList.setPreferredSize(new Dimension(750, 440));
		stockList.setMaximumSize(new Dimension(950, 999999));

		stockList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				JList list = (JList)me.getSource();
				if (me.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(me.getPoint());
					int counter = 0;
					for(Stock s : market) {
						if(counter == index) {
							try {
								boolean contains = false;
								System.out.println(Arrays.toString(currentUser.getStock()));
								for(Stock q : currentUser.stockList) {
									if(q.getIndex().equals(s.getIndex())) {
										contains = true;
										q.addAnother();
										currentUser.addOneStock(s.getIndex(), currentUser.getUserName());
									}
								}
								
								if(!contains) {
									currentUser.addStock(s);
								}

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String[] theirs = currentUser.getStock();
							System.out.println(Arrays.toString(theirs));
							try {
								fillListModel(currentUser, portfolio);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						counter++;
						
					}
					userPane.revalidate();
					userPane.repaint();
				} else if (me.getClickCount() == 3) {

					// Triple-click detected
					int index = list.locationToIndex(me.getPoint());
				}
				updatePortfolioTotal();
			}
		});

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
		panel_1.add(btnLogin);
        
        //=====TOP-RIGHT BUTTON GROUP=====//
        
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
	  				System.out.println(currentUser.getUserName());
		  	  		//System.out.println("closed");
	  				try {
						fillListModel(currentUser, portfolio);

						updatePortfolioTotal();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  				
		  	  	}
		
		  	  	@Override
		  	  	public void windowClosing(WindowEvent e) {
		  	  		ActionListener task = new ActionListener() {
		  	  			public void actionPerformed(ActionEvent e)
		  	  		      {
		  	  				currentUser = l.getUser();
		  	  				System.out.println(currentUser.getUserName());
		  	  				l.dispose();
		  	  				updatePortfolioTotal();
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
        

		JButton btnNewStock = new JButton("Add Request");
		btnNewStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRequest a = new addRequest();
				a.setVisible(true);
			}
		});
		panel_1.add(btnNewStock);


		//=====END TOP-RIGHT BUTTON GROUP=====//

		//=====SIDEBAR CODE=====//


		JPanel sidebar = new JPanel();
		userPane.add(sidebar, BorderLayout.EAST);
		sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
 
        //=====END TOP-RIGHT BUTTON GROUP=====//
        
        //=====SIDEBAR CODE=====//
        
        
		JPanel panel_3 = new JPanel();
		sidebar.add(panel_3);
		panel_3.setMaximumSize(new Dimension(300, 99999));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.LEFT);



		//updates users stocks


		portfolioList = new JList(portfolio);
		portfolioList.setPreferredSize(new Dimension(300, 450));
		portfolioList.setMaximumSize(new Dimension(300, 999999));

		portfolioList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				JList list = (JList)me.getSource();
				if (me.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(me.getPoint());
					System.out.println(index);
					int counter = 0;

					if (currentUser.isAdmin()) {
						System.out.println("hi");
						try {
							for(String r : AddRequestDB.getRequests()) {
								if (counter == index) {
									System.out.println(r);
									String[] split = r.split(" ");
									r = split[1];
									System.out.println("this is the symbol: " + r);
									r = r.trim();
									addStockToMarket(r);
									market = populateMarket();
									fillMarketModel(market, indexes);
									AddRequestDB.removeRequest(r);
									fillListModel(currentUser, portfolio);
								}
								counter++;
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block

							updatePortfolioTotal();
							e.printStackTrace();
						}
					}
					else {
						for(Stock s : currentUser.stockList) {
							if(counter == index) {
								System.out.println(s.getIndex());
								try {
									if(s.getAmount() == 1) {
										currentUser.removeStockFromPortfolio(s.getIndex(),currentUser.getUserName());
										currentUser.stockList.remove(s);
									} else {
										s.removeAnother();
										currentUser.deleteOneStock(s.getIndex(), currentUser.getUserName());
									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								String[] theirs = currentUser.getStock();
								System.out.println(Arrays.toString(theirs));
								try {
									fillListModel(currentUser, portfolio);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									updatePortfolioTotal();
									e.printStackTrace();
								}
							}
							counter++;
						}
					}
					panel_3.revalidate();
					panel_3.repaint();
				} 
				else if ( SwingUtilities.isRightMouseButton(me) ) {
		            int row = list.locationToIndex(me.getPoint());
		            System.out.println(row);
					int counter = 0;
					if(currentUser.isAdmin()) {
						try {
							for(String r : AddRequestDB.getRequests()) {
								if (counter == row) {
									System.out.println(r);
									String[] split = r.split(" ");
									r = split[1];
									System.out.println("this is the symbol: " + r);
									r = r.trim();
									AddRequestDB.removeRequest(r);
									fillListModel(currentUser, portfolio);
								}
								counter++;
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							updatePortfolioTotal();
							e.printStackTrace();
						}
					}
		        }
				updatePortfolioTotal();
			}
		});

		scrollPane_1 = new JScrollPane(portfolioList);
		scrollPane_1.setPreferredSize(new Dimension(300, 450));
		scrollPane_1.setMaximumSize(new Dimension(300, 999999));
		panel_3.add(scrollPane_1);
		scrollPane_1.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		runningTotalDisplay = new JLabel("Total Value: $0");
        sidebar.add(runningTotalDisplay);

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
			stock.setNQE("" + s.getStats().getEarningsAnnouncement().getTime());
			market.add(stock);
		}
		scnr.close();
		return market;
	}
	private void refreshStocks(DefaultListModel<String> indexes, DefaultListModel<String> portfolio) {
		try {
			market = populateMarket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fillListModel(currentUser, portfolio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fillMarketModel(market, indexes);
		updatePortfolioTotal();
	}
	
	private void updatePortfolioTotal() {
		System.out.println("Yeet");
		totalValue = new BigDecimal(0);
        for (Stock s : currentUser.stockList) {
        	totalValue = totalValue.add(s.getValue());
        }
		
        runningTotalDisplay.setText(String.format("Total Value: $%.2f", totalValue.floatValue()));
	}
	
	private boolean addStockToMarket(String index) throws IOException {
		FileWriter filewriter = new FileWriter("Market.txt",true);
		//filewriter.write(System.getProperty("line.separator"));
		filewriter.write("\n");
		filewriter.write(index);
		filewriter.close();
		return true;
	}
	private boolean removeStockToMarket(Stock s) {
		File unDB = new File("Market.txt");
		String index = s.getIndex();
        try {
            int count = 0;
            Scanner dbReader = new Scanner(unDB);
            String fileStuff = "";
            while (dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                if (splitLine[0].equals(index)) {
                } 
                else {
                    if (count != 0) {
                        fileStuff += "\n";
                    }
                    fileStuff += line;
                }
                count++;
            }
            dbReader.close();
            FileWriter fw = new FileWriter("Market.txt");
            // BufferedWriter br = new BufferedWriter(fw);
            // br.write(fileStuff);
            fw.write(fileStuff);
            fw.close();
            // br.close();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}
	
	public void fillMarketModel(ArrayList<Stock> market,DefaultListModel<String> indexes ) {
		indexes.clear();
		String[] stocks = new String[market.size()];
		for(Stock s : market) {
			indexes.addElement(s.toString());
		}
	}

	public void fillListModel(User user, DefaultListModel<String> portfolio) throws IOException{
		if (user.isAdmin()) {
			portfolio.clear();
			String[] requests = AddRequestDB.getRequests();
			for(String s : requests) {
				portfolio.addElement(s);
			}
		}
		else {
			portfolio.clear();
			String[] stocks = user.getStock();
			for(String s : stocks) {
				portfolio.addElement(s);
			}
		}

	}
	
}		

