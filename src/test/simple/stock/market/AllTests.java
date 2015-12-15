package test.simple.stock.market;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.simple.stock.market.dac.impl.StockDAOImplTest;
import test.simple.stock.market.dac.impl.TradeDAOImplTest;
import test.simple.stock.market.service.TradeServiceTest;
import test.simple.stock.market.service.impl.StockServiceImplTest;
import test.simple.stock.market.service.impl.TradeServiceImplTest;



@RunWith(Suite.class)
@SuiteClasses({
	StockDAOImplTest.class,
	TradeDAOImplTest.class,
	StockServiceImplTest.class,
	TradeServiceTest.class,
	TradeServiceImplTest.class
})
public class AllTests {

}
