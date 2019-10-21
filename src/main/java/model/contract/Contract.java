package main.java.model.contract;

//An electricity provider contract, holding relevant information about that.
public abstract class Contract {
    private String contractProvider;
    private String contractCity;
    private double contractDuration;
    private int cost;

    public Contract(String contractCity, int cost, double contractDuration) {
        this.contractProvider = "Generic Contract Provider";
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
