package org.delta.accounts;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;


public class BankAccountFacade {
    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private BankCardFactory bankCardFactory;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public BankAccount createBankAccount(double balance, Owner owner, boolean withCard, String bankAccountNumber) {
        BankAccount account = this.bankAccountFactory.createBankAccount(balance, owner, bankAccountNumber);
        if(withCard)
        {
            BankCard bankCard = bankCardFactory.CreateCard();
            account.assignBankCard(bankCard);
            globalCardStorage.BankCards.put(bankCard.getCardNumber(), account);
        }
        globalBankAccountStorage.bankAccounts.add(account);

        return account;
    }

    public BankAccount createBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount account = this.bankAccountFactory.createBankAccount(balance, owner, bankAccountNumberGenerator.generateBankAccountNumber());
        if(withCard)
        {
            BankCard bankCard = bankCardFactory.CreateCard();
            account.assignBankCard(bankCard);
            globalCardStorage.BankCards.put(bankCard.getCardNumber(), account);
        }
        globalBankAccountStorage.bankAccounts.add(account);

        return account;
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount account = this.bankAccountFactory.createBankAccount(balance, owner);
        if(withCard)
        {
            BankCard bankCard = bankCardFactory.CreateCard();
            account.assignBankCard(bankCard);
            globalCardStorage.BankCards.put(bankCard.getCardNumber(), account);
        }
        globalBankAccountStorage.bankAccounts.add(account);

        return account;
    }

    public void addBankCard(BankAccount account) {
        BankCard card = bankCardFactory.CreateCard();
        account.assignBankCard(card);
        globalCardStorage.BankCards.put(card.getCardNumber(), account);
    }
}
