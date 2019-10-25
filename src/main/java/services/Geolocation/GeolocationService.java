package main.java.services.Geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: A sort of adapter toward the geolocation database.
// Used by: Geolocation.
// Uses: Creates a connection to the API database so that geolocation data can be gathered.

class GeolocationService {

    // Creating the database reader
    private DatabaseReader dbReader;

    // Constructor (empty)
    GeolocationService(String url) {

        try {

            // Instantiating the database reader
            dbReader = new DatabaseReader.Builder(new File(url)).build();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Method that returns a CityResponse object based on given ip address
    CityResponse getData(String ip) throws IOException, GeoIp2Exception {

        // Creating the ip address
        InetAddress ipAddress;
        ipAddress = InetAddress.getByName(ip);

        if (dbReader == null) {
            return null;
        }

        // Creating the CityResponse
        CityResponse response;
        response = dbReader.city(ipAddress);

        // Returning the result
        return response;
    }
}
