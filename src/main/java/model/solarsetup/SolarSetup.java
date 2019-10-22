package main.java.model.solarsetup;

import java.util.ArrayList;
import java.util.List;

//Object that holds the information about a solar setup.
public abstract class SolarSetup {

    // Member variables
    private List<SolarPanel> solarPanels;
    private double totalEfficiency;
    private double installationCost;
    private double squareMeters;
    private int orientation;
    private int angle;


    public SolarSetup() {
        this.solarPanels =  new ArrayList<>();
        this.totalEfficiency = 0;
        this.installationCost = 0;
        this.squareMeters = 0;
        this.orientation = 0;
        this.angle = 0;
    }

    //Getters
    public List<SolarPanel> getSolarPanels() {
        return this.solarPanels;
    }

    public SolarPanel getASolarPanel(){
        if(!solarPanels.isEmpty()) {
            return solarPanels.get(0);
        }
        return null;
    }
    public int getAngle() {
        return angle;
    }
    public double getTotalEfficiency() {
        return this.totalEfficiency;
    }

    public double getInstallationCost() {
        return this.installationCost;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public int getOrientation() {
        return orientation;
    }

    public int getPanelAngle() {
        return angle;
    }


    //Setters
    public void setSolarPanels(List<SolarPanel> solarPanels) {
        this.solarPanels = solarPanels;
    }


    public void setTotalEfficiency(double totalEfficiency) {
        this.totalEfficiency = totalEfficiency;
    }

    public void setInstallationCost(double installationCost) {
        this.installationCost = installationCost;
    }

    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
