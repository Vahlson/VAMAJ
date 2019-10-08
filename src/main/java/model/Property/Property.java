package main.java.model.Property;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;

public class Property {

    // Member variables
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
