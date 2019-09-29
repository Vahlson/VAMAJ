package test.java;

import main.java.model.Calculator.AnnualElectricityProduction;
import main.java.model.Property.Property;

import main.java.model.Calculator.*;
import main.java.model.Property.Property;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalculator {
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
