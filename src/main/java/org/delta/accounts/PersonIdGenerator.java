package org.delta.accounts;

import java.util.Random;

public class PersonIdGenerator {
    private Random rnd = new Random();

    public String generatePersonIdNumber()
    {
        //return String.valueOf(rnd.nextInt(100, 999));
        return "123";
    }
}
