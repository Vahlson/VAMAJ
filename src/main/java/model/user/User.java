package main.java.model.user;

import main.java.model.Property.Property;

import java.util.ArrayList;
import java.util.List;

public class User {

    // Member variables
    private List<Property> properties;
    private Property activeProperty;

    // Constructor (empty)
    public User() {
        properties = new ArrayList<>();
        activeProperty = new Property();
        properties.add(activeProperty);
    }

    // Getters (do we really want to expose the property to other classes? Maybe it is better to expose its getters/setters)
    public Property getActiveProperty() {
        return activeProperty;
    }
}
