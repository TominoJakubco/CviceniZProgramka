package org.delta.accounts;

import jakarta.inject.Inject;
import org.delta.persons.Owner;

public class SavingBankAccount extends BankAccount{

    @Inject
    private InterestingService interestingService;

    public SavingBankAccount(String accountNumber, double balance, Owner owner) {
        super(accountNumber, balance, owner);

    }
}