package main.java.model.property;

public class Location {
    private Coordinate coordinate;
    private double solarInsolation;

    // Constructor
    public Location(){

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
        this.coordinate = new Coordinate(latitude,longitude);
    }


    public void setSolarInsolation(double solarInsolation) {
        this.solarInsolation = solarInsolation;
    }
}
