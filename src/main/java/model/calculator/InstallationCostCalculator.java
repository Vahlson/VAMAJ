package main.java.model.Calculator;

    // (3) and (7) Jonatan
    // Class that handles all calculations related to a property's installation cost of solar panels

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.Calculator.DataKey.*;

public class InstallationCostCalculator implements Calculator{

    private final Set<DataKey> requiredInput = new HashSet<>(Arrays.asList(AVAILABLE_SPACE, REQUIRED_PANEL_SPACE, PANEL_PRICE));

    InstallationCostCalculator(){
    }


    // Returns the InstallationCostCalculator output consisting of installation cost, subvented amount and subvented installation cost
    public void calculate(CalculatorData input) {

        double availableSpace           = input.getValue(AVAILABLE_SPACE);
        double requiredPanelSpace       = input.getValue(REQUIRED_PANEL_SPACE);
        double panelPrice               = input.getValue(PANEL_PRICE);

        double installationCost         = installationCost(availableSpace, requiredPanelSpace, panelPrice);
        double governmentSubvention     = subventionAmount(installationCost);
        double subventedInstallationCost= subventedCost(installationCost);

        input.addValue(INSTALLATION_COST, installationCost);
        input.addValue(GOVERNMENT_SUBVENTION, governmentSubvention);
        input.addValue(SUBVENTED_INSTALLATION_COST, subventedInstallationCost);

    }

    // Calculates installationCost based on how many solar panels there's room for in the availableSpace of a property
    private double installationCost(double availableSpace, double requiredPanelSpace, double panelPrice){
        return Math.floor(availableSpace / requiredPanelSpace) * panelPrice;
    }

    // Returns the subvented amount based on installationCost
    private double subventionAmount(double installationCost){
        return installationCost * 0.2;
    }

    // Returns installationCost after subvention
    private double subventedCost(double installationCost){
        return installationCost * 0.8;
    }

    @Override
    public Set<DataKey> getRequiredInput() {
        return requiredInput;
    }}
