package model.SolarSetup;

import java.util.List;

public class RoofBasedSolarSetup extends SolarSetup {

    private double roofUnit;

    public RoofBasedSolarSetup(List <SolarPanel> solarPanels , double efficiency, double cost, double spaceRequired, double roofSpace) {
        super(solarPanels,  efficiency, cost, spaceRequired);
        this.roofUnit = roofSpace;
    }

    public double getRoofUnit() {
        return this.roofUnit;
    }





}
