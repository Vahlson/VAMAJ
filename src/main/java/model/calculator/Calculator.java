package main.java.model.calculator;

//Vegard
//Common interface for all calculators in package
import java.util.Set;

public interface Calculator {
    void calculate(CalculatorData input);

    Set<DataKey> getRequiredInput();
}