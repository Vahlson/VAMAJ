package main.java.services;

import main.java.model.contract.Contract;
import main.java.model.property.Location;

import main.java.services.Geolocation.Geolocation;
import main.java.services.Geolocation.IGeolocation;
import main.java.services.LocationCreator.ILocationCreator;
import main.java.services.LocationCreator.LocationCreatorAPI;

import java.io.File;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: The service package facade.
// Used by: PrimaryController.
// Uses: interface that exposes wanted functionality outward from the service package.

public class ServiceFacade {

    // Creation of data grabbers, defaults to getting data from APIs.
    private ILocationCreator locationCreator = new LocationCreatorAPI(); // Initialized to mock class for now
    private IGeolocation geolocation = new Geolocation(findResourcePath());

    // Method that finds the path to the database file
    private String findResourcePath() {

        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        String path = dir.toString();
        path += "/classes/databases/geolocation/GeoLite2-City.mmdb";

        return path;
    }

    // Getters
    // Returns a Location by the method decided by the dynamic class of the
    public Location getLocation() {
        //TODO LÄgg till att den hämtar existerande lat och long?
        return locationCreator.createLocation();
    }

    public String getCity() {
        return geolocation.getCity();
    }

    public double getLatitude() {
        return geolocation.getLatitude();
    }

    public double getLongitude() {
        return geolocation.getLongitude();
    }

    // Setters
    public void setLocationCreator(LocationCreatorAPI creator) {
        this.locationCreator = creator;
    }

    public void setLocationCreatorCoordinates(double latitude, double longitude) {
        locationCreator.setLatitude(latitude);
        locationCreator.setLongitude(longitude);
    }

}
