package Actions;

import Bank.Account;
import Bank.BankFunctionalityEnum;

import java.math.BigDecimal;

public class Withdrawal extends AccountMoneyIO {
    public Withdrawal(BigDecimal amount) {
        super(amount);
        bankFunctionalityEnum = BankFunctionalityEnum.WITHDRAWAL;
    }

    @Override
    public boolean execute(Account account) {
        return account.withdrawal(this);
    }

    @Override
    public String toString() {
        return "Withdrawal accomplished of R$" + amount + ".";
    }
}
