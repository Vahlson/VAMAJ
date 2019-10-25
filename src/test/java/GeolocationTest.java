import junit.framework.TestCase;
import org.junit.Test;
import main.java.services.Geolocation.Geolocation;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Test class for the geolocation package.


public class GeolocationTest extends TestCase {

    @Test
    public void testGeolocation() {

        Geolocation location;
        location = new Geolocation(getClass().getResource("/databases/geolocation/GeoLite2-City.mmdb").getPath());

        assertTrue(location.getCity() != null);
    }
}
