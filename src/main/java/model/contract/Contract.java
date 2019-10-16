package main.java.model.contract;

public abstract class Contract {
    final private String contractProvider;
    final private String contractCity;
    final private double contractDuration;
    final private int cost;

    public Contract(String contractProvider, String contractCity, int cost, double contractDuration) {
        this.contractProvider = contractProvider;
        this.contractCity = contractCity;
        this.cost = cost;
        this.contractDuration = contractDuration;
    }

    // Getters
    public String getContractProvider() {
        return this.contractProvider;
    }

    public String getContractCity() {
        return this.contractCity;
    }

    public int getCost() {

        return this.cost;
    }

    public double getContractDuration() {
        return this.contractDuration;
    }

    // Setter
    // TODO: mutate-by-copy setters for all
    public abstract Contract setCost(int cost);
}
