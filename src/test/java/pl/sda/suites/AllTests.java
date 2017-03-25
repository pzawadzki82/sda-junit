package pl.sda.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.sda.order.OrderPriceCalculatorImplTest;
import pl.sda.transport.TransportCostCalculatorImplParametrizedTest;

/**
 * Created by pzawa on 25.03.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TransportCostCalculatorImplParametrizedTest.class,
        OrderPriceCalculatorImplTest.class })
public class AllTests {
}
