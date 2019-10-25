package main.java.model.solarsetup;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Representation of a standard solar panel. Concrete implementation of a solar panel.
// Used by: SolarSetup.
// Uses: Holds data specific to a standard type of solarpanel.

public class StandardSolarPanel extends SolarPanel {

    public StandardSolarPanel() {
        super(2, 7000, 0.25);
        setLifeExpectancy(25);
        setEfficiency(0.2);
        setProductionPerHour(getWattage());
        setAnnualOperationCost(getRetailPrice() * 0.01);
        setPerformanceRatio(0.8);
    }
}
