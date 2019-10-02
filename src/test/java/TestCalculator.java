package test.java;

import main.java.model.Calculator.*;
import java.lang.Math.*;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalculator {

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
        System.out.println(result);

        assertTrue((int)result == 3276);
    }

    @Test
    public void testLevelizedCostOfElectricity(){

        LevelizedCostOfElectricityInput input = new LevelizedCostOfElectricityInput(30, 1000, 100, 30000);
        Calculator<LevelizedCostOfElectricityInput, LevelizedCostOfElectricityOutput> LC = new LevelizedCostOfElectricity();
        LevelizedCostOfElectricityOutput output = LC.calculate(input);

        double result = output.getlCOE();
        System.out.println(result);

        assertTrue(Math.abs(result-0.90909) < 0.05);
    }

    @Test
    public void testYearsToBreakEven(){

        YearsToBreakEvenInput input = new YearsToBreakEvenInput(30000, 1500, 10000, 1, 100);
        Calculator<YearsToBreakEvenInput, YearsToBreakEvenOutput> LC = new YearsToBreakEven();
        YearsToBreakEvenOutput output = LC.calculate(input);

        double result = output.getYears();
        System.out.println("Years" + result);

        assertTrue(Math.abs(result-21.0) < 0.1);
    }
}
