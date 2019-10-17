package main.java.model.calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculatorRunner {
    private List<Calculator> classList = new ArrayList<>();
    private final Calculator surplus = new ElectricitySurplusCalculator();
    private final Calculator installationCost = new InstallationCostCalculator();
    private final Calculator LCOE = new LevelizedCostOfElectricityCalculator();
    private final Calculator panelProd = new SolarPanelProductionCalculator();
    private final Calculator breakEven = new YearsToBreakEvenCalculator();

    public void calculateAll(CalculatorData data){
        classList.add(surplus);
        classList.add(installationCost);
        classList.add(LCOE);
        classList.add(panelProd);
        classList.add(breakEven);


        Iterator<Calculator> it = classList.iterator();

        while (it.hasNext()){
            Calculator calc = it.next();
            if(data.getData().keySet().containsAll(calc.getRequiredInput())){
                calc.calculate(data);
                it.remove();
                it = classList.iterator();
            }
        }
    }
}
