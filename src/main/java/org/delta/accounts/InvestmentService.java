package org.delta.accounts;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.accounts.*;

import java.util.Map;

@Singleton
public class InvestmentService {
    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private InvestmentCalculator investmentCalculator;

    public void addInvestmentProfitToBankAccounts() {
        for(BankAccount acc: globalBankAccountStorage.bankAccounts) {
            if (acc instanceof InvestmentBankAccount) {
                double profit = investmentCalculator.CalculateProfit(acc);
                moneyTransferService.addInvestmentMoneyToBankAccount(acc, profit);
            }
        }
    }

    public void addInvestmentToAccount(BankAccount account, int key, Investment investment) {
        ((InvestmentBankAccount) account).getInvestments().put(key, investment);
        setInvestmentPercentageToHundred(account, key);
    }

    public void changeInvestmentPercentage(BankAccount account, int key, double percentage) {
        ((InvestmentBankAccount) account).getInvestments().get(key).setPercetage(percentage);
        setInvestmentPercentageToHundred(account,key);
    }

    private void setInvestmentPercentageToHundred(BankAccount account, int key) {
        double excessPercentage = -100;
        for(int i = 0; i < ((InvestmentBankAccount) account).getInvestments().size(); i++) {
            excessPercentage += ((InvestmentBankAccount) account).getInvestments().get(i).getPercetage();
        }
        if(excessPercentage != 0) {
            excessPercentage /= ((InvestmentBankAccount) account).getInvestments().size();
            for(int i = 0; i < ((InvestmentBankAccount) account).getInvestments().size(); i++) {
                if(((InvestmentBankAccount) account).getInvestments().get(i) != ((InvestmentBankAccount) account).getInvestments().get(key))
                    ((InvestmentBankAccount) account).getInvestments().get(i).setPercetage(((InvestmentBankAccount) account).getInvestments().get(i).getPercetage() - excessPercentage);
            }
        }
    }
}
