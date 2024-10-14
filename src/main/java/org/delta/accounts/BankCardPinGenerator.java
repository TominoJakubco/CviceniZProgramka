package org.delta.accounts;

import java.util.Random;

public class BankCardPinGenerator {

    public String generateCardPin() {
        Random random = new Random();
        int number = random.nextInt(10000);
        return String.format("%04d", number);
    }
}

