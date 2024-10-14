package org.delta.accounts;

import jakarta.inject.Singleton;

import java.util.Random;

@Singleton
public class PersonIdGenerator {
    private Random rnd = new Random();

    public String generatePersonIdNumber()
    {
        //return String.valueOf(rnd.nextInt(100, 999));
        return "123";
    }
}
