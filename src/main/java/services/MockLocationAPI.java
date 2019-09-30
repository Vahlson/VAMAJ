package main.java.services;

//(3.1) Alex LV
//Mockup API to test services functionality.
public class MockLocationAPI {
    private int solarHours = 5;
    private Coordinates coordinate = new Coordinates(10.5,25.3);
    private double solarPower = 1000.75;


    public int getSolarHours() {
        return solarHours;
    }


    public Double getX() {
        return coordinate.getX();
    }

    public Double getY() {
        return coordinate.getY();
    }


    public double getSolarPower() {
        return solarPower;
    }

    // Made this dissimilar to coordinate in our model to try our adapter class.
    private class Coordinates{
        private final Double x;
        private final Double y;

        public Coordinates(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

         Double getX() {
            return x;
        }

        Double getY() {
            return y;
        }
    }
}
