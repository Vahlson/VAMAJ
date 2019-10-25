package main.java.model.property;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Representation of a coordinate
// Used by: Location.
// Uses: holds a latitude and a longitude.

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