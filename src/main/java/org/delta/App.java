package org.delta;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFactory;
import org.delta.accounts.MoneyTransferService;
import org.delta.accounts.PersonIDValidator;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;

import javax.management.ObjectName;
import java.text.MessageFormat;

public class App {
    public void run() {
        Calc calc = new Calculator();

//        System.out.println(calc.add(1, 2));
//        System.out.println(calc.sub(2, 1));
//        System.out.println(calc.mul(2, 3));
//        System.out.println(calc.div(4,2));
//        System.out.println(calc.div(4,0));
        testBank();
    }

    private void testBank() {
        PersonIDValidator personIDValidator = new PersonIDValidator();
        OwnerFactory ownerFactory = new OwnerFactory(personIDValidator);
        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        Owner owner = ownerFactory.createOwner("Jan", "Navrátil");
        BankAccount bankAccount = bankAccountFactory.createBankAccount(500, owner, "123");

        Owner owner1 = new Owner("Honza", "Šulc");
        BankAccount bankAccount1 = new BankAccount("234", 500, owner1);

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        System.out.println("owner: " + owner.getFullName() );
        System.out.println("account: " + bankAccount.getAccountNumber() + ", balance: " + bankAccount.getBalance());

        moneyTransferService.addMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.addMoneyToBankAccount(bankAccount, 1000);
        moneyTransferService.getMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, 100);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, -100);



    }
}
