package main.java.model.calculator;

//Vegard
//

// Author: Alexander Larnemo Ask, Jonatan Bunis, Vegard Landrö, Mohamad Melhem, Alexander Larsson Vahlberg
// Responsibility: Common interface for all calculators.
// Used by: CalculatorFacade
// Uses: Defines expected behaviour of a calculator. For abstraction and extensibility.

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