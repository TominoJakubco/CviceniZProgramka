package org.delta.accounts;

import jakarta.inject.Inject;
import org.delta.persons.Owner;

public class BankAccountFactory {
    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    @Inject
    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public BankAccount createBankAccount(double balance, Owner owner, String accountNumber) {
        return new BankAccount(accountNumber, balance, owner);
    }

    public BankAccount createBankAccount(double balance, Owner owner) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();
        return new BankAccount(accountNumber, balance, owner);
    }
}
