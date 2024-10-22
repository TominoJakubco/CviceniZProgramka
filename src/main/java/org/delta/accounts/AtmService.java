package org.delta.accounts;

import jakarta.inject.Inject;

public class AtmService {

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private MoneyTransferService moneyTransferService;

    public BankAccount getCardAccount(BankCard card) {
        BankAccount account = globalCardStorage.BankCards.get(card.getCardNumber());
        return account;
    }

    public void withdrawMoney(BankCard card, double amount) {
        BankAccount account = getCardAccount(card);
        moneyTransferService.getMoneyFromBankAccount(account, amount);
    }

    public void insertMoney(BankCard card, double amount) {
        BankAccount account = getCardAccount(card);
        moneyTransferService.addMoneyToBankAccount(account, amount);
    }

    public void changePin(BankCard card, String pin) {
        card.setPin(pin);
    }
}
