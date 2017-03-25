package pl.sda.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.MockitoAnnotations;
import pl.sda.order.*;
import pl.sda.order.exception.NoTransportSpecifiedException;
import pl.sda.transport.TransportCostCalculator;
import pl.sda.transport.TransportCostCalculatorImpl;
import pl.sda.transport.TransportRepositoryInMemoryImpl;
import pl.sda.transport.TransportType;
import pl.sda.suites.SlowTestCategory;

import java.math.BigDecimal;
import static org.junit.Assert.assertTrue;

/**
 * Created by pzawa on 25.03.2017.
 */
@Category(SlowTestCategory.class)
public class OrderPriceCalculatorImplTest {


    private OrderPriceCalculator orderPriceCalculator;
    private TransportCostCalculator transportCostCalculator;

    @Before
    public void setup(){
        transportCostCalculator = new TransportCostCalculatorImpl(new TransportRepositoryInMemoryImpl());
        orderPriceCalculator = new OrderPriceCalculatorImpl(transportCostCalculator);
    }

    @Before
    public void cleanup(){
        transportCostCalculator.clean();
    }

    @Test
    public void shouldCalculateTotalPriceReturnZeroWhenNoItems(){
        //given
        Order order = new Order(1, TransportType.POCZTA_POLSKA);

        //when
        BigDecimal totalPrice = orderPriceCalculator.calculateTotalPrice(order);

        //then
        assertTrue(totalPrice.compareTo(BigDecimal.ZERO) == 0);
    }

    @Test(expected = NoTransportSpecifiedException.class)
    public void shouldReturnExceptionWhenTransportNotSpecified(){
        //given
        Order order = new Order(1, null);

        //when
        BigDecimal totalPrice = orderPriceCalculator.calculateTotalPrice(order);
    }
}
