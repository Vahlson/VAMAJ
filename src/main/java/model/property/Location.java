package main.java.model.property;


// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Representation of a location.
// Used by: ModelFacade, ModelAggregate, ServiceFacade, Property, ILocationCreator. (Yes that's alot...)
// Uses: Holds data specific to a location and that is useful in calculations.

public class Location {
    private Coordinate coordinate;
    private double solarInsolation;

    // Constructor
    public Location() {

    }

    public Location(Coordinate coordinate, double solarInsolation) {
        this.coordinate = coordinate;
        this.solarInsolation = solarInsolation;
    }

    // Getters
    public double getSolarInsolation() {
        return solarInsolation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    // Setters
    public void setCoordinate(double latitude, double longitude) {
        this.coordinate = new Coordinate(latitude, longitude);
    }

    public void setSolarInsolation(double solarInsolation) {
        this.solarInsolation = solarInsolation;
    }
}
