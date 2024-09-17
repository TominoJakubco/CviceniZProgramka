package org.delta.accounts;

import org.delta.persons.Owner;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private Owner owner;

    public BankAccount(String accountNumber, double balance, Owner owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public String getAccountNumber() {
        return  accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
