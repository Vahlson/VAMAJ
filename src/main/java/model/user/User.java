package main.java.model.user;

import main.java.model.Property.Location;
import main.java.model.Property.Property;

import java.util.ArrayList;
import java.util.List;

public class User {

    // Member variables
    private List<Property> properties = new ArrayList<>();
    private Property activeProperty;

    // Constructor (empty)
    public User() {
    }

    // Getters (do we really want to expose the property to other classes? Maybe it is better to expose its getters/setters)
    public Property getActiveProperty() {
        return activeProperty;
    }

    // Setters
    public void setLocation(Location l) {
        activeProperty.setLocation(l);
    }
}
