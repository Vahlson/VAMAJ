package services.Geolocation;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Class that holds our geolocation data
public class Geolocation {

    // Member variables
    private GeolocationService service;
    private String ipAddress;
    private String city;
    private double latitude;
    private double longitude;

    // Constructor (empty)
    public Geolocation() {

        // Getting the ip address
        String ip = null;
        try {
            ip = IPAddress.getIp();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tries to load the database
        try {
            service = new GeolocationService();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // If service exists
        if (service != null) {

            // Getting the location data from the service
            try {
                CityResponse data;
                data = service.getData(ip);

                // Fetching the data
                this.city = data.getCity().getName();
                this.latitude = data.getLocation().getLatitude();
                this.longitude = data.getLocation().getLongitude();

            } catch (IOException | GeoIp2Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Getters
    public String getIpAddress() {
        return ipAddress;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
