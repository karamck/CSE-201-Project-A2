import java.util.ArrayList;

import javax.swing.JList;

public class User {
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
    public User(String userName) {
    	this.userName=userName;
        userId = -1;
        password = "";
        stockList = new ArrayList<Stock>();
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
    	if(stockList.size()==0) return null;
    	String[] stockString = new String[stockList.size()];
    	
    	for(int i=0;i<stockList.size();i++) {
    		stockString[i]=stockList.get(i).getName();
    	}
    	return stockString;
    }
    
    public void addStock(Stock stock) {
    	stockList.add(stock);
    }
    
}
