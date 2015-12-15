package simple.stock.market.dac.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simple.stock.market.dac.StockDAO;
import simple.stock.market.model.Stock;

public class StockDAOImpl implements StockDAO{
	
	ArrayList<Stock> stockDB = new ArrayList<Stock>();

	private static StockDAOImpl stockDAO;
	
	private static final Logger logger = LogManager.getLogger(StockDAOImpl.class);
	
	private StockDAOImpl() {
		super();
	}
	
	/**
	 * 
	 * This Class uses a singleton to ensure that the same data is used everywhere on this exercise.
	 * @return an instance of StockDAOImpl
	 */
	public static synchronized StockDAOImpl getInstance()
	{
		if (stockDAO == null)
			stockDAO = new StockDAOImpl();

		return stockDAO;
	}

	@Override
	public boolean add(Stock stock) {
		//ads to head to make searches for the last 15 minutes faster
		
		if(stock == null || getStock(stock.getSymbol())!=null){
			return false;
		}
		stockDB.add(0,stock);
		
		logger.debug("Added stock:"+stock.toString());
		
		return true;
	}

	@Override
	public Stock getStock(String stockSymbol) {
		for (Stock stock : stockDB) {
			if (stockSymbol.equals(stock.getSymbol())){
				return stock;
			}
		}
		
		return null;
	}



}
