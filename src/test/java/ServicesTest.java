package test.java;

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
        assertEquals(l.getCoordinate().getLatitude(), 63.825848);
        assertEquals(l.getCoordinate().getLongitude(), 20.263035);


    }
    @Test
    public void testContractCreationFromAPI(){
        ServiceFacade sf = new ServiceFacade();
        Contract c = sf.getContract();
        assertEquals(c.getCost(), 999);


    }

}
