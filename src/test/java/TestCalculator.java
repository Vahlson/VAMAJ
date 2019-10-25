import main.java.model.ModelAggregate;
import main.java.model.calculator.*;
import static main.java.model.calculator.DataKey.*;
import main.java.model.property.*;
import org.junit.Test;
import junit.framework.TestCase;

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Test class for the Calculator Package.


import java.util.HashMap;


public class TestCalculator extends TestCase{




    @Test
    public void testSolarElectricityProduction() {

        HashMap<DataKey, Double> data = new HashMap<>();

        data.put(SOLAR_PANEL_COVERAGE, 6.0);
        data.put(SOLAR_PANEL_EFFICIENCY, 6.0);
        data.put(AVERAGE_SOLAR_RADIATION, 2.0);
        data.put(SOLAR_PANEL_PERFORMANCE_RATIO, 2.0);

        data = CalculatorFacade.calculateAll(data);
        System.out.println(data.get(ANNUAL_ELECTRICITY_PRODUCTION));

        assertEquals(data.get(ANNUAL_ELECTRICITY_PRODUCTION), 144.0*364);
    }

    @Test
    public void testLevelizedCostOfElectricity() {

        HashMap<DataKey, Double> data = new HashMap<>();

        data.put(EXPECTED_LIFESPAN, 30.0);
        data.put(INSTALLATION_COST, 100000.0);
        data.put(ANNUAL_ELECTRICITY_PRODUCTION, 30000.0);
        data.put(ANNUAL_OPERATION_COST, 100.0);

        data = CalculatorFacade.calculateAll(data);

        assertTrue(Math.abs(data.get(LEVELIZED_ELECTRICITY_COST) - 0.1144) < 0.05);
    }

    @Test
    public void testYearsToBreakEven() {

        HashMap<DataKey, Double> data = new HashMap<>();


        data.put(INSTALLATION_COST, 100000.0);
        data.put(ANNUAL_OPERATION_COST, 100.0);
        data.put(ANNUAL_ELECTRICITY_PRODUCTION, 30000.0);
        data.put(MONTHLY_ELECTRICITY_PRICE, 300.0);
        data.put(MONTHLY_ELECTRICITY_CONSUMPTION, 1000.0);

        data = CalculatorFacade.calculateAll(data);

        assertTrue(Math.abs(data.get(YEARS_TO_BREAK_EVEN) - 11.23) < 0.1);
    }

    @Test
    public void testInstallationCost(){

        HashMap<DataKey, Double> data = new HashMap<>();

        data.put(AVAILABLE_SPACE, 100.0);
        data.put(PANEL_SIZE, 10.0);
        data.put(PANEL_PRICE, 300.0);

        data = CalculatorFacade.calculateAll(data);

        assertTrue(data.get(INSTALLATION_COST) == 3000.0);
        assertTrue(data.get(GOVERNMENT_SUBVENTION) == 600.0);
        assertTrue(data.get(SUBVENTED_INSTALLATION_COST) == 2400.0);
    }

    @Test
    public void testElectricitySurplus() {

        HashMap<DataKey, Double> data = new HashMap<>();


        data.put(MONTHLY_ELECTRICITY_CONSUMPTION, 100.0);
        data.put(ANNUAL_ELECTRICITY_PRODUCTION, 2000.0);

        data = CalculatorFacade.calculateAll(data);

        System.out.println(data.get(SURPLUS));
        assertTrue(data.get(SURPLUS) == 800.0);
    }
}
