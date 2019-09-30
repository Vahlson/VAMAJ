package main.java.model.Calculator;

import main.java.model.Property.Property;

import java.util.function.Function;

public class AnnualSolarElectricity implements Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> {

    public AnnualSolarElectricityOutput calculate(AnnualSolarElectricityInput input){

        double latitude                 = input.getLatitude();
        double solarArea                = input.getSolarPVPArea();
        double solarEfficiency          = input.getSolarPVEfficiency();
        double kWhPerSqMeterPerDay      = solarEfficiency * Insolation(latitude);
        double kWhPerSqMeterPerYear     = kWhPerSqMeterPerDay * 365;
        double kWhPerYearTotal          = solarArea * kWhPerSqMeterPerYear;

        AnnualSolarElectricityOutput output = new AnnualSolarElectricityOutput();
        output.setAnnualElectricityProduction(kWhPerYearTotal);
        return output;
    }

    private double Insolation(double latitude){
        return 10 - 0.8*(latitude/10);
    }
}
