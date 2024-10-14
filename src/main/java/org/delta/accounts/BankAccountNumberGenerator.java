package org.delta.accounts;

import java.util.Random;

public class BankAccountNumberGenerator {
    private Random rnd = new Random();

    public String generateBankAccountNumber()
    {
        //return String.valueOf(rnd.nextInt(999));
        return "123";
    }
}
