package main.java.model.solarsetup;

import java.util.List;

public class RoofBasedSolarSetup extends SolarSetup {

    private double roofUnit;

    public RoofBasedSolarSetup(double installationCost, double squareMeters, double totalEfficiency) {
        super();
        super.setInstallationCost(installationCost);
        super.setSquareMeters(squareMeters);
        super.setTotalEfficiency(totalEfficiency);
    }

    public double getRoofUnit() {
        return this.roofUnit;
    }

    public void setRoofUnit(double roofUnit) {
        this.roofUnit = roofUnit;
    }
}
