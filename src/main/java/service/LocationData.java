package main.java.service;

//(3.1) ALEX LV

import main.java.model.Property.Location;

public class LocationData implements Data{
    private int solarHours;

    public LocationData(){
        getAPIdata();
    }

    public Location getData(){
        Location l = new Location();
        l.setSolarHours(solarHours);

        return l;
    }

//Communication with the API

    void getAPIdata(){
        solarHours = 3;
    }
}
