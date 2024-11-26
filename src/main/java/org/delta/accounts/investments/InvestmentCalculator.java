package org.delta.accounts.investments;

import org.delta.accounts.BankAccount;

import java.util.Map;


public class InvestmentCalculator {
    public double CalculateProfit(BankAccount account) {
        double profit = 0;
        Map<Integer, Investment> investments = ((InvestmentBankAccount) account).getInvestments();
        for(int i = 0; i < investments.size(); i++) {
            profit += (investments.get(i).getPercetage() / 100) * account.getBalance() * investments.get(i).getGrowth();
        }
        return profit;
    }

    public void setInvestmentPercentageToHundred(int key, Map<Integer, Investment> investments) {
        double excessPercentage = -100;
        for(int i = 0; i < investments.size(); i++) {
            excessPercentage += investments.get(i).getPercetage();
        }
        if(excessPercentage != 0) {
            excessPercentage /= investments.size();
            for(int i = 0; i < investments.size(); i++) {
                if(investments.get(i) != investments.get(key))
                    investments.get(i).setPercetage(investments.get(i).getPercetage() - excessPercentage);
            }
        }
    }
}
