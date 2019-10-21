package main.java.model.calculator;

// (4.1) Jonatan
// Class for calculating surplus energy (consumed and produced). Unit of time to be specified

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

final class ElectricitySurplusCalculator implements Calculator{

    ElectricitySurplusCalculator() {

    }

    // Calculates and returns surplus
    @Override
    public HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input) {
        HashMap<DataKey, Double> data = new HashMap<>(input);

        double surplus = 0;

        double produced = data.get(PRODUCED_ELECTRICITY);
        double consumed = data.get(CONSUMED_ELECTRICITY);

        //Checks if there is a surplus and calculates if there is, no negative surplus possible
        if(produced > consumed){
            surplus = produced - consumed;
        }

        data.put(SURPLUS, surplus);
        return data;
    }

    @Override
    public Set<DataKey> getKeysOfRequiredInput() {
        return new HashSet<>(Arrays.asList(PRODUCED_ELECTRICITY, CONSUMED_ELECTRICITY));
    }

    @Override
    public Set<DataKey> getKeysOfOutput() {
        return new HashSet<>(Arrays.asList(SURPLUS));
    }
}