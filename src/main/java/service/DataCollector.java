package main.java.service;

import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.service.ContractData;
import main.java.service.Data;
import main.java.service.LocationData;

//(3.1) ALEX LV
//Factory that creates objects from data gathered from API:s.
public class DataCollector {


    //Creates a location object based on a locationdataobject provided by an API or file.
    public Location getLocation(){

        Data ld = new LocationData();

    return (Location) ld.getData();
    }

    //Creates a contract object based on a contractdataobject provided by an API or file.
    public Contract getContract(){

        Data cd = new ContractData();

        return (Contract) cd.getData();
    }


}
