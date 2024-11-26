package org.delta.accounts.Card;

import org.delta.accounts.BankAccount;

public class BankCard {
    private String cardNumber;
    private String pin;
    private transient BankAccount bankAccount;

    public BankCard(String cardNumber, String pin, BankAccount bankAccount) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
