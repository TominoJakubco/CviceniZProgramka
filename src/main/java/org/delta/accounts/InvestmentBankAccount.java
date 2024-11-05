package org.delta.accounts;
import jakarta.inject.Inject;
import org.delta.persons.Owner;

import java.util.*;

public class InvestmentBankAccount extends BankAccount{

    @Inject
    private InvestmentCalculator investmentCalculator;

    private Map<Integer, Investment> investments = new HashMap<>();

    public InvestmentBankAccount(String accountNumber, double balance, Owner owner) {
        super(accountNumber, balance, owner);
        this.investments = investments;
    }

    public Map<Integer, Investment> getInvestments() {
        return investments;
    }


}
