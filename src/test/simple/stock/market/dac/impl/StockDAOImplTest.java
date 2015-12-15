package test.simple.stock.market.dac.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import simple.stock.market.dac.StockDAO;
import simple.stock.market.dac.impl.StockDAOImpl;
import simple.stock.market.model.Stock;
import simple.stock.market.model.type.StockType;
import test.simple.stock.market.service.impl.StockServiceImplTest;

/**
 * @author sergio
 *
 *Setups the database for the test case
 */
public class StockDAOImplTest {
	private StockDAO stockDAO = StockDAOImpl.getInstance();;
	private static final Logger logger = LogManager.getLogger(StockServiceImplTest.class);



	@Test
	public final void testGetInstance() {
		Assert.assertNotNull(stockDAO);
		Assert.assertSame("Test that the same DAO is available",stockDAO, StockDAOImpl.getInstance());
	}
	
	@Test
	public final void testAdd() {
		Assert.assertTrue("Stock created",stockDAO.add(new Stock("JOE", StockType.COMMON, 13, 250)));
		Assert.assertFalse("Attempted to insert duplicated stock",stockDAO.add(new Stock("JOE", StockType.COMMON, 13, 250)));
		Assert.assertFalse("Attempted to add null object",stockDAO.add(null));
		
	}

	@Test
	public final void testGetStock() {
		Stock stock = new Stock("TEA", StockType.COMMON, 0, 100);
		stockDAO.add(stock);
		Assert.assertEquals(stockDAO.getStock("TEA").toString(),stock.toString());
	}
	
	@After
	public void tearDown() throws Exception {
		
		stockDAO.add(new Stock("POP", StockType.COMMON, 8, 100));
		stockDAO.add(new Stock("ALE", StockType.COMMON, 23, 60));
		stockDAO.add(new Stock("GIN", StockType.PREFERRED, 8, 0.02, 100));
		logger.debug("Stock table populated.");
	}


}
