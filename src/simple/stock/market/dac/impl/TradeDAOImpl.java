package simple.stock.market.dac.impl;

import java.util.ArrayList;
import java.util.Iterator;

import simple.stock.market.dac.StockDAO;
import simple.stock.market.dac.TradeDAO;
import simple.stock.market.model.Stock;
import simple.stock.market.model.Trade;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author sergio
 *
 */
public class TradeDAOImpl implements TradeDAO{

	
	ArrayList<Trade> tradeDB = new ArrayList<Trade>();
	
	private final long e15m=900*1000; 
	
	private static TradeDAOImpl tradeDAO;
	
	private static final Logger logger = LogManager.getLogger(TradeDAOImpl.class);
	 
	
	
	private TradeDAOImpl() {
		super();
	}
	
	/**
	 * 
	 * This Class uses a singleton to ensure that the same data is used everywhere on this exercise.
	 * @returns an instance for Trade DAO
	 * 
	 */
	public static synchronized TradeDAOImpl getInstance()
	{
		if (tradeDAO == null)
			tradeDAO = new TradeDAOImpl();

		return tradeDAO;
	}

	
	
	@Override
	public boolean add(Trade trade) {
		
		if (trade == null || StockDAOImpl.getInstance().getStock(trade.getStock())==null)
			return false;
		//adds to head to make searches for the last 15 minutes faster
		tradeDB.add(0,trade);
		
		logger.debug("Added trade:"+trade.toString());
		
		return true;
	}


	/**
	 * Returns the list of trades for a given stock on the last 15 minutes
	 * 
	 * @param stock
	 * @return
	 */
	public ArrayList<Trade> getTradesLast15m(String stock){
	
	ArrayList<Trade> res = new ArrayList<Trade>();
	long time = System.currentTimeMillis()-e15m;
	
	for (Trade trade : tradeDB) {
		if (trade.getStock().equals(stock) && trade.getTimestamp()>=time){
			res.add(trade);
		}			
	
	}
	return res;
	
	
	
	}

	public ArrayList<Trade> getTradeDB() {
		return tradeDB;
	}


	
}
