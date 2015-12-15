package test.simple.stock.market.service;

import org.junit.Assert;
import org.junit.Test;

import simple.stock.market.service.TradeService;

public class TradeServiceTest {

	@Test
	public final void testGBCEAllShareIndex() {
		Assert.assertTrue(TradeService.GBCEAllShareIndex()==Math.pow(16000000000.0, 1.0 / 5));
		Assert.assertFalse(TradeService.GBCEAllShareIndex()==0);
	}

}
