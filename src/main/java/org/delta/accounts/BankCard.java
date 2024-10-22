package org.delta.accounts;

public class BankCard {
    private String cardNumber;
    private String pin;

    public BankCard(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
