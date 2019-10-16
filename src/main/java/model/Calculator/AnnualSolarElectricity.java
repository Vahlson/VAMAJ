package main.java.model.Calculator;

//(3) Vegard

public class AnnualSolarElectricity implements Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> {

    //Returns annual output based on rough insolation calculation and efficiency of panel
    public AnnualSolarElectricityOutput calculate(AnnualSolarElectricityInput input){

        double latitude                 = input.getLatitude();
        double solarArea                = input.getSolarPVPArea();
        double solarEfficiency          = input.getSolarPVEfficiency();
        double kWhPerSqMeterPerDay      = (solarEfficiency/100) * Insolation(latitude);
        double kWhPerSqMeterPerYear     = kWhPerSqMeterPerDay * 365;
        double kWhPerYearTotal          = solarArea * kWhPerSqMeterPerYear;

        return new AnnualSolarElectricityOutput(kWhPerYearTotal);
    }

    //Calculates a rough approximate value of annual solar irradiation
    private double Insolation(double latitude){
        return 10 - 0.8*(latitude/10);
    }
}
