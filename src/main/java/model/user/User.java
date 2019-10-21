package main.java.model.user;

import main.java.model.property.ConsumingProperty;
import main.java.model.property.Property;

import java.util.ArrayList;
import java.util.List;

//The user of the program, the highest level object in the model.
public class User {

    // Member variables
    private List<Property> properties;
    private Property activeProperty;

    // Constructor (empty)
    public User() {
        properties = new ArrayList<>();
        activeProperty = new ConsumingProperty();
        properties.add(activeProperty);
    }

    // Getters (do we really want to expose the property to other classes? Maybe it is better to expose its getters/setters)
    public Property getActiveProperty() {
        return activeProperty;
    }
}
