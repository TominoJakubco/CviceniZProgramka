package org.delta.accounts;

import jakarta.inject.Inject;


public class BankCardFactory {

    @Inject
    private CardNumberGenerator cardNumberGenerator;

    @Inject
    private BankCardPinGenerator bankCardPinGenerator;

    public BankCard CreateCard(String pin) {
        return new BankCard(cardNumberGenerator.generateCardNumber(), pin);
    }

    public BankCard CreateCard() {
        return new BankCard(cardNumberGenerator.generateCardNumber(), bankCardPinGenerator.generateCardPin());
    }
}
