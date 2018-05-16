package Actions;

import Bank.Account;
import Bank.BankFunctionalityEnum;

import java.math.BigDecimal;

public abstract class AccountMoneyIO {
    protected BigDecimal amount;
    protected BankFunctionalityEnum bankFunctionalityEnum;

    public AccountMoneyIO(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isAmountValid() {
        return amount.compareTo(BigDecimal.ZERO) != -1;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BankFunctionalityEnum getBankFunctionalityEnum() {
        return bankFunctionalityEnum;
    }

    public abstract boolean execute(Account account);

    public abstract String toString();
}
