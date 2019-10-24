package main.java.model.solarsetup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolarSetupTest {
    static StandardSolarPanel solarPanel;
    List <SolarPanel> solarPanels = new ArrayList <>();
    StandardSolarPanel solarPanel1 = new StandardSolarPanel();
    StandardSolarPanel solarPanel2 = new StandardSolarPanel();




    @Test
    public void getTotalEProductionPerHourTest() {
        double totalEfficiency = 0.0;
        solarPanel1.setProductionPerHour(500);
        solarPanel2.setProductionPerHour(500);
        solarPanels.add(solarPanel1);
        solarPanels.add(solarPanel2);
        for (SolarPanel p : solarPanels) {
            totalEfficiency += p.getProductionPerHour();
        }
        assertEquals(1000, totalEfficiency, 0.0);


    }

    @Test
    public void getAnnualOperationCostTest() {
        double annualElectricityProduction = 0.0;
        solarPanel1.setAnnualOperationCost(1500);
        solarPanel2.setAnnualOperationCost(1500);
        solarPanels.add(solarPanel1);
        solarPanels.add(solarPanel2);
        for (SolarPanel p : solarPanels) {
            annualElectricityProduction += p.getAnnualOperationCost();
        }
        assertEquals(3000, annualElectricityProduction, 0.0);


    }

    @Test
    public void getSolarPanelCoverageTest() {
        double solarPanelCoverage = 0.0;
        solarPanels.add(solarPanel1);
        solarPanels.add(solarPanel2);
        for (SolarPanel p : solarPanels) {
            solarPanelCoverage += p.getSize();
        }
        assertEquals(4, solarPanelCoverage, 0.0);


    }

    @Test
    public void getAnnualElectricityProductionTest() {
        double annualElectricityProduction = 0.0;
        solarPanel1.setProductionPerHour(500);
        solarPanel2.setProductionPerHour(500);
        solarPanels.add(solarPanel1);
        solarPanels.add(solarPanel2);
        for (SolarPanel p : solarPanels) {
            annualElectricityProduction += p.getProductionPerHour();
        }
        annualElectricityProduction *= 8766;
        assertEquals(8766000, annualElectricityProduction, 0.0);
    }
    @Test
    public void getNumberOfSolarPanels() {
        int numberOfSolarPanels = 0;
        StandardSolarPanel solarPanel = new StandardSolarPanel();
        RoofBasedSolarSetup solarSetup = new RoofBasedSolarSetup(1000,20);
        numberOfSolarPanels = (int) Math.floor(solarSetup.getAvailableSpace() / solarPanel.getSize());
        assertEquals(10, numberOfSolarPanels, 0.0);
    }
    @Test
    public void setSolarPanelsFromTemplateTest() {
        StandardSolarPanel solarPanel = new StandardSolarPanel();
        RoofBasedSolarSetup solarSetup = new RoofBasedSolarSetup(1000,20);
        List<SolarPanel> solarPanels = new ArrayList<>();

        for (int i = 0; i < solarSetup.getNumberOfSolarPanels(solarPanel); i++) {
            solarPanels.add(new StandardSolarPanel());
        }

        solarSetup.setSolarPanels(solarPanels);
        assertEquals(10,solarPanels.size(),0);
    }
}