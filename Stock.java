
public class Stock {
	private String name;
	private String description;
	private String index;
	private double value;
	private double trend;
	private double RQE; //recent quarter earnings
	
	//default constructor
	public Stock() {
	    
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
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
	public double getRQE() {
		return RQE;
	}
	public void setRQE(double rQE) {
		RQE = rQE;
	}
}
