package main.java.model.solarsetup;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Representation of a premium solar panel. Concrete implementation of a solar panel.
// Used by: SolarSetup.
// Uses: Holds data specific to a premium type of solarpanel.

public class PremiumSolarPanel extends SolarPanel {

    public PremiumSolarPanel() {
        super(2, 10000, 0.3);
        setLifeExpectancy(30);
        setEfficiency(0.25);
        setProductionPerHour(getWattage());
        setAnnualOperationCost(getRetailPrice() * 0.015);
        setPerformanceRatio(0.9);
    }

}
