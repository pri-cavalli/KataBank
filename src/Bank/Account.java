package Bank;

import Actions.AccountMoneyIO;
import Actions.Deposit;
import Actions.Withdrawal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private BigDecimal balance;
    private List<AccountMoneyIO> historic;

    public Account() {
        this.balance = BigDecimal.ZERO;
        historic = new ArrayList<AccountMoneyIO>();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<AccountMoneyIO> getHistoric() {
        return historic;
    }

    public void deposit(Deposit deposit) {
        balance = balance.add(deposit.getAmount());
        historic.add(deposit);
    }

    public boolean withdrawal(Withdrawal withdrawal) {
        BigDecimal restOfMoney = balance.subtract(withdrawal.getAmount());

        if(isPossibleToWithdrawal(restOfMoney))
            return false;

        historic.add(withdrawal);
        balance = restOfMoney;
        return true;
    }

    private boolean isPossibleToWithdrawal(BigDecimal restOfMoney) {
        return restOfMoney.compareTo(BigDecimal.ZERO) == -1;
    }
}
