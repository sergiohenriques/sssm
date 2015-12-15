package simple.stock.market.service.impl;

import simple.stock.market.dac.impl.TradeDAOImpl;
import simple.stock.market.model.Trade;
import simple.stock.market.model.type.TradeType;
import simple.stock.market.service.TradeService;

public class TradeServiceImpl implements TradeService{

	@Override
	public boolean execTrade(String stock, int quantity, TradeType type, int price) {
		Trade trade = new Trade(stock, System.currentTimeMillis(), quantity, type, price);
		
		
		return TradeDAOImpl.getInstance().add(trade);
	}

	
	
	

}
