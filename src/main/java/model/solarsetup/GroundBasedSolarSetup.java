package main.java.model.solarsetup;

//An implementation of the solarsetup that is ground based.
public class GroundBasedSolarSetup extends SolarSetup {

    public GroundBasedSolarSetup(double installationCost, double squareMeters, double totalEfficiency) {
        super();
        super.setInstallationCost(installationCost);
        super.setSquareMeters(squareMeters);
        super.setTotalEfficiency(totalEfficiency);
    }

}
