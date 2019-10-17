package model.solarsetup;

import java.util.List;

public class GroundBasedSolarSetup extends SolarSetup {
    public GroundBasedSolarSetup(List <SolarPanel> solarPanels, double totalEfficiency, double installationCost, double squareMeters) {
        super.setInstallationCost(installationCost);
        super.setSolarPanels(solarPanels);
        super.setSquareMeters(squareMeters);
        super.setTotalEfficiency(totalEfficiency);
    }

}
