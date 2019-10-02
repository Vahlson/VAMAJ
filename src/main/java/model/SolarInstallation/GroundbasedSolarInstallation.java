package main.java.model.SolarInstallation;

import java.util.List;

public class GroundbasedSolarInstallation extends SolarInstallation {
    public GroundbasedSolarInstallation(List <SolarPanel> solarPanels, double efficiency, double cost, double spaceRequired) {
        super(solarPanels, efficiency, cost, spaceRequired);
    }

}
