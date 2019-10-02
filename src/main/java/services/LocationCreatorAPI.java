package main.java.services;

import main.java.model.Property.Location;

//(3.1) Alex LV och Alex Ask
// Mock class, this will be API/File implementation later on
public class LocationCreatorAPI implements ILocationCreator{


    //Creates a location from an API
    //TODO use a real API.
    @Override
    public Location createLocation() {
        MockLocationAPI api = new MockLocationAPI();
        Location l = new Location();

        l.setSolarHours(api.getSolarHours());

        Double x = api.getX();
        Double y = api.getY();
        l.setCoordinate(x,y);

        int solarPower = (int)Math.round(api.getSolarPower());
        l.setSolarPower(solarPower);

        return l;
    }
}