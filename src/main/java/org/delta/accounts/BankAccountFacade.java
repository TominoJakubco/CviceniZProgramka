package org.delta.accounts;

import jakarta.inject.Inject;
import org.delta.accounts.Card.BankCard;
import org.delta.accounts.Card.BankCardFactory;
import org.delta.accounts.Card.GlobalCardStorage;
import org.delta.persons.Owner;


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

    @Inject
    private InterestingService interestingService;

    public BankAccount createBankAccount(double balance, Owner owner, boolean withCard, String bankAccountNumber) {
        BankAccount account = this.bankAccountFactory.createBankAccount(balance, owner, bankAccountNumber);
        if(withCard)
        {
            BankCard bankCard = bankCardFactory.CreateCard(account);
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
            BankCard bankCard = bankCardFactory.CreateCard(account);
            account.assignBankCard(bankCard);
            globalCardStorage.BankCards.put(bankCard.getCardNumber(), account);
        }
        globalBankAccountStorage.bankAccounts.add(account);

        return account;
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount account = this.bankAccountFactory.createStudentBankAccount(balance, owner);
        if(withCard)
        {
            BankCard bankCard = bankCardFactory.CreateCard(account);
            account.assignBankCard(bankCard);
            globalCardStorage.BankCards.put(bankCard.getCardNumber(), account);
        }
        globalBankAccountStorage.bankAccounts.add(account);

        return account;
    }

    public BankAccount createSavingBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount account = this.bankAccountFactory.createSavingBankAccount(balance, owner);
        if(withCard)
        {
            BankCard bankCard = bankCardFactory.CreateCard(account);
            account.assignBankCard(bankCard);
            globalCardStorage.BankCards.put(bankCard.getCardNumber(), account);
        }
        globalBankAccountStorage.bankAccounts.add(account);

        return account;
    }

    public BankCard addBankCard(BankAccount account) {
        BankCard card = bankCardFactory.CreateCard(account);
        account.assignBankCard(card);
        globalCardStorage.BankCards.put(card.getCardNumber(), account);

        return card;
    }
}
