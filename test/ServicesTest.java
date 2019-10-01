import junit.framework.TestCase;
import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.services.ServiceFacade;
import org.junit.Test;

public class ServicesTest extends TestCase {

    @Test
    public void testLocationCreationFromAPI(){
        ServiceFacade sf = new ServiceFacade();
        Location l = sf.getLocation();
        assertEquals(l.getSolarHours(), 5);
        assertEquals(l.getCoordinate().getX(), 10.5);
        assertEquals(l.getCoordinate().getY(), 25.3);
        assertEquals(l.getSolarPower(),1001);

    }
    @Test
    public void testContractCreationFromAPI(){
        ServiceFacade sf = new ServiceFacade();
        Contract c = sf.getContract();
        assertEquals(c.getCost(), 999);


    }

}
