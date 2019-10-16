package Calculators;

import java.util.*;

public class CalculatorRunner {
    private List<Calculator> classList = new ArrayList<>();
    private final Calculator surplus = new ElectricitySurplusCalculator();
    private final Calculator installationCost = new InstallationCostCalculator();
    private final Calculator LCOE = new LevelizedCostOfElectricityCalculator();
    private final Calculator panelProd = new SolarPanelProductionCalculator();
    private final Calculator breakEven = new YearsToBreakEvenCalculator();

    public void runb(CalculatorData data){
        classList.add(surplus);
        classList.add(installationCost);
        classList.add(LCOE);
        classList.add(panelProd);
        classList.add(breakEven);

        HashMap<DataKey, Double> mappy = data.getData();


        Iterator<Calculator> it = classList.iterator();
        System.out.println(classList.size());


        while (it.hasNext()){
            Calculator calc = it.next();
            if(data.getData().keySet().containsAll(calc.getRequiredInput())){
                calc.calculate(data);
                System.out.println("true");
                it.remove();
                it = classList.iterator();
            }
        }
    }
}
