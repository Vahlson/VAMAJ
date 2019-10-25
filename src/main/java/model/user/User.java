package main.java.model.user;

import main.java.model.property.ConsumingProperty;
import main.java.model.property.Property;

import java.util.ArrayList;
import java.util.List;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: The user of the program, the highest level object in the model.
// Used by: ModelAggregate.
// Uses: Holds the rest of the model data, specific to the user. Created with exensibility in mind (multiple users)

public class User {

    // Member variables
    private List<Property> properties;
    private Property activeProperty;

    // Constructor (empty)
    public User() {
        properties = new ArrayList<>();
        activeProperty = new ConsumingProperty();
        //properties.add(activeProperty); Sparas inte förrän på slutet.
    }

    // Getters
    public Property getActiveProperty() {
        return activeProperty;
    }

    public void setProperty(Property property) {
        activeProperty = property;
    }
}
