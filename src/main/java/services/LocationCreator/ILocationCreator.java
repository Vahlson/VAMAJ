package main.java.services.LocationCreator;

import main.java.model.property.Location;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Interface defining loaction object creators.
// Used by: LocationCreatorAPI, [Potential location creators with different sources].
// Uses: Implementations of this interface create objects with data from different sources.

public interface ILocationCreator {

    Location createLocation();

    void setLatitude(double latitude);

    void setLongitude(double longitude);
}
