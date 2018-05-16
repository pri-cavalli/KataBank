package Bank;

import java.util.*;

public final class BankFunctionalityMapper {
    private static BankFunctionalityMapper INSTANCE;
    private static final Map<Integer, BankFunctionalityEnum> bankFunctionalityMap = new HashMap<Integer, BankFunctionalityEnum>();

    private BankFunctionalityMapper() {
        for (BankFunctionalityEnum bankFunctionalityEnum : BankFunctionalityEnum.values()) {
            bankFunctionalityMap.put(bankFunctionalityEnum.getId(), bankFunctionalityEnum);
        }
    }

    public static BankFunctionalityMapper getInstance() {
        if (INSTANCE == null )
            INSTANCE = new BankFunctionalityMapper();
        return INSTANCE;
    }

    public static List<BankFunctionalityEnum> listAll() {
        return new ArrayList<BankFunctionalityEnum>(bankFunctionalityMap.values());
    }

    public static boolean commandIdIsValid(Integer commandId) {
        return bankFunctionalityMap.containsKey(commandId);
    }

    public static BankFunctionalityEnum getBankFunctionalityEnumById(Integer commandId) {
        BankFunctionalityEnum bankFunctionalityEnum = bankFunctionalityMap.get(commandId);
        return bankFunctionalityMap.get(commandId);
    }
}
