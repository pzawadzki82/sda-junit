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
import pl.sda.suites.FastTestCategory;
import pl.sda.transport.TransportCostCalculator;
import pl.sda.transport.TransportCostCalculatorImpl;
import pl.sda.transport.TransportRepository;
import pl.sda.transport.TransportType;

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
public class TransportCostCalculatorImplMockitoTest {
    @Mock
    private TransportRepository transportRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCalculateTotalPriceCallRepoMethod(){
        //given
        Mockito.when(transportRepository.getTransportUnitPrice(Matchers.anyObject())).thenReturn(BigDecimal.ZERO);
        TransportCostCalculator transportCostCalculator = new TransportCostCalculatorImpl(transportRepository);

        //when
        BigDecimal price = transportCostCalculator.getTotalPrice(1, TransportType.DHL);

        //then
        Mockito.verify(transportRepository, Mockito.atLeastOnce()).getTransportUnitPrice(Matchers.anyObject());
    }

}
