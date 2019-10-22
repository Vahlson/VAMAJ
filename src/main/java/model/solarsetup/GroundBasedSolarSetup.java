package main.java.model.solarsetup;

//An implementation of the solarsetup that is ground based.
public class GroundBasedSolarSetup extends SolarSetup {

    public GroundBasedSolarSetup(double installationCost, double squareMeters) {
        super();
        super.setInstallationCost(installationCost);
        super.setAvailableSpace(squareMeters);

    }

}
