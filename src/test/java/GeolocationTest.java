import junit.framework.TestCase;
import org.junit.Test;
import main.java.services.Geolocation.Geolocation;


public class GeolocationTest extends TestCase {

    @Test
    public void testGeolocation() {

        Geolocation location;
        location = new Geolocation(getClass().getResource("/databases/geolocation/GeoLite2-City.mmdb").getPath());

        assertEquals(location.getCity(), "Gothenburg");
    }
}
