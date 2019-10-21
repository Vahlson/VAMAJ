package main.java.model.calculator;

//Vegard
//Common interface for all calculators in package

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

interface Calculator {

    //Runs the calculations in a given calculator a copy of the input with the result added
    HashMap<DataKey, Double> calculate(HashMap<DataKey, Double> input);

    //Returns a set of Datakeys that represents the data that is required to run the calculator
    Set<DataKey> getKeysOfRequiredInput();

    //Returns Datakays representing the output after the calculation is run
    Set<DataKey> getKeysOfOutput();
}