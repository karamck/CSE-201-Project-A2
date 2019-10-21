import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTester {

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
    
    void dbTest() {
        assertEquals(UserNameDB.checkUser("admin", "password"), true);
    }
}
