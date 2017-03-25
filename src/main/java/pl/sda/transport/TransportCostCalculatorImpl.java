package pl.sda.transport;

import java.math.BigDecimal;

/**
 * Created by pzawa on 25.03.2017.
 */
public class TransportCostCalculatorImpl implements TransportCostCalculator{
    private TransportRepository transportRepository;

    public TransportCostCalculatorImpl(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public BigDecimal getTotalPrice(int itemQuantity, TransportType transportType)
    {
        BigDecimal unitTransportPrice = transportRepository.getTransportUnitPrice(transportType);
        return unitTransportPrice.multiply(BigDecimal.valueOf(itemQuantity));
    }

    @Override
    public void clean() {
        //Cleanup some resources
    }
}
