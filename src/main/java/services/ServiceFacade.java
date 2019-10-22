package main.java.services;

import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.services.ContractCreator.ContractCreatorAPI;
import main.java.services.ContractCreator.IContractCreator;
import main.java.services.Geolocation.Geolocation;
import main.java.services.Geolocation.IGeolocation;
import main.java.services.LocationCreator.ILocationCreator;
import main.java.services.LocationCreator.LocationCreatorAPI;

//(3.1) Alex LV och Alex Ask
//The service package facade, meaning interface that exposes wanted functionality outward from the service package.
public class ServiceFacade {

    // Creation of data grabbers, defaults to getting data from APIs.
    private ILocationCreator locationCreator = new LocationCreatorAPI(); // Initialized to mock class for now
    private IContractCreator contractCreator = new ContractCreatorAPI(); // Initialized to mock class for now
    private IGeolocation geolocation = new Geolocation();

    // Getters
    // Returns a Contract or Location respectively by the method decided by the dynamic class of the
    // location/contractCreator
    public Contract getContract() {
        return contractCreator.createContract();
    }

    public Location getLocation() {
        //TODO LÄgg till att den hämtar existerande lat och long?
        return locationCreator.createLocation();
    }

    public String getCity(){
        return geolocation.getCity();
    }

    public double getLatitude(){
        return geolocation.getLatitude();
    }

    public  double getLongitude(){
        return geolocation.getLongitude();
    }

    // Setters
    public void setLocationCreator(ILocationCreator creator) {
        this.locationCreator = creator;
    }

    public void setContractCreator(IContractCreator creator) {
        this.contractCreator = creator;
    }

    public void setLocationCreatorCoordinates(double latitude, double longitude){
        locationCreator.setLatitude(latitude);
        locationCreator.setLongitude(longitude);
    }
}
