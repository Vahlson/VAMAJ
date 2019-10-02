package main.java.model.Calculator;

public class YearsToBreakEvenInput {
    private double installationCost;
    private double annualOperationCost;
    private double annualProduction;
    private double annualConsumption;
    private double electricityPricePerKWh;

    public YearsToBreakEvenInput(double installationCost, double annualProduction, double annualConsumption, double electricityPricePerKWh,  double annualOperationCost) {
        this.installationCost = installationCost;
        this.annualProduction = annualProduction;
        this.annualConsumption = annualConsumption;
        this.electricityPricePerKWh = electricityPricePerKWh;
        this.annualOperationCost = annualOperationCost;
    }

    public YearsToBreakEvenInput(double installationCost, double annualProduction, double annualConsumption, double electricityPricePerKWh) {
        this.installationCost = installationCost;
        this.annualProduction = annualProduction;
        this.annualConsumption = annualConsumption;
        this.electricityPricePerKWh = electricityPricePerKWh;
        this.annualOperationCost = 0;

    }

    double getInstallationCost() {
        return installationCost;
    }

    double getAnnualOperationCost() {
        return annualOperationCost;
    }

    double getAnnualProduction() {
        return annualProduction;
    }

    double getAnnualConsumption() {
        return annualConsumption;
    }

    double getElectricityPricePerKWh() {
        return electricityPricePerKWh;
    }
}
