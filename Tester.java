import static org.junit.jupiter.api.Assertions.*;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

// start Database Tester
class DatabaseTester{

	@Test
    void testDBpassword() {
		assertEquals(UserNameDB.checkUser("admin", "password"), true);
		assertTrue(UserNameDB.checkUser("admin", "password"));
	}
	
	@Test
	void testDBuser() {
		assertFalse(UserNameDB.checkUser("Hundo", "P"));
	}//end database user tester

	@Test
	void testDBadmin() {
		assertTrue(UserNameDB.checkAdmin("admin"));
		assertFalse(UserNameDB.checkAdmin("user"));
	}
}

//start AdminTester
class AdminTester{

	@Test
	void testAdminClass() {
        	Admin admin = new Admin();
	}
	
    	@Test
    	void testAdminName() {
    		Admin admin = new Admin();
    		admin.setUserName("name");
    		assertEquals(admin.getUserName(), "name");
    	}
    	@Test
    	void tesAdminPassword() {
    		Admin admin = new Admin();
    		admin.setPassword("password");
    		assertEquals(admin.getPassword(), "password");
    	}
    	@Test
    	void testAdminId() {
    		Admin admin = new Admin();
        	admin.setUserId(1202);
        	assertEquals(admin.getUserId(), 1202);
    	}
}//end Admin Class Tester


//start StockClassTester
class StockClassTester{
	
	@Test
    	void testStockClass() {
       		Stock stock = new Stock();
       		Stock stock2 = new Stock("YAH");
    	}

    	@Test
	void testStockName() {
		Stock stock = new Stock();
   		stock.setName("name");
   		assertEquals(stock.getName(), "name");
	}

	@Test
	void testStockdesc() {
		Stock stock = new Stock();
		stock.setDescription("description");
		assertEquals(stock.getDescription(), "description");
	}

	@Test
	void testStockIndex() {
		Stock stock = new Stock();
		stock.setIndex("index");
    		assertEquals(stock.getIndex(), "index");
	}
	
	@Test
	void testStockTrend() {
	   	Stock stock = new Stock();
	   	stock.setTrend(22.2);
	   	assertEquals(stock.getTrend(), 22.2);
	}
	
	@Test
	void testStocktoString() {
		Stock stock = new Stock("Name", "Description", "Index", new BigDecimal(3), 0.5, "00/00/0000");
		assertEquals(stock.toString(), "Index (Name) | Value: 3 | Trend: 0.5 | nQE: 00/00/0000");
	}
	@Test
	void testStockCompareTo() {
		Stock stockA = new Stock("1","","AA", new BigDecimal(0),0,"");
		Stock stockB = new Stock("3","","ABC", new BigDecimal(0),0,"");
		Stock stockC = new Stock("2","","AAA", new BigDecimal(0),0,"");
		Stock stockF = new Stock("4","","ABC", new BigDecimal(0),0,"");
		
		assertEquals(stockB.compareTo(stockF), 0);
		assertTrue(stockA.compareTo(stockC) > 0);
		assertTrue(stockB.compareTo(stockC) < 0);
	}
}//end Stock Tester   


//start UserClassTester
class UserClassTester{
	
	@Test
    	void testerUserClass() {
     		User user = new User();
	}
	
	@Test
	void testUserName() {
		User user = new User();
		user.setUserName("name");
		assertEquals(user.getUserName(), "name");
	}
	@Test
	void testUserID() {
		User user = new User();
		user.setUserId(1202);
		assertEquals(user.getUserId(), 1202);
	}   
	@Test
	void testUserPassword() {
		User user = new User();
		user.setPassword("password");
		assertEquals(user.getPassword(), "password");
	}
	@Test
	void testUserStockList() {
		User user = new User();
		for(int i=0;i<100;i++) {
			user.stockList.add(new Stock(i+""));
		}
		for(int i=0;i<100;i++) {
			assertEquals(user.stockList.get(i).getName(), i+"");
		}	
		assertThrows(IndexOutOfBoundsException.class, () -> user.stockList.get(1000));
		assertThrows(IndexOutOfBoundsException.class, () -> user.stockList.get(-1));
		assertEquals(user.stockList.get(50).getName(), "50");
		
	}
}
