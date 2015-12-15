package test.simple.stock.market.dac.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import simple.stock.market.dac.impl.TradeDAOImpl;
import simple.stock.market.model.Trade;
import simple.stock.market.model.type.TradeType;

public class TradeDAOImplTest {
	private TradeDAOImpl tradeDAO = TradeDAOImpl.getInstance();




	@Test
	public final void testAdd() {
		Assert.assertTrue(tradeDAO.add(new Trade("TEA", System.currentTimeMillis()-10000000, 10000, TradeType.BUY, 20)));
		Assert.assertFalse(tradeDAO.add(new Trade("TEST", System.currentTimeMillis()-1000000, 10000, TradeType.BUY, 20)));

	}

	@Test
	public final void testGetTradesLast15m() {
		addTrades();
		Assert.assertTrue(tradeDAO.getTradesLast15m("GIN").size()==1);
		Assert.assertTrue(tradeDAO.getTradesLast15m("ALE").size()==0);
		Assert.assertTrue(tradeDAO.getTradesLast15m("TEST").size()==0);
	}
	
	
	private void addTrades(){
		tradeDAO.add(new Trade("TEA", System.currentTimeMillis(), 100, TradeType.BUY, 200));
		tradeDAO.add(new Trade("GIN", System.currentTimeMillis(), 100, TradeType.BUY, 200));
		tradeDAO.add(new Trade("TEA", System.currentTimeMillis()-500000, 150, TradeType.SELL, 100));
		tradeDAO.add(new Trade("ALE", System.currentTimeMillis()-6000000, 100, TradeType.SELL, 200));
		
	}

}
