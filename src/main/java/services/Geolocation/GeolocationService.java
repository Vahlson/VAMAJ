package services.Geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.DomainResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Class that fetches geolocation data using our API:s
public class GeolocationService {

    // Creating the database reader
    private DatabaseReader dbReader;

    // Constructor (empty)
    public GeolocationService() throws IOException {

        // Loading the database
        File database;
        database = new File("");

        // Instantiating the database reader
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public DomainResponse data(String ip) throws IOException, GeoIp2Exception {

        ip = "128.101.101.101";

        // Creating the ip address
        InetAddress ipAddress;
        ipAddress = InetAddress.getByName(ip);

        // Getting the location data from the ip address
        DomainResponse result;
        result = dbReader.domain(ipAddress);

        // Returning the result
        return result;
    }
}
