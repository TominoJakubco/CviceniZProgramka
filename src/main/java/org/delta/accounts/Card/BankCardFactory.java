package org.delta.accounts.Card;

import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;


public class BankCardFactory {

    @Inject
    private CardNumberGenerator cardNumberGenerator;

    @Inject
    private BankCardPinGenerator bankCardPinGenerator;

    public BankCard CreateCard(String pin, BankAccount bankAccount) {
        return new BankCard(cardNumberGenerator.generateCardNumber(), pin, bankAccount);
    }

    public BankCard CreateCard(BankAccount bankAccount) {
        return new BankCard(cardNumberGenerator.generateCardNumber(), bankCardPinGenerator.generateCardPin(), bankAccount);
    }
}
