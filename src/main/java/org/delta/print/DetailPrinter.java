
package org.delta.print;

import org.delta.accounts.BankAccount;

public interface DetailPrinter {
    public void printDetail(BankAccount account);

    public void printDetail(BankAccount account, double fee);
}
