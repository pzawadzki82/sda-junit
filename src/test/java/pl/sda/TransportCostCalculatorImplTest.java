package pl.sda;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.Parameterized;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.sda.transport.TransportCostCalculator;
import pl.sda.transport.TransportCostCalculatorImpl;
import pl.sda.transport.TransportRepository;
import pl.sda.order.transport.TransportType;
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
public class TransportCostCalculatorImplTest {
    @Mock
    private TransportRepository transportRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCalculateTotalPriceCallRepoMethod(){
        Mockito.when(transportRepository.getTransportUnitPrice(Matchers.anyObject())).thenReturn(BigDecimal.ZERO);
        TransportCostCalculator transportCostCalculator = new TransportCostCalculatorImpl(transportRepository);
        BigDecimal price = transportCostCalculator.getTotalPrice(itemQty, transportType);
        Mockito.verify(transportRepository, Mockito.atLeastOnce()).getTransportUnitPrice(Matchers.anyObject());
    }

    // fields used together with @Parameter must be public
    @Parameterized.Parameter
    public int itemQty;
    @Parameterized.Parameter
    public TransportType transportType;

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 0 ,  TransportType.POCZTA_POLSKA }, { 1,  TransportType.POCZTA_POLSKA }, { 1,  TransportType.DHL } };
        return Arrays.asList(data);
    }

    @Test
    public void shouldCalculateTotalPrice(){
        Mockito.when(transportRepository.getTransportUnitPrice(Matchers.anyObject())).thenReturn(BigDecimal.ZERO);;
        TransportCostCalculator transportCostCalculator = new TransportCostCalculatorImpl(transportRepository);
        BigDecimal price = transportCostCalculator.getTotalPrice(itemQty, transportType);
        assertTrue(price.compareTo(BigDecimal.ZERO) == 0);
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFolder = folder.newFolder("newfolder");
        File createdFile = folder.newFile("myfilefile.txt");
        assertTrue(createdFile.exists());
    }


}
