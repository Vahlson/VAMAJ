package main.java.model.Calculator;

import main.java.model.Property.Property;

import java.util.function.Function;

public class AnnualElectricityProduction  implements Function<Property, String> {

    public String apply(Property property){
        double latitude = property.getLatitude();
        double solarArea = property.getInstallationSpace();

        double KWhPerSqMeterPerDay = insolation(latitude);
        double KWhPerSqMeterPerYear = KWhPerSqMeterPerDay * 365;
        return solarArea * KWhPerSqMeterPerYear + "";
    }

    private double insolation(double latitude){
        return 10 - 0.8*(latitude/10);
    }
}
