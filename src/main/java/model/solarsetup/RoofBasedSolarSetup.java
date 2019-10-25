package main.java.model.solarsetup;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Representation of a roof based solar setup. Concrete implementation of a solar setup.
// Used by: ModelAggregate.
// Uses: Holds data specific to a roof based solar setup.
// (extensibility possibilities) Useful for storing specific properties of a roof based solar setup, for more specific calculations.
//  Ex: altitude, roof angle...

public class RoofBasedSolarSetup extends SolarSetup {

    public RoofBasedSolarSetup(double installationCost, double squareMeters) {
        super();
        super.setInstallationCost(installationCost);
        super.setAvailableSpace(squareMeters);

    }

}
