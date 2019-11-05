	import static org.junit.jupiter.api.Assertions.*;
	
	import java.util.ArrayList;
	
	import org.junit.jupiter.api.Test;


class Tester {
	
	
	/*
	 * 
	 * start PopulateData
	 */
	void testPopulate() {
	//assertFalse(TestyStuff.PopulateData());
	}
	
	
	/*
	 * 
	 * start Database Tester
	 */
	@Test
    void testDB() {
     //Test checkPW
    	assertEquals(UserNameDB.checkUser("admin", "password"), true);
        assertTrue(UserNameDB.checkUser("admin", "password"));
        assertFalse(UserNameDB.checkUser("Hundo", "P"));
        assertTrue(UserNameDB.checkAdmin("admin"));
        assertFalse(UserNameDB.checkAdmin("user"));
        
    }//end Database Tester
	
	/*
	 * 
	 * Start Admin Class Testers
	 */
	@Test
	void testUserClass() {
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
    }//end Admin Class Tester
	
	/*
	 * 
	 * Start Stock Class Tester
	 */
    @Test
    void testStockClass() {
      //test default constructor
        Stock stock = new Stock();
        
      //test name
        stock.setName("name");
        assertEquals(stock.getName(), "name");
        
      //test value
        stock.setValue(123.45);
        assertEquals(stock.getValue(), 123.45);

      //test description
        stock.setDescription("description");
        assertEquals(stock.getDescription(), "description");
        
      //test index
        stock.setIndex("index");
        assertEquals(stock.getIndex(), "index");

      //test trend
        stock.setTrend(22.2);
        assertEquals(stock.getTrend(), 22.2);

      //test RQE
        stock.setRQE(300);
        assertEquals(stock.getRQE(), 300);
        
      //test trend
        stock.setTrend(67.89);
        assertEquals(stock.getTrend(), 67.89);
        
      //test RQE
        stock.setRQE(98.7);
        assertEquals(stock.getRQE(), 98.7);
      //comment
    }//end Stock Tester
    
    
	/*
	 * 
	 * Start User Class Tester
	 */
	@Test
    void testerUserClass() {
        //test default constructor
		User user = new User();
    
		//test name
		user.setUserName("name");
		assertEquals(user.getUserName(), "name");
    
		//test UserId
		user.setUserId(1202);
		assertEquals(user.getUserId(), 1202);
   
		//test Password
		user.setPassword("password");
		assertEquals(user.getPassword(), "password");
		
		//test stock list
    for(int i=0;i<100;i++) {
    	user.stockList.add(new Stock(i+""));
    }
    for(int i=0;i<100;i++) {
    	assertEquals(user.stockList.get(i).getName(), i+"");
    }
    
}
	/*
	 * 
	 * Stock list tester
	 */
	@Test 
	public void testIndexOutOfBoundsException() {
		User user = new User();
		for (int i=0;i<100;i++) {
			user.addStock(new Stock(i + ""));
		}
		assertThrows(IndexOutOfBoundsException.class, () -> user.stockList.get(1000));
		assertThrows(IndexOutOfBoundsException.class, () -> user.stockList.get(-1));
		assertEquals(user.stockList.get(50).getName(), "50");
}//end userTester

}
