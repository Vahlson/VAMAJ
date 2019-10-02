package main.java.model.SolarInstallation;

import java.util.List;

public class RoofbasedSolarInstallation extends SolarInstallation {

    private double roofUnit;

    public RoofbasedSolarInstallation(List <SolarPanel> solarPanels , double efficiency, double cost, double spaceRequired, double roofSpace) {
        super(solarPanels,  efficiency, cost, spaceRequired);
        this.roofUnit = roofSpace;
    }

    public double getRoofUnit() {
        return this.roofUnit;
    }





}
