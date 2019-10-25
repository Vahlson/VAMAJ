package main.java.model.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Calculator implementation.
// Used by: CalculatorFacade.
// Uses: Handles all calculations related to surplus energy (consumed and produced).

final class ElectricitySurplusCalculator implements Calculator {

    ElectricitySurplusCalculator() {

    }

    // Calculates and returns surplus
    @Override
    public HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input) {
        HashMap<DataKey, Double> data = new HashMap<>(input);

        double surplus = 0;

        double produced = data.get(ANNUAL_ELECTRICITY_PRODUCTION);
        double consumed = data.get(MONTHLY_ELECTRICITY_CONSUMPTION) * 12;

        //Checks if there is a surplus and calculates if there is, no negative surplus possible
        if (produced > consumed) {
            surplus = produced - consumed;
        }

        data.put(SURPLUS, surplus);
        return data;
    }

    @Override
    public Set<DataKey> getKeysOfRequiredInput() {
        return new HashSet<>(Arrays.asList(ANNUAL_ELECTRICITY_PRODUCTION, MONTHLY_ELECTRICITY_CONSUMPTION));
    }

    @Override
    public Set<DataKey> getKeysOfOutput() {
        return new HashSet<>(Arrays.asList(SURPLUS));
    }

    @Override
    public String toString() {
        return "ElectricitySurplusCalculator";
    }
}