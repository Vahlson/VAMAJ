package main.java.model.solarsetup;


// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Representation of a ground based solar setup. Concrete implementation of a solar setup.
// Used by: ModelAggregate.
// Uses: Holds data specific to a ground based solar setup.
// (extensibility possibilities) Useful for storing specific properties of a ground based solar setup, for more specific calculations.
//  Ex: shade information, "sun following systems"...

public class GroundBasedSolarSetup extends SolarSetup {

    public GroundBasedSolarSetup(double installationCost, double squareMeters) {
        super();
        super.setInstallationCost(installationCost);
        super.setAvailableSpace(squareMeters);

    }

}
