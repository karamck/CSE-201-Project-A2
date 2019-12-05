import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
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
    
    public ArrayList<Stock> populatePortfolio(String username) throws IOException {
		ArrayList<Stock> portfolio = new ArrayList<Stock>();
		String file = username + ".txt";
		Scanner scnr = new Scanner(new File(file));
    	//populate data
		while(scnr.hasNextLine()) {
			String[] line = scnr.nextLine().split(" ");
			String index = line[0];
			yahoofinance.Stock s = YahooFinance.get(index);
			Stock stock = new Stock();
			stock.setIndex(index);
			stock.setName(s.getName());
			stock.setValue(s.getQuote().getPrice());
			stock.setTrend(0.00);
			stock.setNQE(s.getStats().getEarningsAnnouncement().toString());
			stock.setAmount(Integer.parseInt(line[1]));
			portfolio.add(stock);
			System.out.println(line[1]);
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
    		String index  = stockList.get(i).getIndex();
    		String amount = Integer.toString(stockList.get(i).getAmount());
    		BigDecimal value = stockList.get(i).getValue().multiply(new BigDecimal(stockList.get(i).getAmount()));
    		String val = value.toString();
    		stockString[i]=index + " x"+ amount + " = " + val;
    	}
    	return stockString;
    }
    
    public void addStock(Stock stock) throws IOException {
    		stock.setAmount(1);
    		stockList.add(stock);
    		addStockToPortfolio(stock.getIndex(), this.userName);

    }
    public boolean removeStockFromPortfolio(String symbol, String user) throws IOException {
        symbol = symbol.trim();
        String filename = user + ".txt";
        File portf = new File(filename);
        try {
            int count = 0;
            Scanner dbReader = new Scanner(portf);
            String fileStuff = "";
            while (dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                if (!splitLine[0].equals(symbol)) {
                    fileStuff += line;
                    fileStuff += "\n";
                }
                count++;
            }
            dbReader.close();
            FileWriter fw = new FileWriter(filename);
            //if(count != 1) {
            //fileStuff += "\n";
            //}
            fw.write(fileStuff);
            fw.close();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        return false;
    }
    
    public boolean deleteOneStock(String symbol, String user) throws IOException{
    	symbol = symbol.trim();
        String filename = user + ".txt";
        File portf = new File(filename);
        try {
            int count = 0;
            Scanner dbReader = new Scanner(portf);
            String fileStuff = "";
            while (dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                if (splitLine[0].equals(symbol)) {
                	int temp = Integer.parseInt(splitLine[1]);
                	temp--;
                	String temps;
                	if (count != 0) {
                		temps = "\n" + symbol + " " + temp;
                	}else {
                		temps =symbol + " " + temp;
                	}
                	fileStuff+=temps;
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
            FileWriter fw = new FileWriter(filename);
            fileStuff += "\n";
            fw.write(fileStuff);
            fw.close();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        return false;
    }
    
    public boolean addOneStock(String symbol, String user) throws IOException{
    	symbol = symbol.trim();
        String filename = user + ".txt";
        File portf = new File(filename);
        try {
            int count = 0;
            Scanner dbReader = new Scanner(portf);
            String fileStuff = "";
            while (dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                if (splitLine[0].equals(symbol)) {
                	int temp = Integer.parseInt(splitLine[1]);
                	temp++;
                	String temps;
                	if (count != 0) {
                		temps = "\n" + symbol + " " + temp;
                	}else {
                		temps =symbol + " " + temp;
                	}
                	fileStuff+=temps;
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
            FileWriter fw = new FileWriter(filename);
            fileStuff += "\n";
            fw.write(fileStuff);
            fw.close();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        return false;
    }
    
    private boolean addStockToPortfolio(String index, String username) throws IOException {
		String file = username + ".txt";
		FileWriter filewriter = new FileWriter(file,true);
		//filewriter.write(System.getProperty( "line.separator" ));
		filewriter.write(index + " 1\n");
		filewriter.close();
		return true;
	}
    
    public boolean isAdmin() {
    	return UserNameDB.checkAdmin(userName);
    }
    
}
