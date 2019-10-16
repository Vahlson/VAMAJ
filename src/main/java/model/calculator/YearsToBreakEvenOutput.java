package main.java.model.calculator;

//(3) Vegard
//Class to contain return values of YearToBreakEven calculation

public class YearsToBreakEvenOutput{
    private int years;

    YearsToBreakEvenOutput(int years) {
        this.years = years;
    }

    public int getYears() {
        return years;
    }
}
