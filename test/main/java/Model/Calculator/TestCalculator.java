package main.java.model.Calculator;

import main.java.model.Calculator.EconomicCalculator;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalculator {

    @Test
    public void testYearsToBreakEven(){
        EconomicCalculator ECalc = new EconomicCalculator();

        ECalc.setInstallationCost(50000);
        ECalc.setInstallationAnnualKwhProduction(1000);
        ECalc.setContractKwhCost(1);

        ECalc.calculateYearsToBreakEven();

        int answer = ECalc.getYearsToBreakEven();

        assertTrue(answer == 50);
    }

    @Test
    public void testAnnualSavings(){
        EconomicCalculator ECalc = new EconomicCalculator();

        ECalc.setInstallationCost(50000);
        ECalc.setInstallationAnnualKwhProduction(1000);
        ECalc.setContractKwhCost(1);
        ECalc.setInstallationLifetime(30);

        ECalc.calculateAnnualSavings();

        double answer = ECalc.getAnnualSavings();

        assertTrue(answer == 400);

    }
}