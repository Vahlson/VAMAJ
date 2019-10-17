package model.user;

import model.property.ConsumingProperty;
import model.property.Property;

import java.util.ArrayList;
import java.util.List;

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
