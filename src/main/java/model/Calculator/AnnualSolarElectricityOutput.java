package main.java.model.Calculator;

public class AnnualSolarElectricityOutput {
    private double annualElectricityProduction;

    AnnualSolarElectricityOutput(double annualElectricityProduction) {
        this.annualElectricityProduction = annualElectricityProduction;
    }

    public double getAnnualElectricityProduction() {
        return annualElectricityProduction;
    }
}
