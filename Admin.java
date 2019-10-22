
public class Admin {
    String userName;
    int userId;
    String password;
    
    public Admin() {
        userName = "";
        userId = -1;
        password = "";
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
    public boolean addStockToDB(Stock stock) {
        return false;
    }
    public boolean removeStockFromDB(Stock stock) {
        return false;
    }
    public boolean editStock(Stock stock) {
        return false;
    }
    
}
