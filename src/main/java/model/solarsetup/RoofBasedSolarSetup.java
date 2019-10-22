package main.java.model.solarsetup;

//An implementation of the solarsetup that is roof based.
public class RoofBasedSolarSetup extends SolarSetup {

    private double roofUnit;

    public RoofBasedSolarSetup(double installationCost, double squareMeters) {
        super();
        super.setInstallationCost(installationCost);
        super.setAvailableSpace(squareMeters);

    }

    public double getRoofUnit() {
        return this.roofUnit;
    }

    public void setRoofUnit(double roofUnit) {
        this.roofUnit = roofUnit;
    }
}
