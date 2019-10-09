package services.Geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

// Class that fetches geolocation data using our API:s
public class GeolocationService {

    // Creating the database reader
    private DatabaseReader dbReader;

    // Constructor (empty)
    public GeolocationService() throws IOException {

        try {
            URL res = getClass().getClassLoader().getResource("databases/geolocation/GeoLite2-City.mmdb");

            // Loading the database
            File database;
            database = Paths.get(Objects.requireNonNull(res).toURI()).toFile();

            // Instantiating the database reader
            dbReader = new DatabaseReader.Builder(database).build();
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
    }

    public CityResponse getData(String ip) throws IOException, GeoIp2Exception {

        ip = "129.16.168.189";

        // Creating the ip address
        InetAddress ipAddress;
        ipAddress = InetAddress.getByName(ip);

        // Creating the CityResponse
        CityResponse response;
        response = dbReader.city(ipAddress);

        // Returning the result
        return response;
    }
}
