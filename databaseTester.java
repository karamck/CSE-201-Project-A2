import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class databaseTester {

    @Test
    void test() {
        assertEquals(UserNameDB.checkUser("admin", "password"), true);
    }

}
