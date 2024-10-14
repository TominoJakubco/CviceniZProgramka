package org.delta;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.delta.accounts.*;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonIDValidator;
import org.delta.persons.PersonJsonSerializationService;

import javax.management.ObjectName;
import java.text.MessageFormat;

public class App {
    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    @Inject
    private PersonJsonSerializationService personJsonSerializationService;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void run() {
        Calc calc = new Calculator();
        testBank();
    }

    private void testBank() {
        Owner owner = this.ownerFactory.createOwner("Jan", "Navrátil");
        BankAccount bankAccount = this.bankAccountFactory.createBankAccount(500, owner, "123");

        Owner owner1 = this.ownerFactory.createOwner("Honza", "Šulc");
        BankAccount bankAccount1 = this.bankAccountFactory.createBankAccount(500, owner1, accountNumberGenerator.generateBankAccountNumber());

        System.out.println("owner: " + owner.getFullName() );
        System.out.println("account: " + bankAccount.getAccountNumber() + ", balance: " + bankAccount.getBalance());
        System.out.print(this.personJsonSerializationService.serializerOwner(owner));

        moneyTransferService.addMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.addMoneyToBankAccount(bankAccount, 1000);
        moneyTransferService.getMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, 100);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, -100);



    }
}
