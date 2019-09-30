import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockTester {

    @Test
    void testStockClass() {
        Stock stock = new Stock();
        stock.setName("name");
        assertEquals(stock.getName(), "name");
    }
}
