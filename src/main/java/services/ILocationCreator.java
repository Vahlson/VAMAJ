package main.java.services;

import main.java.model.Property.Location;

//(3.1) Alex LV och Alex Ask
//Interface defining loaction object creators. Implementations create objects with data from different sources.
public interface ILocationCreator {

    Location createLocation();
}
