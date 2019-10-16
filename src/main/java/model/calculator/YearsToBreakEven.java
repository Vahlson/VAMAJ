package main.java.model.calculator;

//(1.1) Vegard

public class YearsToBreakEven implements Calculator<YearsToBreakEvenInput, YearsToBreakEvenOutput>{

    //Returns approximate time to break-even on costs for a electricity generation setup
    public YearsToBreakEvenOutput calculate(YearsToBreakEvenInput input){

        double installationCost = input.getInstallationCost();
        double annualOperationCost = input.getAnnualOperationCost();
        double annualProduction = input.getAnnualProduction();
        double electricityPricePerKWh = input.getElectricityPricePerKWh();

        double savingsPerYear = annualProduction * electricityPricePerKWh - annualOperationCost;
        double yearsToPayInstallationCost = installationCost/savingsPerYear;

        return new YearsToBreakEvenOutput((int)yearsToPayInstallationCost);
    }
}
