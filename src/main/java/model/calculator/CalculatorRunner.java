package model.calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculatorRunner {
    private List<Calculator> calculatorList = new ArrayList<>();
    private final Calculator surplus = new ElectricitySurplusCalculator();
    private final Calculator installationCost = new InstallationCostCalculator();
    private final Calculator LCOE = new LevelizedCostOfElectricityCalculator();
    private final Calculator panelProd = new SolarPanelProductionCalculator();
    private final Calculator breakEven = new YearsToBreakEvenCalculator();

    public void calculateAll(CalculatorData data){
        calculatorList.add(surplus);
        calculatorList.add(installationCost);
        calculatorList.add(LCOE);
        calculatorList.add(panelProd);
        calculatorList.add(breakEven);


        Iterator<Calculator> it = calculatorList.iterator();

        while (it.hasNext()){
            Calculator calc = it.next();
            if(data.getData().keySet().containsAll(calc.getRequiredInput())){
                calc.calculate(data);
                it.remove();
                it = calculatorList.iterator();
            }
        }
    }
}
