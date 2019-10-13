import junit.framework.TestCase;
import org.junit.Test;
import services.Geolocation.Geolocation;


public class GeolocationTest extends TestCase {


    @Test
    public void testGeolocation() {

       Geolocation location;
         location = new Geolocation();
        assertEquals(location.getCity(), "Stockholm");
    }
}
