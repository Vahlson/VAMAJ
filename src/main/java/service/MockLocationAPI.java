package main.java.service;

public class MockLocationAPI {
    private int solarHours = 5;
    private Coordinate coordinate = new Coordinate(10.5,25.3);
    




    private class Coordinate{
        public final Double x;
        public final Double y;

        public Coordinate(Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

}
