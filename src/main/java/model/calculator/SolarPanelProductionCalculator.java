package main.java.model.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;

// (4.1) arcsak
final class SolarPanelProductionCalculator implements Calculator {

    SolarPanelProductionCalculator() {

    }

    // Calculate method
    @Override
    public HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input) {
        HashMap<DataKey, Double> data = new HashMap<>(input);


        double panelArea = input.get(SOLAR_PANEL_COVERAGE);
        double panelEfficiency = input.get(SOLAR_PANEL_EFFICIENCY);
        double averageRadiation = input.get(AVERAGE_SOLAR_RADIATION);
        double panelPerformanceRatio = input.get(SOLAR_PANEL_PERFORMANCE_RATIO);

        // Calculating the result
        double energy = panelArea
                * panelEfficiency
                * averageRadiation
                * panelPerformanceRatio;

        // Returning the result
        data.put(SOLAR_PV_DAILY_ELECTRICITY, energy);
        return data;
    }

    @Override
    public Set<DataKey> getKeysOfRequiredInput() {
        return new HashSet<>(Arrays.asList(SOLAR_PANEL_COVERAGE, SOLAR_PANEL_EFFICIENCY, AVERAGE_SOLAR_RADIATION, SOLAR_PANEL_PERFORMANCE_RATIO));
    }

    @Override
    public Set<DataKey> getKeysOfOutput() {
        return new HashSet<>(Arrays.asList(SOLAR_PV_DAILY_ELECTRICITY));
    }

    @Override
    public String toString() {
        return "SolarPanelProductionCalculator";
    }
}
