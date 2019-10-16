package main.java.model.property;

public class Location {
    //private int solarHours;
    //private int solarPower;
    private Coordinate coordinate;

    private double solarInsolation;


    public Coordinate getCoordinate() {
        return coordinate;
    }


    public void setCoordinate(double latitude, double longitude) {
        Coordinate c = new Coordinate(latitude,longitude);
        this.coordinate = c;
    }


    public void setSolarInsolation(double solarInsolation) {
        this.solarInsolation = solarInsolation;
    }

    public double getSolarInsolation() {
        return solarInsolation;
    }
    //    public int getSolarPower() {
//        return solarPower;
//    }

    //    public void setSolarPower(int solarPower) {
//        this.solarPower = solarPower;
//    }

    //    public int getSolarHours() {
//        return solarHours;
//    }


    //    public void setSolarHours(int solarHours) {
//        this.solarHours = solarHours;
//    }
}
