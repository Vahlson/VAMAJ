package services.Geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

// Class that fetches geolocation data using our API:s
public class GeolocationService {

    // Creating the database reader
    private DatabaseReader dbReader;

    // Constructor (empty)
    public GeolocationService() throws IOException {

        // Creating the path as a string
        String path;
        path ="C:\\Users\\Alexander\\Documents\\VAMAJ\\src\\main\\resources\\databases\\geolocation\\GeoLite2-City.mmdb";

        // Loading the database
        File database;
        database = new File(path);

        // Instantiating the database reader
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public CityResponse getData(String ip) throws IOException, GeoIp2Exception {

        ip = "128.101.101.101";

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
