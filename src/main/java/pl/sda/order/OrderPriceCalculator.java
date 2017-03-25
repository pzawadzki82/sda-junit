package pl.sda.order;

import java.math.BigDecimal;

/**
 * Created by pzawa on 25.03.2017.
 */
public interface OrderPriceCalculator {

    BigDecimal calculateTotalPrice(Order order);
}
