package simple.stock.market.model;

import simple.stock.market.model.type.StockType;

/**
 * @author sergio
 *
 * It is assumed that all fields are mandatory with exception of fixedDividend
 */
public class Stock {

	private String symbol;
	private StockType type;
	/**
	 * lastDividend = value in pennies
	 */
	private int lastDividend;
	/**
	 * fixedDividend percentage value is expressed in decimals. 
	 * ex. 2% = 0,02
	 */
	private Double fixedDividend;
	/**
	 * parValue = value in pennies
	 */
	private int parValue;
	
	
	public Stock(String symbol, StockType type, int lastDividend, int parValue) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.parValue = parValue;
	}
	
	
	public Stock(String symbol, StockType type, int lastDividend, double fixedDividend, int parValue) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}





	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public StockType getType() {
		return type;
	}
	public void setType(StockType type) {
		this.type = type;
	}
	public int getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(int lastDividend) {
		this.lastDividend = lastDividend;
	}
	public Double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public int getParValue() {
		return parValue;
	}
	public void setParValue(int parValue) {
		this.parValue = parValue;
	}


	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", type=" + type.toString() + ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + "]";
	}
	

	
}


