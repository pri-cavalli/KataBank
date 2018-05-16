package Actions;

import Bank.Account;
import Bank.BankFunctionalityEnum;

import java.math.BigDecimal;

public class Deposit extends AccountMoneyIO {

    public Deposit(BigDecimal amount) {
        super(amount);
        bankFunctionalityEnum = BankFunctionalityEnum.DEPOSIT;
    }

    @Override
    public boolean execute(Account account) {
        account.deposit(this);
        return true;
    }

    @Override
    public String toString() {
        return "Deposit accomplished of R$" + amount + ".";
    }
}
