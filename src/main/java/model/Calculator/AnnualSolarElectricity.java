package main.java.model.Calculator;

import main.java.model.Property.Property;

import java.util.function.Function;

public class AnnualSolarElectricity implements Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> {

    public AnnualSolarElectricityOutput calculate(AnnualSolarElectricityInput input){

        double latitude                 = input.getLatitude();
        double solarArea                = input.getSolarPVPArea();
        double solarEfficiency          = input.getSolarPVEfficiency();
        double kWhPerSqMeterPerDay      = (solarEfficiency/100) * Insolation(latitude);
        double kWhPerSqMeterPerYear     = kWhPerSqMeterPerDay * 365;
        double kWhPerYearTotal          = solarArea * kWhPerSqMeterPerYear;

        return new AnnualSolarElectricityOutput(kWhPerYearTotal);
    }

    private double Insolation(double latitude){
        return 10 - 0.8*(latitude/10);
    }
}
