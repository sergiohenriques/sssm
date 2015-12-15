package simple.stock.market.dac;

import simple.stock.market.model.Stock;

public interface StockDAO {
	
	public boolean add(Stock stock);
	
	public Stock getStock(String stockSymbol);

}
