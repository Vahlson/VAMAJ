package main.java.model.SolarInstallation;

import java.util.ArrayList;
import java.util.List;

public class SolarInstallation {

    // Member variables
    private List <SolarPanel> solarPanels = new ArrayList <>();

    private double efficiency;
    private double InstallationsCost;
    private double spaceRequired;





    public SolarInstallation(List <SolarPanel> solarPanels, double efficiency, double cost, double spaceRequired) {
        this.solarPanels = solarPanels;

        this.efficiency = efficiency;
        this.InstallationsCost = cost;
        this.spaceRequired = spaceRequired;
    }

    public List <SolarPanel> getSolarPanels() {
        return solarPanels;
    }

    public void setSolarPanels(List <SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
    }



    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getInstallationsCost() {
        return InstallationsCost;
    }

    public double getSpaceRequired() {
        return spaceRequired;
    }

    public void setSpaceRequired(double spaceRequired) {
        this.spaceRequired = spaceRequired;
    }

    public void setInstallationsCost(double installationsCost) {
        this.InstallationsCost = installationsCost;
    }


}
