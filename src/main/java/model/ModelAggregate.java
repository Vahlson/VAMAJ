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


    void setLocation(Location l) {
        property.setLocation(l);
    }

    void setContract(Contract c) {
        property.setContract(c);
    }
}
