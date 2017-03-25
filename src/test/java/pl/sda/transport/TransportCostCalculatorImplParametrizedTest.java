package pl.sda.transport;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.sda.transport.TransportCostCalculator;
import pl.sda.transport.TransportCostCalculatorImpl;
import pl.sda.transport.TransportRepository;
import pl.sda.transport.TransportType;
import pl.sda.suites.FastTestCategory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by pzawa on 25.03.2017.
 */
@Category(FastTestCategory.class)
@RunWith(Parameterized.class)
public class TransportCostCalculatorImplParametrizedTest {

    // fields used together with @Parameter must be public
    @Parameterized.Parameter(0)
    public int itemQty;
    @Parameterized.Parameter(1)
    public TransportType transportType;

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 0 ,  TransportType.POCZTA_POLSKA }, { 1,  TransportType.POCZTA_POLSKA }, { 1,  TransportType.DHL } };
        return Arrays.asList(data);
    }

    @Test
    public void shouldCalculateTotalPrice(){
        //given
        TransportCostCalculator transportCostCalculator = new TransportCostCalculatorImpl(new TransportRepositoryInMemoryImpl());
        BigDecimal expectedTransportPrice = BigDecimal.ONE.multiply(BigDecimal.valueOf(itemQty));

        //when
        BigDecimal price = transportCostCalculator.getTotalPrice(itemQty, transportType);

        //then
        assertTrue(price.compareTo(expectedTransportPrice) == 0);
    }
}
