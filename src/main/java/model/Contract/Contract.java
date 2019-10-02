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


    public String getContractCity() {
        return contractCity;
    }



    public double getTariff() {
        return tariff;
    }


    public double getContractDuration() {
        return contractDuration;
    }


}
