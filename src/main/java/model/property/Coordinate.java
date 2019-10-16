package main.java.model.property;

public class Coordinate {
    private final Double latitude;
    private final Double longitude;

    public Coordinate(Double x, Double y) {
        this.latitude = x;
        this.longitude = y;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}