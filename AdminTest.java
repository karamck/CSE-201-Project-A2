import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminTest {
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
}
