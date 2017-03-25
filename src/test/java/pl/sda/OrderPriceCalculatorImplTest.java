package pl.sda;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.MockitoAnnotations;
import pl.sda.order.*;
import pl.sda.order.exception.NoTransportSpecifiedException;
import pl.sda.transport.TransportCostCalculatorImpl;
import pl.sda.transport.TransportRepositoryInMemoryImpl;
import pl.sda.order.transport.TransportType;
import pl.sda.suites.SlowTestCategory;

import java.math.BigDecimal;
import static org.junit.Assert.assertTrue;

/**
 * Created by pzawa on 25.03.2017.
 */
@Category(SlowTestCategory.class)
public class OrderPriceCalculatorImplTest {


    private OrderPriceCalculator orderPriceCalculator;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        orderPriceCalculator = new OrderPriceCalculatorImpl(new TransportCostCalculatorImpl(new TransportRepositoryInMemoryImpl()));
    }


    @Test
    public void shouldCalculateTotalPriceReturnZeroWhenNoItems(){
        Order order = new Order(1, TransportType.POCZTA_POLSKA);
        BigDecimal totalPrice = orderPriceCalculator.calculateTotalPrice(order);
        assertTrue(totalPrice.compareTo(BigDecimal.ZERO) == 0);
    }

    @Test(expected = NoTransportSpecifiedException.class)
    public void shouldReturnExceptionWhenTransportNotSpecified(){
        Order order = new Order(1, null);
        BigDecimal totalPrice = orderPriceCalculator.calculateTotalPrice(order);
    }
}
