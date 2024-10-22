package org.delta.accounts;

public class InterestingCalculator {
    public double CalculateIterest(double balance, double interestRate) {
        double annualInterestRate = interestRate / 100;
        double dailyInterestRate = annualInterestRate / 365;
        int daysInMonth = 30;
        double interest = balance * dailyInterestRate * daysInMonth;

        return interest;
    }
}
