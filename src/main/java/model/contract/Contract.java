package main.java.model.contract;

//An electricity provider contract, holding relevant information about that.
public abstract class Contract {

    private String contractProvider;
    private double consumedElectricity;
    private double monthlyCost;
    private double sellbackPriceFraction;

    public Contract(double monthlyCost, double consumedElectricity) {
        this.contractProvider = "Generic Contract Provider";
        this.monthlyCost = monthlyCost;
        this.consumedElectricity = consumedElectricity;
        this.sellbackPriceFraction = 0.3;
    }

    // Getters
    public String getContractProvider() {
        return this.contractProvider;
    }

    public double getSellbackElectrictyPrice() {
        return sellbackPriceFraction * (monthlyCost / consumedElectricity);
    }

    public double getMonthlyCost() {

        return this.monthlyCost;
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


}
