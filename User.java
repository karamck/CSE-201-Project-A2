import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JList;

import yahoofinance.YahooFinance;

public class User implements Account {
    String userName;
    int userId;
    String password;
    ArrayList<Stock> stockList;
    
    
    public User() {
        userName = "";
        userId = -1;
        password = "";
        stockList = new ArrayList<Stock>();
    }
    public User(String userName) throws IOException {
    	this.userName=userName;
        userId = -1;
        password = "";
        stockList = populatePortfolio(userName);
    }
    
    private ArrayList<Stock> populatePortfolio(String username) throws IOException {
		ArrayList<Stock> portfolio = new ArrayList<Stock>();
		String file = username + ".txt";
		Scanner scnr = new Scanner(new File(file));
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
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
    
    public String[] getStock() {
    	if(stockList.size()==0) {
    		String[] stocks = {""};
    		return stocks;
    	}
    	String[] stockString = new String[stockList.size()];
    	
    	for(int i=0;i<stockList.size();i++) {
    		stockString[i]=stockList.get(i).getName();
    	}
    	return stockString;
    }
    
    public void addStock(Stock stock) throws IOException {
    	stockList.add(stock);
    	addStockToPortfolio(stock.getIndex(), this.userName);
    }
    public void removeStock(Stock stock) {
    	stockList.remove(stock);
    	

    }
    
    private boolean addStockToPortfolio(String index, String username) throws IOException {
		String file = username + ".txt";
		FileWriter filewriter = new FileWriter(file,true);
		filewriter.write(System.getProperty( "line.separator" ));
		filewriter.write(index);
		filewriter.close();
		return true;
	}
    
}
