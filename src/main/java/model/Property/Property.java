package main.java.model.Property;

import main.java.model.Contract.Contract;

public class Property {

    // Member variables
    private Location location;
    private Contract contract;
    private double availableSpace;
    private int orientation;
    private int angle;
    private double latitude;

    // Constructor (empty)
    public Property() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public Contract getContract() {
        return contract;
    }

    public double getInstallationSpace() { return availableSpace; }

    public int getOrientation() { return orientation; }

    public int getPanelAngle() { return angle; }

    // Setters
    public void setInstallationSpace(double installationSpace) { this.availableSpace = installationSpace; }

    public void setOrientation(int orientation) { this.orientation = orientation; }

    public void setPanelAngle(int panelAngle) { this.angle = panelAngle; }
}
