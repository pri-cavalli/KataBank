package Bank;

import java.util.*;

public enum BankFunctionalityEnum {
    DEPOSIT("Deposit", 1),
    WITHDRAWAL("Withdrawal", 2),
    DETAILS("Get Bank Account Details", 3),
    EXIT("Exit", 4);

    private final Integer id;
    private final String name;

    BankFunctionalityEnum(String name, Integer id) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id.toString() + " - " + name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}