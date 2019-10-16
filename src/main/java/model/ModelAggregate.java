package main.java.model;

import main.java.model.calculator.*;
import main.java.model.property.Property;
import main.java.model.contract.Contract;
import main.java.model.property.Location;
import main.java.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

//(2)Vegard

class ModelAggregate {

    private Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> AnnualCal = new AnnualSolarElectricity();

    private User currentUser;
    private List<User> users;
    private HashMap<String, Object> calculationResults; //HashMap containing results with a string as key

    ModelAggregate() {
        users = new ArrayList<>();
        calculationResults = new HashMap<>();
        currentUser = new User();
        users.add(currentUser);
    }

    //Calls calculators and sets results to above HashMap
    void runCalculators() {

        // Calculating annual electricity output
        double annualElectricityOutput = annualElectricityOutput(AnnualCal, getProperty());
        calculationResults.put("annualElectricity", annualElectricityOutput);

        // Calculating solar panel production
        double solarPanelProduction = panelProductionOutput();
        calculationResults.put("panelProduction", solarPanelProduction);
    }

    //Sends values from property as calculation parameters, returns result of the calculation
    private double annualElectricityOutput(Calculator<AnnualSolarElectricityInput, AnnualSolarElectricityOutput> calc, Property p) {
        double lat = p.getLatitude();
        double area = p.getAvailableRoofArea();
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

    // Getter for results of calculation(s)
    HashMap<String, Object> getCalculationResults() {
        return calculationResults;
    }

    // Getters
    Property getProperty() {
        return currentUser.getActiveProperty();
    }

    Location getLocation() {
        return getProperty().getLocation();
    }

    Contract getContract() {
        return getProperty().getContract();
    }
}
