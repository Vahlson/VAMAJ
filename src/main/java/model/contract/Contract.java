package main.java.model.contract;

public abstract class Contract {
    private String contractProvider;
    private String contractCity;
    private double contractDuration;
    private int cost;

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
    public void setCost(int cost){
        this.cost = cost;
    }

    public void setContractProvider(String contractProvider) {
        this.contractProvider = contractProvider;
    }

    public void setContractCity(String contractCity) {
        this.contractCity = contractCity;
    }

    public void setContractDuration(double contractDuration) {
        this.contractDuration = contractDuration;
    }
}
