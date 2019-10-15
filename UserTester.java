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
}
