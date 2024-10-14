package org.delta.accounts;

import org.delta.persons.Owner;

public class StudentBankAccount extends BankAccount {

    private String studentStudiesConfirmationExpire;

    public StudentBankAccount(String accountNumber, double balance, Owner owner) {
        super(accountNumber, balance, owner);

        this.studentStudiesConfirmationExpire = null;
    }

    public StudentBankAccount(String accountNumber,double balance, Owner owner, String studentStudiesConfirmationExpire) {
        super(accountNumber,balance, owner);

        this.studentStudiesConfirmationExpire = studentStudiesConfirmationExpire;
    }

    public String getStudentStudiesConfirmationExpire() {
        return studentStudiesConfirmationExpire;
    }
}
