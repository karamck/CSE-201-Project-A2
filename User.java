import java.util.ArrayList;

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
    
    
}
