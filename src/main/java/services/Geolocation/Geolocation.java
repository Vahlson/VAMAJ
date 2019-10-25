package main.java.services.Geolocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.IOException;

// Class that holds our geolocation data
public class Geolocation implements IGeolocation {

    // Member variables
    private GeolocationService service;
    private String ipAddress;
    private String city;
    private double latitude;
    private double longitude;

    // Constructor (empty)
    public Geolocation(String url) {

        // Getting the ip address
        String ip = null;
        try {
            ip = IPAddress.getIp();
            if (ip == null){
                this.city = "Could not retrieve IP";
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Getting the location data from the service
        try {
            // Tries to load the database
            service = new GeolocationService(url);


            CityResponse data;
            data = service.getData(ip);

            if (data == null) {
                this.city = "Error loading database! \n Path to database may be incorrect.";
                return;
            }

            // Fetching the data
            this.city = data.getCity().getName();
            this.latitude = data.getLocation().getLatitude();
            this.longitude = data.getLocation().getLongitude();

        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }
    }

    // Getters
//    public String getIpAddress() {
//        return ipAddress;
//    }


    @Override
    public String getCity() {
        return city;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }
}
