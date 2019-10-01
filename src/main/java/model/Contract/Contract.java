package main.java.model.Contract;

public class Contract {

    private String contractProvider;
    private String contractCity;
    private double tariff;
    private double contractDuration;



    public Contract(String contractProvider, String contractCity, double tariff, double contractDuration) {
        this.contractProvider = contractProvider;
        this.contractCity = contractCity;
        this.tariff = tariff;
        this.contractDuration= contractDuration;
    }

    public String getContractProvider() {
        return contractProvider;
    }

    public void setContractProvider(String contractProvider) {
        this.contractProvider = contractProvider;
    }

    public String getContractCity() {
        return contractCity;
    }

    public void setContractCity(String contractCity) {
        this.contractCity = contractCity;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }
    public double getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(double contractDuration) {
        this.contractDuration = contractDuration;
    }
}
