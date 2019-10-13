package model.Calculator;

// (4.1) Jonatan
// Class for calculating surplus energy (consumed and produced). Unit of time to be specified

public class ElectricitySurplus implements Calculator<ElectricitySurplusInput, ElectricitySurplusOutput>{

    // Calculates and returns surplus
    public ElectricitySurplusOutput calculate(ElectricitySurplusInput input) {

        double surplus = 0;

        if(input.getProducedElectricityPerTimeUnit() > input.getConsumedElectricityPerTimeUnit()){
            surplus = input.getProducedElectricityPerTimeUnit() - input.getConsumedElectricityPerTimeUnit();
        }

        return new ElectricitySurplusOutput(surplus);
    }
}
