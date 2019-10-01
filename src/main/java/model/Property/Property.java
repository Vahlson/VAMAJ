package main.java.model.Property;

import main.java.model.Contract.Contract;

public class Property {

    // Member variables
    private Location location;
    private Contract contract;
    private double availableSpace;
    private int orientation;
    private int angle;

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
}
