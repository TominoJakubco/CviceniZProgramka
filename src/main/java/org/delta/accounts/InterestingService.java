package org.delta.accounts;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class InterestingService {

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private InterestingCalculator interestingCalculator;

    private double SavingAccountInterest = 4.2;

    public void addInterestToAccounts() {
        for(BankAccount acc: globalBankAccountStorage.bankAccounts) {
            if (acc instanceof SavingBankAccount) {
                double interest = interestingCalculator.CalculateIterest(acc.getBalance(), SavingAccountInterest);
                moneyTransferService.addInterestMoneyToBankAccount(acc, interest);
            }
        }
    }
}
