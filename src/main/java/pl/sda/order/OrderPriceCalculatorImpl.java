package pl.sda.order;

import pl.sda.order.exception.NoTransportSpecifiedException;
import pl.sda.transport.TransportCostCalculator;

import java.math.BigDecimal;

/**
 * Created by pzawa on 25.03.2017.
 */
public class OrderPriceCalculatorImpl implements OrderPriceCalculator{
    private TransportCostCalculator transportCostCalculator;

    public OrderPriceCalculatorImpl(TransportCostCalculator transportCostCalculator){
        this.transportCostCalculator = transportCostCalculator;
    }

    @Override
    public BigDecimal calculateTotalPrice(Order order) {
        if(order.getTransportType() == null){
            throw new NoTransportSpecifiedException();
        }
        return BigDecimal.ZERO;
    }
}
