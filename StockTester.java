import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class StockTester {

    @Test
    void testStockClass() {
        //test default constructor
        Stock stock = new Stock();
        
        //test name
        stock.setName("name");
        assertEquals(stock.getName(), "name");
        
        //test description
        stock.setDescription("description");
        assertEquals(stock.getDescription(), "description");
        
      //test index
        stock.setIndex("index");
        assertEquals(stock.getIndex(), "index");
        
      //test value
        stock.setValue(new BigDecimal("123.45"));
        assertEquals(stock.getValue(), 123.45);
        
      //test description
        stock.setDescription("description");
        assertEquals(stock.getDescription(), "description");
        
      //test trend
        stock.setTrend(67.89);
        assertEquals(stock.getTrend(), 67.89);
        
        //test RQE
        stock.setNQE("98.7");
        assertEquals(stock.getNQE(), "98.7");
        //comment
    }
    
    @Test
    void testUserClass() {
        //test default constructor
        User user = new User();
        
        //test name
        user.setUserName("name");
        assertEquals(user.getUserName(), "name");
        
        //test Password
        user.setPassword("password");
        assertEquals(user.getPassword(), "password");
        
      //test UserId
        user.setUserId(1202);
        assertEquals(user.getUserId(), 1202);
        
    }
     
    @Test
    void testAdminClass() {
        Admin admin = new Admin();

        // test name

        admin.setUserName("name");
        assertEquals(admin.getUserName(), "name");

        // test Password
        admin.setPassword("password");
        assertEquals(admin.getPassword(), "password");

        // test adminId
        admin.setUserId(1202);
        assertEquals(admin.getUserId(), 1202);
    }
    
    @Test
    void dbTest() {
        assertEquals(UserNameDB.checkUser("admin", "password"), true);
        
        assertEquals(UserNameDB.checkUser("admin", "passwordy"), false);
    }
}
