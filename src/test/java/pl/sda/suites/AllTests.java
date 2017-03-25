package pl.sda.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.sda.OrderPriceCalculatorImplTest;
import pl.sda.TransportCostCalculatorImplTest;

/**
 * Created by pzawa on 25.03.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TransportCostCalculatorImplTest.class,
        OrderPriceCalculatorImplTest.class })
public class AllTests {
}
