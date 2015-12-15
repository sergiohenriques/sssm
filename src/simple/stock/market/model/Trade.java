package simple.stock.market.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import simple.stock.market.model.type.TradeType;

/**
 * @author sergio
 *
 * This class records a trade, with timestamp, quantity of shares, buy or sell indicator and
 * traded price
 */
public class Trade {

	private String stock;
	
	
	/**
	 * timestamp is kept in epoch format for easier comparisons 
	 */
	private long timestamp;
	
	/**
	 * 2^31 - 1 should be enough
	 */
	private int quantity;
	
	private TradeType type ;
	
	/**
	 * trade price in pennies
	 */
	private int price ;

	/**
	 * @param stock symbol
	 * @param timestamp
	 * @param quantity
	 * @param type
	 * @param price in pennies
	 */
	public Trade(String stock, long timestamp, int quantity, TradeType type, int price) {
		super();
		this.stock = stock;
		this.timestamp = timestamp;
		this.quantity = quantity;
		this.type = type;
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public TradeType getType() {
		return type;
	}

	public void setType(TradeType type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		
		Date date = new Date(timestamp);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String hrTs = format.format(date);
        
		return "Trade [stock=" + stock + ", timestamp=" + hrTs + ", quantity=" + quantity + ", type=" + type.toString()
				+ ", price=" + price + "]";
	}
	
	
	
	
}
