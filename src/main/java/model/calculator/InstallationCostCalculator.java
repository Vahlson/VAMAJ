package main.java.model.calculator;

    // (3) and (7) Jonatan
    // Class that handles all calculations related to a property's installation cost of solar panels

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static main.java.model.calculator.DataKey.*;


final class InstallationCostCalculator implements Calculator {


    InstallationCostCalculator() {

    }


    // Returns the InstallationCostCalculator output consisting of installation cost, subvented amount and subvented installation cost
    @Override
    public HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input) {
        HashMap<DataKey, Double> data = new HashMap<>(input);

        double availableSpace = input.get(AVAILABLE_SPACE);
        double requiredPanelSpace = input.get(REQUIRED_PANEL_SPACE);
        double panelPrice = input.get(PANEL_PRICE);


        double installationCost = installationCost(availableSpace, requiredPanelSpace, panelPrice);
        double governmentSubvention = subventionAmount(installationCost);
        double subventedInstallationCost = subventedCost(installationCost);

        data.put(INSTALLATION_COST, installationCost);
        data.put(GOVERNMENT_SUBVENTION, governmentSubvention);
        data.put(SUBVENTED_INSTALLATION_COST, subventedInstallationCost);

        return data;
    }

    // Calculates installationCost based on how many solar panels there's room for in the availableSpace of a property
    private double installationCost(double availableSpace, double requiredPanelSpace, double panelPrice) {
        return Math.floor(availableSpace / requiredPanelSpace) * panelPrice;
    }

    // Returns the subvented amount based on installationCost
    private double subventionAmount(double installationCost) {
        return installationCost * 0.2;
    }

    // Returns installationCost after subvention
    private double subventedCost(double installationCost) {
        return installationCost * 0.8;
    }

    public Set<DataKey> getKeysOfRequiredInput() {
        return  new HashSet<>(Arrays.asList(AVAILABLE_SPACE, REQUIRED_PANEL_SPACE, PANEL_PRICE));
    }

    public Set<DataKey> getKeysOfOutput() {
        return new HashSet<>(Arrays.asList(INSTALLATION_COST, GOVERNMENT_SUBVENTION, SUBVENTED_INSTALLATION_COST));
    }
}
