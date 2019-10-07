package test.java;
import main.java.model.Calculator.*;
import main.java.model.Property.*;
import main.java.model.*;
import java.lang.Math.*;
import java.util.HashMap;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalculator {

    @Test
    public void testCalcRunner(){
        ModelAggregate ag = new ModelAggregate();
        Property p = new Property();

        ag.setProperty(p);
        ag.setPropertyInstallationSpace(5);
        ag.setPropertyLatitude(23);

        ag.runCalculators();
        HashMap hm = ag.getCalculationResults();

        double result = (double)hm.get("annualElectricity");
        assertTrue((int)result == 3276);
    }

    @Test
    public void testAnnualElectricityProduction(){

        AnnualSolarElectricityOutput output;

        double latitude = 23;
        double solarArea = 5;
        double efficiency = 22;

        AnnualSolarElectricityInput input = new AnnualSolarElectricityInput(latitude, solarArea, efficiency);

        Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> AE = new AnnualSolarElectricity();

        output = AE.calculate(input);
        double result = output.getAnnualElectricityProduction();
        assertTrue((int)result == 3276);
    }

    @Test
    public void testLevelizedCostOfElectricity(){

        LevelizedCostOfElectricityInput input = new LevelizedCostOfElectricityInput(30, 1000, 30000);
        input.setAnnualOperationCost(100);
        Calculator<LevelizedCostOfElectricityInput, LevelizedCostOfElectricityOutput> LC = new LevelizedCostOfElectricity();
        LevelizedCostOfElectricityOutput output = LC.calculate(input);

        double result = output.getlCOE();

        assertTrue(Math.abs(result-0.90909) < 0.05);
    }

    @Test
    public void testYearsToBreakEven(){

        YearsToBreakEvenInput input = new YearsToBreakEvenInput(30000, 1500,  1);
        input.setAnnualOperationCost(100);
        Calculator<YearsToBreakEvenInput, YearsToBreakEvenOutput> LC = new YearsToBreakEven();
        YearsToBreakEvenOutput output = LC.calculate(input);

        double result = output.getYears();

        assertTrue(Math.abs(result-21.0) < 0.1);
    }
}
