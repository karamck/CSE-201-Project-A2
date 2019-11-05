
import java.io.IOException;
import java.math.BigDecimal;
import yahoofinance.YahooFinance;

public class APIattempt {

	public static void main(String[] args) throws IOException {
		yahoofinance.Stock stock = YahooFinance.get("GOOGL");
		
		BigDecimal price = stock.getQuote().getPrice();
		BigDecimal change = stock.getQuote().getChangeInPercent();
		BigDecimal peg = stock.getStats().getPeg();
		BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

		stock.print();
	}

}
