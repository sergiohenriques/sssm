package simple.stock.market.presentation;

import simple.stock.market.model.Stock;
import simple.stock.market.model.type.StockType;
import simple.stock.market.model.type.TradeType;
import simple.stock.market.service.StockService;
import simple.stock.market.service.impl.StockServiceImpl;
import simple.stock.market.service.impl.TradeServiceImpl;

public class SSSM {

	public static void main(String[] args) {
		StockService stockService = new StockServiceImpl();
		stockService.addStock(new Stock("TEA", StockType.COMMON, 0, 100));
		stockService.addStock(new Stock("POP", StockType.COMMON, 8, 100));
		stockService.addStock(new Stock("ALE", StockType.COMMON, 23, 60));
		stockService.addStock(new Stock("GIN", StockType.PREFERRED, 8,0.02, 100));
		stockService.addStock(new Stock("JOE", StockType.COMMON, 13, 250));
		

		TradeServiceImpl tradeService = new TradeServiceImpl();
		tradeService.execTrade("TEA",  100, TradeType.BUY, 200);
		tradeService.execTrade("GIN", 100, TradeType.BUY, 200);
		tradeService.execTrade("TEA", 150, TradeType.SELL, 100);
		tradeService.execTrade("ALE", 100, TradeType.SELL, 200);
	}

}
