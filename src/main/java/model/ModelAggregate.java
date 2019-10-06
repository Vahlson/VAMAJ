package main.java.model;

import main.java.model.Property.Property;
import main.java.model.Calculator.Calculator;
import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.user.User;

import java.util.List;

public class ModelAggregate {

    private Calculator calculator;
    private User currentUser;
    private List<User> users;
    private Property property;

    // Setters in property
    void setPropertyLocation(Location l) {
        property.setLocation(l);
    }

    void setPropertyLatitude(double latitude) {
        property.setLatitude(latitude);
    }

    void setPropertyPanelAngle(int panelAngle) {
        property.setPanelAngle(panelAngle);
    }

    void setPropertyOrientation(int orientation) {
        property.setOrientation(orientation);
    }

    void setPropertyInstallationSpace(double installationSpace) {
        property.setInstallationSpace(installationSpace);
    }

    // Setters in contract
    void setContract(Contract c) {
        property.setContract(c);
    }

    void setContractCost(int cost) {
        property.getContract().setCost(cost);
    }
}
