import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBTester {

    void testDB() {
    	//Test checkPW
    	assertEquals(UserNameDB.checkPW("admin", "password"), true);
    	
    	
        
    }
}
