package main.java.model.calculator;

//Vegard
//Common interface for all calculators in package

import java.util.HashMap;
import java.util.Set;

interface Calculator {
    HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input);

    Set<DataKey> getRequiredInput();

    Set<DataKey> getOutput();
}