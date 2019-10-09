package main.java.model.Calculator;

// (4.1) Jonatan
// Class for calculating surplus energy (consumed and produced). Unit of time to be specified

public class ElectricitySurplus implements Calculator<ElectricitySurplusInput, ElectricitySurplusOutput>{

    // Calculates and returns surplus
    @Override
    public ElectricitySurplusOutput calculate(ElectricitySurplusInput input) {

        double surplus = 0;

        if(input.getTimeUnitProducedElectricity() > input.getTimeUnitConsumedElectricity()){
            surplus = input.getTimeUnitProducedElectricity() - input.getTimeUnitConsumedElectricity();
        }

        return new ElectricitySurplusOutput(surplus);
    }
}
