package main.java.model.Calculator;

public interface Calculator<I,O> {
    O calculate(I i);
}
