package pl.sda.transport;

import java.math.BigDecimal;

/**
 * Created by pzawa on 25.03.2017.
 */
public class TransportRepositoryInMemoryImpl implements TransportRepository{

    public BigDecimal getTransportUnitPrice(TransportType transportType){
        return BigDecimal.ZERO;
    }

}
