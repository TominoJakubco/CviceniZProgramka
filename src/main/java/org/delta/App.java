package org.delta;
import org.delta.accounts.*;
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
        DIContainer diContainer = new DIContainer();

        Owner owner = diContainer.getOwnerFactory().createOwner("Jan", "Navrátil", diContainer.getPersonIdGenerator());
        BankAccount bankAccount = diContainer.getBankAccountFactory().createBankAccount(500, owner, "123");

        Owner owner1 = diContainer.getOwnerFactory().createOwner("Honza", "Šulc", diContainer.getPersonIdGenerator());
        BankAccount bankAccount1 = diContainer.getBankAccountFactory().createBankAccount(500, owner1, diContainer.getBankAccountNumberGenerator());

        System.out.println("owner: " + owner.getFullName() );
        System.out.println("account: " + bankAccount.getAccountNumber() + ", balance: " + bankAccount.getBalance());
        System.out.print(diContainer.getPersonJsonSerializationService().serializerOwner(owner));

        MoneyTransferService moneyTransferService = diContainer.getMoneyTransferService();
        moneyTransferService.addMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.addMoneyToBankAccount(bankAccount, 1000);
        moneyTransferService.getMoneyToBankAccount(bankAccount, 500);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, 100);
        moneyTransferService.sendMoneyToBankAccount(bankAccount1, bankAccount, -100);



    }
}
