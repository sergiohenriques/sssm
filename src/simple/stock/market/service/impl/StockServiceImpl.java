package simple.stock.market.service.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simple.stock.market.dac.impl.StockDAOImpl;
import simple.stock.market.dac.impl.TradeDAOImpl;
import simple.stock.market.model.Stock;
import simple.stock.market.model.Trade;
import simple.stock.market.service.StockService;
import test.simple.stock.market.service.impl.StockServiceImplTest;

/**
 * @author sergio
 *
 *This class performs the necessary operations for a given stock.
 *All monetary results are on pennies.
 */
public class StockServiceImpl implements StockService{


	
	private Stock stock;
	
	public StockServiceImpl() {
	}

	public StockServiceImpl(Stock stock) {
		this.stock = stock;
	}
	
	public StockServiceImpl(String stockSymbol){
		this.stock = StockDAOImpl.getInstance().getStock(stockSymbol);
	}
	
	/**
	 * Checks if field fixed dividend is null and returns the common dividend yield.
	 * Otherwise returns the preferred dividend yield
	 * 
	 * @param price in pennies
	 * @return dividend yield
	 */
	public double dividendYield(int price){
		if(stock==null)
			return -1;
		return (stock.getFixedDividend()==null)? commonDividendYield(price):preferredDividendYield(price);
	}
	
	/**
	 * 
	 * @param price in pennies
	 * @return last dividend / price or -1 if price is invalid
	 */
	public double commonDividendYield(int price){

		if (price <1 || stock == null)
			return -1;
		return stock.getLastDividend() / price;
	}
	
	/**
	 * @param price in pennies
	 * @return fixed dividend * par value / price
	 */
	public double preferredDividendYield(int price){
		if (price <1 || stock.getFixedDividend()==null)
			return -1.0;
		return stock.getFixedDividend() * stock.getParValue() / price;
	}
	
	
	/**
	 * @param price in pennies
	 * @return price / dividend (assumed to be the last dividend) or -1 if dividend =0
	 */
	public double peRatio(int price){
		if(stock==null)
			return -1;
		
		int div=stock.getLastDividend();
		
		return (div==0)?-1 : price / div;
	}
	
	
	/**
	 * Returns the volume weighted stock price for the last 15 minutes
	 * 
	 * @return sum(tradedprice_i * quantity_i) / sum(quantity) or 0 if there are no trades
	 */
	public double volumeWeightedStockPrice(){
		if(stock==null)
			return -1;
		ArrayList<Trade> trades = TradeDAOImpl.getInstance().getTradesLast15m(stock.getSymbol());
		double numerator = 0;
		double denominator = 0;
		for (Trade trade : trades) {
			numerator +=trade.getPrice()*trade.getQuantity();
			denominator += trade.getQuantity();
		}
		
		return (denominator ==0)? 0: numerator / denominator;
	}

	@Override
	public boolean addStock(Stock stock) {
		
		if( StockDAOImpl.getInstance().add(stock)){
			this.stock=stock;
			return true;
		}
		return false;
	}
	
}
