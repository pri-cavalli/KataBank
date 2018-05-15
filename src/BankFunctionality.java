import java.util.*;

public enum BankFunctionality {
    DEPOSIT("Deposit", 1),
    WITHDRAWAL("Withdrawal", 2),
    DETAILS("Get Account Details", 3),
    EXIT("Exit", 4);

    private final Integer id;
    private final String name;

    BankFunctionality(String name, Integer id) {
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

    public static List<BankFunctionality> listAll() {
        return new ArrayList<BankFunctionality>(EnumSet.allOf(BankFunctionality.class));
    }

    public static boolean commandIdIsValid(Integer commandId) {
        return (commandId <= BankFunctionality.listAll().size()) && (commandId >= 1);
    }

    private static final Map<Integer, BankFunctionality> intToTypeMap = new HashMap<Integer, BankFunctionality>();
    static {
        for (BankFunctionality bankFunctionality : BankFunctionality.values()) {
            intToTypeMap.put(bankFunctionality.id, bankFunctionality);
        }
    }

    public static BankFunctionality fromInteger(Integer bankFunctionalityId) {
        BankFunctionality bankFunctionality = intToTypeMap.get(bankFunctionalityId);
        return bankFunctionality;
    }
}