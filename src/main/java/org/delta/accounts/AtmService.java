package org.delta.accounts;

import jakarta.inject.Inject;
import org.delta.accounts.Card.BankCard;
import org.delta.accounts.Card.GlobalCardStorage;

public class AtmService {

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private MoneyTransferService moneyTransferService;

    public BankAccount getCardAccount(BankCard card) {
        BankAccount account = globalCardStorage.BankCards.get(card.getCardNumber());
        return account;
    }

    public void withdrawMoney(BankCard card, String pin, double amount) {
        if(pin == card.getPin()) {
            BankAccount account = card.getBankAccount();
            moneyTransferService.getMoneyFromBankAccount(account, amount);
        }
        else {
            throw new ArithmeticException("Wrong Pin");
        }
    }

    public void insertMoney(BankCard card, String pin, double amount) {
        if(pin == card.getPin()) {
            BankAccount account = card.getBankAccount();
            moneyTransferService.addMoneyToBankAccount(account, amount);
        }
        else {
            throw new ArithmeticException("Wrong Pin");
        }
    }

    public void changePin(BankCard card, String oldPin, String newPin) {
        if(oldPin == card.getPin()) {
            card.setPin(newPin);
        }
        else {
            throw new ArithmeticException("Wrong Pin");
        }
    }
}
