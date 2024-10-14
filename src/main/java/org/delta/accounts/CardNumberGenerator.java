package org.delta.accounts;

import java.util.Random;

public class CardNumberGenerator {
    public String generateCardNumber() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result.append(random.nextInt(10));  // Generates a random number between 0 and 9
            }
            if (i < 3) {
                result.append(" ");  // Adds a space between sets, except after the last one
            }
        }

        return result.toString();

    }
}
