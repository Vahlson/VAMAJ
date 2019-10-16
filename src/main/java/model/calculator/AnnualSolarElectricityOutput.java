package main.java.model.calculator;

//(3) Vegard
//Class to contain return values of annualElectricityProduction calculation

public class AnnualSolarElectricityOutput {
    private double annualElectricityProduction;

    AnnualSolarElectricityOutput(double annualElectricityProduction) {
        this.annualElectricityProduction = annualElectricityProduction;
    }

    public double getAnnualElectricityProduction() {
        return annualElectricityProduction;
    }
}
