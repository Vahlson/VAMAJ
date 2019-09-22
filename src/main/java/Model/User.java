package main.java.Model;

import main.java.Model.Property.Property;

import java.util.ArrayList;
import java.util.List;

public class User {

    // Member variables
    private List<Property> properties = new ArrayList<>();
    private Property activeProperty;

    // Constructor (empty)
    public User() {
    }

    // Getters
    public Property getActiveProperty() {
        return activeProperty;
    }
}
