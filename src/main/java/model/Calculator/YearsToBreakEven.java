package main.java.model.Calculator;

public class YearsToBreakEven implements Calculator<YearsToBreakEvenInput, YearsToBreakEvenOutput>{

    public YearsToBreakEvenOutput calculate(YearsToBreakEvenInput input){

        double installationCost = input.getInstallationCost();
        double annualOperationCost = input.getAnnualOperationCost();
        double annualProduction = input.getAnnualProduction();
        double annualConsumption = input.getAnnualConsumption();
        double electricityPricePerKWh = input.getElectricityPricePerKWh();

        double savingsPerYear = annualProduction * electricityPricePerKWh - annualOperationCost;
        double yearsToPayInstallationCost = installationCost/savingsPerYear;

        return new YearsToBreakEvenOutput((int)yearsToPayInstallationCost);
    }
}
