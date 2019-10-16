package main.java.model.contract;

public abstract class Contract {
    private String contractProvider;
    private String contractCity;
    private double contractDuration;
    private int cost;


    public Contract() {

    }

    public Contract(String contractProvider, String contractCity, int cost, double contractDuration) {
        this.contractProvider = contractProvider;
        this.contractCity = contractCity;
        this.cost = cost;
        this.contractDuration = contractDuration;
    }

    public String getContractProvider() {
        return this.contractProvider;
    }


    public String getContractCity() {
        return this.contractCity;
    }

    public int getCost() {

        return this.cost;
    }

    public abstract Contract setCost(int cost);


    public double getContractDuration() {
        return this.contractDuration;
    }


}
