package test.simple.stock.market.service.impl;

import org.junit.Assert;
import org.junit.Test;

import simple.stock.market.model.type.TradeType;
import simple.stock.market.service.impl.TradeServiceImpl;

public class TradeServiceImplTest {

	@Test
	public final void testExecTrade() {
		TradeServiceImpl tradeService = new TradeServiceImpl();
		Assert.assertTrue(tradeService.execTrade("JOE", 1000, TradeType.BUY, 150));
		Assert.assertTrue(tradeService.execTrade("JOE", 0, TradeType.BUY, 150));
		
	}

}
