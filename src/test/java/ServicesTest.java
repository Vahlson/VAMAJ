
import junit.framework.TestCase;
import main.java.model.property.Location;
import main.java.model.contract.Contract;
import main.java.services.ServiceFacade;
import org.junit.Test;

public class ServicesTest extends TestCase {

    @Test
    public void testLocationCreationFromAPI(){
        ServiceFacade sf = new ServiceFacade();
       // sf.setLocationCreatorCoordinates(63.825848,20.263035);
        Location l = sf.getLocation();
        assertNotNull(l);
        assertEquals(l.getCoordinate().getLatitude(), 63.825848);
        assertEquals(l.getCoordinate().getLongitude(), 20.263035);
        assertTrue(l.getSolarInsolation() > 0 && l.getSolarInsolation() < 50);

        sf.setLocationCreatorCoordinates(0,0);
        l = sf.getLocation();
        assertNotNull(l);


    }



}
