package main.java.services.Geolocation;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Abstraction of the geolocation.
// Used by: ServiceFacade.
// Uses: Makes it possible to implement different geolocation implementations, if for example the API stops working.

public interface IGeolocation {
    String getCity();

    double getLatitude();

    double getLongitude();
}
