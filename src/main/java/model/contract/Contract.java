package main.java.model.contract;

//An electricity provider contract, holding relevant information about that.
public abstract class Contract {

    private String contractProvider;
    private double contractDuration;
    private double consumedElectricity;
    private double monthlyCost;

    public Contract(int monthlyCost, double contractDuration) {
        this.contractProvider = "Generic Contract Provider";

        this.monthlyCost = monthlyCost;
        this.contractDuration = contractDuration;
    }

    // Getters
    public String getContractProvider() {
        return this.contractProvider;
    }


    public double getMonthlyCost() {

        return this.monthlyCost;
    }

    public double getContractDuration() {
        return this.contractDuration;
    }

    public double getConsumedElectricity() {
        return consumedElectricity;
    }

    // Setters
    public void setConsumedElectricity(double consumedElectricity) {
        this.consumedElectricity = consumedElectricity;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public void setContractProvider(String contractProvider) {
        this.contractProvider = contractProvider;
    }


    public void setContractDuration(double contractDuration) {
        this.contractDuration = contractDuration;
    }
}
