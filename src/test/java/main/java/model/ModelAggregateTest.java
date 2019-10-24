package main.java.model;

import main.java.model.calculator.DataKey;
import main.java.model.property.ConsumingProperty;
import main.java.model.property.NonConsumingProperty;
import main.java.model.property.Property;
import main.java.model.user.User;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ModelAggregateTest {
    ModelAggregate aggregate;
    User user;
    HashMap <DataKey, Double> calculationData;


    @Test
    public void setPropertyConsumingTest() {
        aggregate = new ModelAggregate();
        user = new User();
        Property newProperty = new ConsumingProperty();
        Property oldProperty = aggregate.getProperty();
        newProperty.setLocation(oldProperty.getLocation());
        newProperty.setContract(oldProperty.getContract());
        newProperty.setSolarSetup(oldProperty.getSolarSetup());

        user.setProperty(newProperty);
        assertEquals(oldProperty.getLocation(), newProperty.getLocation());
        assertEquals(oldProperty.getContract(), newProperty.getContract());
        assertEquals(oldProperty.getSolarSetup(), newProperty.getSolarSetup());
        assertEquals(user.getActiveProperty(), newProperty);


    }

    @Test
    public void setPropertyNonConsumingTest() {
        aggregate = new ModelAggregate();
        user = new User();
        Property newProperty = new NonConsumingProperty();
        Property oldProperty = aggregate.getProperty();
        newProperty.setLocation(oldProperty.getLocation());
        newProperty.setContract(oldProperty.getContract());
        newProperty.setSolarSetup(oldProperty.getSolarSetup());


        user.setProperty(newProperty);
        assertEquals(oldProperty.getLocation(), newProperty.getLocation());
        assertEquals(oldProperty.getContract(), newProperty.getContract());
        assertEquals(oldProperty.getSolarSetup(), newProperty.getSolarSetup());

        assertEquals(user.getActiveProperty(), newProperty);


    }

   /* @Test
    public void runAllCalculatorsTest() {
        aggregate = new ModelAggregate();
        calculationData= aggregate.get



    }

    */
}