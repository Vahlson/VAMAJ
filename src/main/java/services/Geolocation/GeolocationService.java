package main.java.services.Geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import main.java.Main;

import java.io.*;
import java.net.InetAddress;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

// Class that fetches geolocation data using our API:s
class GeolocationService {

    // Creating the database reader
    private DatabaseReader dbReader;

    // Constructor (empty)
    GeolocationService() {

        try {

            // Finds the directory of the database
            File f = new File(System.getProperty("java.class.path"));
            File dir = f.getAbsoluteFile().getParentFile();
            String path = dir.toString();
            path += "\\classes\\databases\\geolocation\\GeoLite2-City.mmdb";

            // Instantiating the database reader
            dbReader = new DatabaseReader.Builder(new File(path)).build();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Method that returns a CityResponse object based on given ip address
    CityResponse getData(String ip) throws IOException, GeoIp2Exception {

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
