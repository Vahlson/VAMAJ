import junit.framework.TestCase;
import org.junit.Test;
import services.Geolocation.Geolocation;


public class GeolocationTest extends TestCase {

    @Test
    public void test() {

        Geolocation location;
        location = new Geolocation();

        System.out.println(location.getCity());
        System.out.println(location.getLatitude());
        System.out.println(location.getLongitude());
    }
}
