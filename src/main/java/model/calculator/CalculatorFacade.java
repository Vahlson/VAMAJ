package main.java.model.calculator;

import java.util.*;

public final class CalculatorFacade {

    private static final Calculator surplus = new ElectricitySurplusCalculator();
    private static final Calculator installationCost = new InstallationCostCalculator();
    private static final Calculator LCOE = new LevelizedCostOfElectricityCalculator();
    private static final Calculator panelProd = new SolarPanelProductionCalculator();
    private static final Calculator breakEven = new YearsToBreakEvenCalculator();
    private static final List<Calculator> calculatorList = new ArrayList<>(Arrays.asList(
            surplus, installationCost, LCOE, panelProd, breakEven));


    private CalculatorFacade(){}

    public static HashMap<DataKey, Double> calculateAll(HashMap<DataKey, Double> input){

        HashMap<DataKey, Double> data = new HashMap<>(input);

        Iterator<Calculator> it = calculatorList.iterator();

        while (it.hasNext()){
            Calculator calc = it.next();
            if(data.keySet().containsAll(calc.getRequiredInput())){
                data = calc.calculate(data);
                it.remove();
                it = calculatorList.iterator();
            }
        }
        return data;
    }
    public static HashMap<DataKey, Double> calculateSpecific(DataKey key, HashMap<DataKey, Double> input){

        for (Calculator calc: calculatorList) {
            if (calc.getOutput().contains(key)) {
                if (input.keySet().containsAll((calc.getRequiredInput()))) {
                    return calc.calculate(input);
                } else {
                    throw new NullPointerException("Insufficient data for meaningful answer");
                }
            }
        }
        throw new NullPointerException("No calculator is suited for calculating" + key);
    }
}
