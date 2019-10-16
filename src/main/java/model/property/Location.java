package main.java.model.property;

public class Location {
    final private Coordinate coordinate;
    final private double solarInsolation;

    // Constructor
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

    // Setters (mutate by copy)
    public Location setCoordinate(double latitude, double longitude) {
        return new Location(new Coordinate(latitude, longitude), solarInsolation);
    }


    public Location setSolarInsolation(double solarInsolation) {
        return new Location(coordinate, solarInsolation);
    }
}
