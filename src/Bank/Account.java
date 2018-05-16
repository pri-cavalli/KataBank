package Bank;

import Actions.AccountMoneyIO;
import Actions.Deposit;
import Actions.Withdrawal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private BigDecimal money;
    private List<AccountMoneyIO> historic;

    public Account() {
        this.money = BigDecimal.ZERO;
        historic = new ArrayList<AccountMoneyIO>();
    }

    public List<AccountMoneyIO> getHistoric() {
        return historic;
    }

    public void deposit(Deposit deposit) {
        money = money.add(deposit.getAmount());
        historic.add(deposit);
    }

    public boolean withdrawal(Withdrawal withdrawal) {
        BigDecimal restOfMoney = money.subtract(withdrawal.getAmount());

        if(isPossibleToWithdrawal(restOfMoney))
            return false;

        historic.add(withdrawal);
        money = restOfMoney;
        return true;
    }

    private boolean isPossibleToWithdrawal(BigDecimal restOfMoney) {
        return restOfMoney.compareTo(BigDecimal.ZERO) == -1;
    }
}
