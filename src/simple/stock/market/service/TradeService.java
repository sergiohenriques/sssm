package simple.stock.market.service;

import java.util.ArrayList;

import simple.stock.market.dac.impl.TradeDAOImpl;
import simple.stock.market.model.Trade;
import simple.stock.market.model.type.TradeType;

public interface TradeService {

	
	public boolean execTrade(String stock, int quantity, TradeType type, int price);
	
	public static double GBCEAllShareIndex(){
		
	ArrayList<Trade> trades = TradeDAOImpl.getInstance().getTradeDB();
	long product = 1;
	
	for (Trade trade : trades) {
		product *= trade.getPrice();
	}
	
	
	return Math.pow(product, 1.0 / trades.size());
	
	}
	

}
