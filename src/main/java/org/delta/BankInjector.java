package org.delta;

import com.google.inject.AbstractModule;
import org.delta.accounts.AccountNumberGenerator;
import org.delta.accounts.SlovakiaBankAccountNumberGenerator;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
    }
}
