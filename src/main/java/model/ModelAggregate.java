package main.java.model;

import main.java.model.Calculator.*;
import main.java.model.Property.Property;
import main.java.model.Contract.Contract;
import main.java.model.Property.Location;
import main.java.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

//(2)Vegard

public class ModelAggregate {

    private Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> AnnualCal = new AnnualSolarElectricity();

    private User currentUser;
    private List<User> users = new ArrayList<>();
    private Property property = new Property();
    private Location location = new Location();
    private HashMap<String, Object> calculationResults = new HashMap<>(); //HashMap containing results with a string as key

    //Calls calculators and sets results to above HashMap
    void runCalculators() {

        // Calculating annual electricity output
        double annualElectricityOutput = annualElectricityOutput(AnnualCal, property);
        calculationResults.put("annualElectricity", annualElectricityOutput);

        // Calculating solar panel production
        double solarPanelProduction = panelProductionOutput();
        calculationResults.put("panelProduction", solarPanelProduction);
    }

    //Sends values from property as calculation parameters, returns result of the calculation
    private double annualElectricityOutput(Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> calc, Property p) {
        double lat = p.getLatitude();
        double area = p.getInstallationSpace();
        double efficiency = 22;

        //Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> AnnualCal;
        AnnualSolarElectricityInput in = new AnnualSolarElectricityInput(lat, area, efficiency);
        AnnualSolarElectricityOutput out = calc.calculate(in);
        return out.getAnnualElectricityProduction();
    }

    // Method calculating the production output of solar panel based on given values (kW/h)
    private double panelProductionOutput() {

        // Creating the input (hard coded values for now)
        SolarPanelProductionInput input;
        input = new SolarPanelProductionInput();
        input.setPanelPerformanceRatio(0.75); // Default value
        input.setAverageSolarRadiation(2.5);
        input.setPanelEfficiency(0.4);
        input.setPanelArea(10);

        // property.getSolarSetup().getEfficiency()
        // property.getSolarSetup().getSpaceRequired()

        SolarPanelProduction calculator;
        calculator = new SolarPanelProduction();

        // Creating the output
        SolarPanelProductionOutput output;
        output = calculator.calculate(input);

        // Returning the result
        return output.getEnergy();
    }

    //Temporary setter for testing purposes
    public void setProperty(Property property) {
        this.property = property;
    }

    // Getter for results of calculation(s)
    public HashMap<String, Object> getCalculationResults() {
        return calculationResults;
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public Property getProperty() {
        return property;
    }

    public Contract getContract() {
        return property.getContract();
    }
}
