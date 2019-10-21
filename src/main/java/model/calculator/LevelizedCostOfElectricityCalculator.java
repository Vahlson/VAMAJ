package main.java.model.calculator;

//(4.2) Vegard

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

final class LevelizedCostOfElectricityCalculator implements Calculator{

    LevelizedCostOfElectricityCalculator() {
    }

    //Returns approximate cost of each kWh produced by a electricity generation setup
    @Override
    public HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input) {
        HashMap<DataKey, Double> data = new HashMap<>(input);


        double lifetime             = input.get(EXPECTED_LIFESPAN);
        double installationCost     = input.get(INSTALLATION_COST);
        double annualOperationCost  = input.get(ANNUAL_OPERATION_COST);
        double annualOutput         = input.get(ANNUAL_ELECTRICITY_PRODUCTION);

        double lifetimeOutput       = lifetime * annualOutput;
        double totalCost            = installationCost + (lifetime * annualOperationCost);
        double levelizedCost        = totalCost / lifetimeOutput;

        data.put(LEVELIZED_ELECTRICITY_COST, levelizedCost);
        return data;
    }
    @Override
    public Set<DataKey> getKeysOfRequiredInput() {
        return new HashSet<>(Arrays.asList(EXPECTED_LIFESPAN, INSTALLATION_COST, ANNUAL_OPERATION_COST, ANNUAL_ELECTRICITY_PRODUCTION));
    }

    @Override
    public Set<DataKey> getKeysOfOutput() {
        return new HashSet<>(Arrays.asList(LEVELIZED_ELECTRICITY_COST));
    }

    @Override
    public String toString(){
        return "LevelizedCostOfElectricityCalculator";
    }
}
