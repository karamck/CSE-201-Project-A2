import static org.junit.jupiter.api.Assertions.*;

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
        stock.setValue(123.45);
        assertEquals(stock.getValue(), 123.45);
        
      //test description
        stock.setDescription("description");
        assertEquals(stock.getDescription(), "description");
        
      //test trend
        stock.setTrend(67.89);
        assertEquals(stock.getTrend(), 67.89);
        
        //test RQE
        stock.setRQE(98.7);
        assertEquals(stock.getRQE(), 98.7);
        //comment
    }
}
