package model.Calculator;

//(1.1) Vegard
//Class to contain input values of annualElectricityProduction calculation

public class YearsToBreakEvenInput {
    private double installationCost;
    private double annualOperationCost = 0; //Default value that can be changed with setter
    private double annualProduction;
    private double electricityPricePerKWh;

    public YearsToBreakEvenInput(double installationCost, double annualProduction, double electricityPricePerKWh) {
        this.installationCost = installationCost;
        this.annualProduction = annualProduction;
        this.electricityPricePerKWh = electricityPricePerKWh;
    }

    //Setter for annualOperationCost since it's optional for calculation
    public void setAnnualOperationCost(double annualOperationCost) {
        this.annualOperationCost = annualOperationCost;
    }

    double getAnnualOperationCost() {
        return annualOperationCost;
    }

    double getInstallationCost() {
        return installationCost;
    }

    double getAnnualProduction() {
        return annualProduction;
    }

    double getElectricityPricePerKWh() {
        return electricityPricePerKWh;
    }
}
