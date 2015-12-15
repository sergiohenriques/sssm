package simple.stock.market.service;

import simple.stock.market.model.Stock;

/**
 * @author sergio
 *
 *This class performs the necessary operations for a given stock.
 *All monetary results are on pennies.
 */
public interface StockService {


	
	/**
	 * Checks if field fixed dividend is null and returns the common dividend yield.
	 * Otherwise returns the preferred dividend yield
	 * 
	 * @param price in pennies
	 * @return dividend yield
	 */
	public double dividendYield(int price);
	
	/**
	 * 
	 * @param price in pennies
	 * @return last dividend / price
	 */
	public double commonDividendYield(int price);
	
	/**
	 * @param price in pennies
	 * @return fixed dividend * par value / price
	 */
	public double preferredDividendYield(int price);
	
	
	/**
	 * @param price in pennies
	 * @return price / dividend (assumed to be the last dividend)
	 */
	public double peRatio(int price);
	
	
	/**
	 * Returns the volume weighted stock price for the last 15 minutes
	 * 
	 * @return sum(tradedprice_i * quantity_i) / sum(quantity)
	 */
	public double volumeWeightedStockPrice();
	
	/**
	 * 
	 * @return if stock was created
	 */
	public boolean addStock(Stock stock);
	
}
