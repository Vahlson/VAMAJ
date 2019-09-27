package main.java.model.Calculator;

import main.java.model.Property.Property;

public interface Callable<V, Property> {
    V call(Property p) throws Exception;
}
