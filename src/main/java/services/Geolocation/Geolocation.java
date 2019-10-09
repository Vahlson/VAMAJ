package services.Geolocation;

// Class that holds our geolocation data
public class Geolocation {

    // Member variables
    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;

    // Constructor (empty)
    public Geolocation(){

    }

    // Setters
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    // Getters
    public String getIpAddress() {
        return ipAddress;
    }

    public String getCity() {
        return city;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
