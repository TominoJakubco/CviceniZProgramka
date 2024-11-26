package org.delta.accounts.investments;

import java.util.Random;

public class Investment {
    private String name;
    private double percetage;
    Random rnd = new Random();

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

    public double getGrowth() {
        //return rnd.nextInt(100);
        return 1;
    }
}
