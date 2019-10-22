package main.java.model.calculator;

//(1.1) Vegard

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

final class YearsToBreakEvenCalculator implements Calculator{

    YearsToBreakEvenCalculator() {
    }

    //Returns approximate time to break-even on costs for a electricity generation setup
    @Override
    public HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input){
        HashMap<DataKey, Double> data = new HashMap<>(input);

        double installationCost         = input.get(INSTALLATION_COST);
        double annualOperationCost      = input.get(ANNUAL_OPERATION_COST);
        double annualProduction         = input.get(ANNUAL_ELECTRICITY_PRODUCTION);
        double electricityPricePerKWh   = input.get(MONTHLY_ELECTRICITY_PRICE);

        double savingsPerYear = annualProduction * electricityPricePerKWh - annualOperationCost;
        double yearsToPayInstallationCost = installationCost/savingsPerYear;

        data.put(YEARS_TO_BREAK_EVEN, yearsToPayInstallationCost);
        return data;
    }

    @Override
    public Set<DataKey> getKeysOfRequiredInput() {
        return new HashSet<>(Arrays.asList(INSTALLATION_COST, ANNUAL_OPERATION_COST, ANNUAL_ELECTRICITY_PRODUCTION, MONTHLY_ELECTRICITY_PRICE));
    }

    @Override
    public Set<DataKey> getKeysOfOutput() {
        return new HashSet<>(Arrays.asList(YEARS_TO_BREAK_EVEN));
    }

    @Override
    public String toString(){
        return "YearsToBreakEvenCalculator";
    }
}
