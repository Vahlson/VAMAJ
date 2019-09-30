package test.java;

import main.java.model.Calculator.AnnualSolarElectricity;
import main.java.model.Calculator.AnnualSolarElectricityInput;
import main.java.model.Calculator.AnnualSolarElectricityOutput;
import main.java.model.Property.Property;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalculator {
    @Test
    public void testAnnualElectricityProduction(){
        AnnualSolarElectricity AE = new AnnualSolarElectricity();
        AnnualSolarElectricityOutput output;

        double latitude = 23;
        double solarArea = 5;
        double efficiency = 22;

        AnnualSolarElectricityInput input = new AnnualSolarElectricityInput(latitude, solarArea, efficiency);

        output = AE.calculate(input);
        double result = output.getAnnualElectricityProduction();
        System.out.println(result);

        assertTrue((int)result == 3276);
    }
}
