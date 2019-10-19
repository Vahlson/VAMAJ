package main.java.model.calculator;

//(1.1) Vegard

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

public class YearsToBreakEvenCalculator implements Calculator{

    private final Set<DataKey> requiredInput = new HashSet<>(Arrays.asList(INSTALLATION_COST, ANNUAL_OPERATION_COST, ANNUAL_ELECTRICITY_PRODUCTION, IMPORTED_ELECTRICITY_PRICE_KWH));

    YearsToBreakEvenCalculator() {
    }

    //Returns approximate time to break-even on costs for a electricity generation setup
    public void calculate(CalculatorData input){

        double installationCost         = input.getValue(INSTALLATION_COST);
        double annualOperationCost      = input.getValue(ANNUAL_OPERATION_COST);
        double annualProduction         = input.getValue(ANNUAL_ELECTRICITY_PRODUCTION);
        double electricityPricePerKWh   = input.getValue(IMPORTED_ELECTRICITY_PRICE_KWH);

        double savingsPerYear = annualProduction * electricityPricePerKWh - annualOperationCost;
        double yearsToPayInstallationCost = installationCost/savingsPerYear;

        input.addValue(YEARS_TO_BREAK_EVEN, yearsToPayInstallationCost);
    }

    @Override
    public Set<DataKey> getRequiredInput() {
        return requiredInput;
    }
}
