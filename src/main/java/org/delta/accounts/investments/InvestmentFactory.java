package org.delta.accounts.investments;

public class InvestmentFactory {
    public Investment createInvestment(String name, double percetage) {
        Investment investment = new Investment(name, percetage);
        return investment;
    }
}
