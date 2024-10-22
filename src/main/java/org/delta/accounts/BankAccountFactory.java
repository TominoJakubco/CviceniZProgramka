package org.delta.accounts;

import jakarta.inject.Inject;
import org.delta.persons.Owner;

public class BankAccountFactory {

    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    @Inject
    private BankAccountNumberGenerator bankAccountNumberGenerator;

    @Inject
    private SlovakiaBankAccountNumberGenerator slovakiaBankAccountNumberGenerator;

    public BankAccount createBankAccount(double balance, Owner owner, String accountNumber) {
        return new BankAccount(accountNumber, balance, owner);
    }

    public BankAccount createBankAccount(double balance, Owner owner) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();
        return new BankAccount(accountNumber, balance, owner);
    }

    public BankAccount createSlovakianBankAccount(double balance, Owner owner) {
        String accountNumber = slovakiaBankAccountNumberGenerator.generateBankAccountNumber();
        return new BankAccount(accountNumber, balance, owner);
    }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();
        return new StudentBankAccount(accountNumber, balance, owner);
    }

    public SavingBankAccount createSavingBankAccount(double balance, Owner owner) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();
        return new SavingBankAccount(accountNumber, balance, owner);
    }
}
