package main.java.model.Calculator;

// (4.1) Jonatan
// Class for calculating surplus energy (consumed and produced). Unit of time to be specified

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.Calculator.DataKey.*;

class ElectricitySurplusCalculator implements Calculator{

    private final Set<DataKey> requiredInput = new HashSet<>(Arrays.asList(PRODUCED_ELECTRICITY, CONSUMED_ELECTRICITY));

    ElectricitySurplusCalculator() {
    }

    // Calculates and returns surplus
    @Override
    public void calculate(CalculatorData input) {


        double surplus = 0;

        double produced = input.getValue(PRODUCED_ELECTRICITY);
        double consumed = input.getValue(CONSUMED_ELECTRICITY);

        //Checks if there is a surplus and calculates if there is, no negative surplus possible
        if(produced > consumed){
            surplus = produced - consumed;
        }

        input.addValue(SURPLUS, surplus);
    }

    @Override
    public Set<DataKey> getRequiredInput() {
        return requiredInput;
    }
}