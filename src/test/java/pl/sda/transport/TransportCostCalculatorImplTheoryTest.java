package pl.sda.transport;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

/**
 * Created by pzawa on 25.03.2017.
 */
@RunWith(Theories.class)
public class TransportCostCalculatorImplTheoryTest {
    @DataPoints
    public static int[] itemQty = { 1,2,3,4,5 };


    @DataPoints
    public static TransportType[] transportTypes = { TransportType.DHL, TransportType.DPD, TransportType.POCZTA_POLSKA };

    @Theory
    public void shouldCalculateTotalPrice(int itemQty, TransportType transportType){
        //given
        TransportCostCalculator transportCostCalculator = new TransportCostCalculatorImpl(new TransportRepositoryInMemoryImpl());
        BigDecimal expectedTransportPrice = BigDecimal.ONE.multiply(BigDecimal.valueOf(itemQty));

        //when
        BigDecimal price = transportCostCalculator.getTotalPrice(itemQty, transportType);

        //then
        assertTrue(price.compareTo(expectedTransportPrice) == 0);
    }

}
