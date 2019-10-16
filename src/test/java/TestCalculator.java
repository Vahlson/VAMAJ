package test.java;

import main.java.model.Calculator.*;
import main.java.model.Property.*;
import main.java.model.*;

import java.util.HashMap;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalculator {
/*
    @Test
    public void testCalcRunner() {

        ModelFacade mf = new ModelFacade();
        Property p = new Property();

        mf.setProperty(p);
        mf.setPropertyInstallationSpace(5);
        mf.setPropertyLatitude(23);

        mf.runCalculators();
        HashMap hm = mf.getCalculationResults();

        double result = (double) hm.get("annualElectricity");
        assertTrue((int) result == 3276);

        double panelProduction;
        panelProduction = (double) hm.get("panelProduction");
        assertTrue(panelProduction == 7.5);
    }

    @Test
    public void testAnnualElectricityProduction() {

        AnnualSolarElectricityOutput output;

        double latitude = 23;
        double solarArea = 5;
        double efficiency = 22;

        AnnualSolarElectricityInput input = new AnnualSolarElectricityInput(latitude, solarArea, efficiency);

        Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> AE = new AnnualSolarElectricity();

        output = AE.calculate(input);
        double result = output.getAnnualElectricityProduction();
        assertTrue((int) result == 3276);
    }

    @Test
    public void testLevelizedCostOfElectricity() {

        LevelizedCostOfElectricityInput input = new LevelizedCostOfElectricityInput(30, 1000, 30000);
        input.setAnnualOperationCost(100);
        Calculator<LevelizedCostOfElectricityInput, LevelizedCostOfElectricityOutput> LC = new LevelizedCostOfElectricity();
        LevelizedCostOfElectricityOutput output = LC.calculate(input);

        double result = output.getlCOE();

        assertTrue(Math.abs(result - 0.90909) < 0.05);
    }

    @Test
    public void testYearsToBreakEven() {

        YearsToBreakEvenInput input = new YearsToBreakEvenInput(30000, 1500, 1);
        input.setAnnualOperationCost(100);
        Calculator<YearsToBreakEvenInput, YearsToBreakEvenOutput> LC = new YearsToBreakEven();
        YearsToBreakEvenOutput output = LC.calculate(input);

        double result = output.getYears();

        assertTrue(Math.abs(result - 21.0) < 0.1);
    }

    @Test
    public void testPanelProduction() {

        SolarPanelProductionInput input;
        input = new SolarPanelProductionInput();
        input.setPanelEfficiency(0.5);
        input.setAverageSolarRadiation(2.5);
        input.setPanelArea(100);
        input.setPanelPerformanceRatio(0.75);

        SolarPanelProduction calculator;
        calculator = new SolarPanelProduction();

        SolarPanelProductionOutput output;
        output = calculator.calculate(input);

        double result = output.getEnergy();

        assertTrue(result == 93.75);
    }

    @Test
    public void testInstallationCost(){

        InstallationCostInput input;
        input = new InstallationCostInput(40, 2.3, 4600);

        InstallationCost installationCalculator;
        installationCalculator = new InstallationCost();

        InstallationCostOutput output;
        output = installationCalculator.calculate(input);

        double resultCost                   = output.getInstallationCost();
        double resultSubventedAmount        = output.getSubventionAmount();
        double resultSubventedInstallation  = output.getSubventedCost();

        assertTrue(resultCost == 78200);
        assertTrue(resultSubventedAmount == 15640);
        assertTrue(resultSubventedInstallation == 62560);
    }

    @Test
    public void testElectricitySurplus() {

        double consumption = 100;

        ElectricitySurplusInput lowProduction = new ElectricitySurplusInput(consumption, 20);
        ElectricitySurplusInput highProduction = new ElectricitySurplusInput(consumption, 110);

        ElectricitySurplus calculator = new ElectricitySurplus();

        ElectricitySurplusOutput noSurplus;
        ElectricitySurplusOutput surplus;

        noSurplus = calculator.calculate(lowProduction);
        surplus = calculator.calculate(highProduction);

        assertTrue(noSurplus.getElectricitySurplus() == 0);
        assertTrue(surplus.getElectricitySurplus() == 10);
    }*/
}
