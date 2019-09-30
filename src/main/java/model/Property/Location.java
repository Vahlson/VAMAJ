package main.java.model.Property;

public class Location {
    private int solarHours;
    private Coordinate coordinate;
    private int solarPower;

    public int getSolarHours() {
        return solarHours;
    }

    public void setSolarHours(int solarHours) {
        this.solarHours = solarHours;
    }

    public void setCoordinate(double x, double y) {
        Coordinate c = new Coordinate(x,y);
        this.coordinate = c;
    }

    public void setSolarPower(int solarPower) {
        this.solarPower = solarPower;
    }
}
