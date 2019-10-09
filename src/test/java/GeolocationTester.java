import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.DomainResponse;
import com.maxmind.geoip2.record.Location;
import junit.framework.TestCase;
import org.junit.Test;
import services.Geolocation.GeolocationService;

import java.io.IOException;

public class GeolocationTester extends TestCase {

    @Test
    public void test() throws IOException, GeoIp2Exception {
        GeolocationService service;
        service = new GeolocationService();

        CityResponse data;
        data = service.getData("");

        System.out.println(data.getCity());
    }
}
