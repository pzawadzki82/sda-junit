package pl.sda.suites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.sda.order.OrderPriceCalculatorImplTest;
import pl.sda.transport.TransportCostCalculatorImplParametrizedTest;

/**
 * Created by pzawa on 25.03.2017.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTestCategory.class)
@Suite.SuiteClasses({OrderPriceCalculatorImplTest.class, TransportCostCalculatorImplParametrizedTest.class})
public class SlowTestSuite {
}
