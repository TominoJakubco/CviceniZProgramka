package org.delta.accounts.saving;

import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.persons.Owner;

public class SavingBankAccount extends BankAccount {

    @Inject
    private InterestingService interestingService;

    public SavingBankAccount(String accountNumber, double balance, Owner owner) {
        super(accountNumber, balance, owner);

    }
}