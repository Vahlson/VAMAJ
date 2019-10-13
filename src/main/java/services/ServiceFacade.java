package services;

import model.Contract.Contract;
import model.Property.Location;
import services.ContractCreator.ContractCreatorAPI;
import services.ContractCreator.IContractCreator;
import services.LocationCreator.ILocationCreator;
import services.LocationCreator.LocationCreatorAPI;

//(3.1) Alex LV och Alex Ask
//The service package facade, meaning interface that exposes wanted functionality outward from the service package.
public class ServiceFacade {

    // Creation of data grabbers, defaults to getting data from APIs.
    private ILocationCreator locationCreator = new LocationCreatorAPI(); // Initialized to mock class for now
    private IContractCreator contractCreator = new ContractCreatorAPI(); // Initialized to mock class for now

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
