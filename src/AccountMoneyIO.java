import java.math.BigDecimal;

public abstract class AccountMoneyIO {
    protected BigDecimal amount;

    public AccountMoneyIO() {
    }

    public AccountMoneyIO(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isAmountValid() {
        return amount.compareTo(BigDecimal.ZERO) != -1;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public abstract boolean execute(Account account);

    public abstract String toString();
}
