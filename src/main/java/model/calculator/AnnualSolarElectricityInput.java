package main.java.model.calculator;

//(3) Vegard
//Class to contain input values of annualElectricityProduction calculation

public class AnnualSolarElectricityInput {
    private double latitude;
    private double solarPVPArea;
    private double solarPVEfficiency;

    public AnnualSolarElectricityInput(double latitude, double solarPVPArea, double solarPVEfficiency) {
        this.latitude = latitude;
        this.solarPVPArea = solarPVPArea;
        this.solarPVEfficiency = solarPVEfficiency;
    }

    double getLatitude() {
        return latitude;
    }

    double getSolarPVPArea() {
        return solarPVPArea;
    }

    double getSolarPVEfficiency() {
        return solarPVEfficiency;
    }
}
