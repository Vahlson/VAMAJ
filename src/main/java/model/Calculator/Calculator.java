package model.Calculator;

//Vegard
//Common interface for all calculators in package

public interface Calculator<I,O> {
    O calculate(I i);
}
