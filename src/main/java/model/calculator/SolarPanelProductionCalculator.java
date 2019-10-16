package main.java.model.calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

// (4.1) arcsak
public class SolarPanelProductionCalculator implements Calculator {

    private final Set<DataKey> requiredInput = new HashSet<>(Arrays.asList(SOLAR_PANEL_AREA, SOLAR_PANEL_EFFICIENCY, AVERAGE_SOLAR_RADIATION, PANEL_PERFORMANCE_RATIO));

    SolarPanelProductionCalculator() {
    }

    // Calculate method
    public void calculate(CalculatorData input) {

        double panelArea = input.getValue(SOLAR_PANEL_AREA);
        double panelEfficiency = input.getValue(SOLAR_PANEL_EFFICIENCY);
        double averageRadiation = input.getValue(AVERAGE_SOLAR_RADIATION);
        double panelPerformanceRatio = input.getValue(PANEL_PERFORMANCE_RATIO);

        // Calculating the result
        double energy = panelArea
                * panelEfficiency
                * averageRadiation
                * panelPerformanceRatio;

        // Returning the result
        input.addValue(SOLAR_PV_ELECTRICITY_OUTPUT, energy);
    }

    @Override
    public Set<DataKey> getRequiredInput() {
        return requiredInput;
    }
}
