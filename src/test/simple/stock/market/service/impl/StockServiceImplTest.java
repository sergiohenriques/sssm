package test.simple.stock.market.service.impl;

import org.junit.Assert;
import org.junit.Test;

import simple.stock.market.dac.StockDAO;
import simple.stock.market.dac.impl.StockDAOImpl;
import simple.stock.market.model.Stock;
import simple.stock.market.service.StockService;
import simple.stock.market.service.impl.StockServiceImpl;

public class StockServiceImplTest {

	
	private StockDAO stockDAO = StockDAOImpl.getInstance();
	
	
	@Test
	public final void testDividendYield() {
		Stock stock = stockDAO.getStock("TEA");
		StockService stockService = new StockServiceImpl(stock);
		Assert.assertTrue(stockService.dividendYield(10)== stockService.commonDividendYield(10));
		stockService = new StockServiceImpl("GIN");
		Assert.assertTrue(stockService.dividendYield(10)== stockService.preferredDividendYield(10));

	}

	@Test
	public final void testCommonDividendYield() {
		StockService stockService = new StockServiceImpl("TEA");
		Assert.assertTrue("expected -1,0", -1 == stockService.commonDividendYield(0));
		Assert.assertTrue("0/10=0", 0 == stockService.commonDividendYield(10));
		stockService = new StockServiceImpl("JOE");
		Assert.assertTrue("13/13=1", 1 == stockService.commonDividendYield(13));
	}

	@Test
	public final void testPreferredDividendYield() {
		StockService stockService = new StockServiceImpl("GIN");
		Assert.assertTrue(-1 == stockService.preferredDividendYield(0));
		Assert.assertTrue("0,02*100/10 = 0,2", 0.2 == stockService.preferredDividendYield(10));
		stockService = new StockServiceImpl("TEA");
		Assert.assertTrue("fixed dividend is 0,0", -1 == stockService.preferredDividendYield(10));
	}

	@Test
	public final void testPeRatio() {
		StockService stockService = new StockServiceImpl("GIN");
		Assert.assertEquals("80/8=10", 10,0 , stockService.peRatio(80));
		stockService = new StockServiceImpl("TEA");
		Assert.assertEquals("fixed dividend is 0,0", 0,0 , stockService.peRatio(10));
	}

	@Test
	public final void testVolumeWeightedStockPrice() {
		StockService stockService = new StockServiceImpl("TEA");
		Assert.assertTrue("expected calculation for the list setup", (100*200+150*100)/250== stockService.volumeWeightedStockPrice());
		stockService = new StockServiceImpl("JOE");
		Assert.assertTrue("This action does not has any trades", 0.0== stockService.volumeWeightedStockPrice());
		
	}

}
