package org.delta.accounts;

public class Investment {
    private String name;
    private double percetage;
    private double growthPercentage;

    public Investment(String name, double percetage) {
        this.name = name;
        this.percetage = percetage;
    }

    public String getName() {
        return name;
    }

    public double getPercetage() {
        return percetage;
    }

    public void setPercetage(double percetage) {
        this.percetage = percetage;
    }

    public void setGrowthPercentage(double growthPercentage) {
        this.growthPercentage = growthPercentage;
    }
}
