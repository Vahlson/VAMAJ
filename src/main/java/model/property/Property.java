package main.java.model.property;

import main.java.model.contract.Contract;
import main.java.model.solarsetup.SolarSetup;

public class Property {

    // Member variables
    private SolarSetup solarSetup;
    private Location location;
    private Contract contract = new Contract();
    private double availableSpace;
    private int orientation;
    private int angle;
    private double latitude;
    private double consumption;

    // Constructor (empty)
    public Property() {
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public Contract getContract() {
        return contract;
    }

    public double getInstallationSpace() {
        return availableSpace;
    }

    public int getOrientation() {
        return orientation;
    }

    public int getPanelAngle() {
        return angle;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getConsumption() {
        return consumption;
    }

    public SolarSetup getSolarSetup() {
        return solarSetup;
    }

    // Setters
    public void setLocation(Location l) {
        this.location = l;
    }

    public void setInstallationSpace(double installationSpace) {
        this.availableSpace = installationSpace;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void setPanelAngle(int panelAngle) {
        this.angle = panelAngle;
    }

    public void setContract(Contract c) {
        this.contract = c;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
