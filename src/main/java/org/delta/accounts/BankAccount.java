package org.delta.accounts;

import jakarta.inject.Inject;
import org.delta.accounts.Card.BankCard;
import org.delta.persons.Owner;

import java.util.HashMap;
import java.util.Map;



public class BankAccount {
    private String accountNumber;
    private double balance;
    private Owner owner;

    private Map<String, BankCard> bankCardsMap = new HashMap<>();

    public BankAccount(String accountNumber, double balance, Owner owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public void assignBankCard(BankCard bankCard){
        bankCardsMap.put(bankCard.getCardNumber(), bankCard);
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

    public Map<String, BankCard> getBankCardsMap() {
        return bankCardsMap;

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
