package pl.sda.suites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.sda.OrderPriceCalculatorImplTest;
import pl.sda.TransportCostCalculatorImplTest;

/**
 * Created by pzawa on 25.03.2017.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTestCategory.class)
@Suite.SuiteClasses({OrderPriceCalculatorImplTest.class, TransportCostCalculatorImplTest.class})
public class SlowTestSuite {
}
