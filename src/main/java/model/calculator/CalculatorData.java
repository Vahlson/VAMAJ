package main.java.model.calculator;

import java.util.HashMap;
import java.util.Objects;

public class CalculatorData {
    private HashMap<DataKey, Double> data = new HashMap<>();

    public void addValue(DataKey e, Double d) {
        data.put(e, d);
    }

    public Double getValue(DataKey key){
        return Objects.requireNonNull(data.get(key), "no data for " + key.toString());
    }

    HashMap<DataKey, Double> getData() {
        return data;
    }
}