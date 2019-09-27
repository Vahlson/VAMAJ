package main.java.Model.Calculator;

import main.java.model.Calculator.*;
import main.java.model.Property.Property;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalculator {

    /*@Test
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

    }*/

    @Test
    public void testAnnualElectricityProduction(){
        AnnualElectricityProduction AE = new AnnualElectricityProduction();
        Property p = new Property();

        p.setLatitude(60);
        p.setInstallationSpace(20);

        String s = AE.apply(p);
        System.out.println(s);

        assertTrue(s.equals("37960"));
    }
}