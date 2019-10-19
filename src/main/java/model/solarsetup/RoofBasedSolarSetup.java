package main.java.model.solarsetup;

import java.util.List;

public class RoofBasedSolarSetup extends SolarSetup {

    private double roofUnit;

    public RoofBasedSolarSetup(List <SolarPanel> solarPanels , double totalEfficiency, double installationCost, double spaceRequired, double squareMeters) {
        super.setInstallationCost(installationCost);
        super.setSolarPanels(solarPanels);
        super.setSquareMeters(squareMeters);
        super.setTotalEfficiency(totalEfficiency);

    }

    public double getRoofUnit() {
        return this.roofUnit;
    }





}
