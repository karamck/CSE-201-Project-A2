import java.math.BigDecimal;

public class Stock {
	private String name;
	private String description;
	private String index;
	private BigDecimal value;
	private double trend;
	private String NQE; //next quarter earnings
	
	//default constructor
	public Stock() {
	    
	}
	public Stock(String name, String description, String index, BigDecimal value, double trend, String nQE) {
	    this.name = name;
	    this.description = description;
	    this.index = index;
	    this.value = value;
	    this.trend = trend;
	    this.NQE = nQE;
	}
	public Stock(String name) {
		this.name=name;
	}
	public String toString() {
		return String.format("%s (%s)  | Value: %s | Trend: %f | nQE: %s",index, name, value.toPlainString(), trend, NQE );
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public double getTrend() {
		return trend;
	}
	public void setTrend(double trend) {
		this.trend = trend;
	}
	public String getNQE() {
		return NQE;
	}
	public void setNQE(String nQE) {
		this.NQE = nQE;
	}
}
