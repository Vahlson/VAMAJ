package main.java.model.Calculator;

// (4.1) arcsak
public class SolarPanelProduction implements Calculator<SolarPanelProductionInput, SolarPanelProductionOutput> {

    // Calculate method
    @Override
    public SolarPanelProductionOutput calculate(SolarPanelProductionInput input) {

        // Calculating the result
        double energy = input.getArea() *
                input.getPanelEfficiency() *
                input.getAverageSolarRadiation() *
                input.getPerformanceRatio();

        // Returning the result
        return new SolarPanelProductionOutput(energy);
    }
}
