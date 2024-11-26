package org.delta.print;

import org.delta.accounts.BankAccount;
import org.delta.accounts.saving.SavingBankAccount;
import org.delta.accounts.StudentBankAccount;

public class AccountDetailPrinter implements DetailPrinter {

    public void printDetail(BankAccount account) {
        System.out.println(this.getPrefix(account) + " Bank account balance: " + account.getBalance());
    }

    public void printDetail(BankAccount account, double fee) {
        System.out.println(this.getPrefix(account) + " Bank account balance: " + account.getBalance() + ", fee " + fee);
    }

    private String getPrefix(BankAccount account) {
        if (account instanceof StudentBankAccount) {
            return "Student ";
        }

        if (account instanceof SavingBankAccount) {
            return "Saving ";
        }

        return "";
    }
}