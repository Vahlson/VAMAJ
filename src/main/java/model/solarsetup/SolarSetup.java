package main.java.model.solarsetup;

import java.util.ArrayList;
import java.util.List;

public class SolarSetup {

    // Member variables
    private List<SolarPanel> solarPanels = new ArrayList<>();

    private double efficiency;
    private double InstallationsCost;
    private double spaceRequired;
    private double availableRoofArea;
    private int orientation;
    private int angle;


    public SolarSetup(List<SolarPanel> solarPanels, double efficiency, double cost, double spaceRequired) {
        this.solarPanels = solarPanels;

        this.efficiency = efficiency;
        this.InstallationsCost = cost;
        this.spaceRequired = spaceRequired;
    }

    public List<SolarPanel> getSolarPanels() {
        return this.solarPanels;
    }

    public void setSolarPanels(List<SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
    }


    public double getEfficiency() {
        return this.efficiency;
    }


    public double getInstallationsCost() {
        return this.InstallationsCost;
    }

    public double getSpaceRequired() {
        return this.spaceRequired;
    }

    public double getAvailableRoofArea() {
        return availableRoofArea;
    }

    public int getOrientation() {
        return orientation;
    }

    public int getPanelAngle() {
        return angle;
    }
}
