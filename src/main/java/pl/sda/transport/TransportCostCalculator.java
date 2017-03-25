package pl.sda.transport;

import java.math.BigDecimal;

/**
 * Created by pzawa on 25.03.2017.
 */
public interface TransportCostCalculator {

    BigDecimal getTotalPrice(int itemQuantity, TransportType transportType);

    void clean();
}
