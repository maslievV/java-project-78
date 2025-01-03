package hexlet.code.schemas;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class Schema {
    protected static Map<CheckNames, Predicate<Object>> checks = new TreeMap<>();
    protected boolean required = false;

    protected static void addCheck(CheckNames status, Predicate<Object> pr) {
        checks.put(status, pr);
    }

    public boolean isValid(Object value) {
        if (!required) {
            Predicate<Object> validate = checks.get(CheckNames.REQUIRED);
            if (!validate.test(value)) {
                return true;
            }
        }
        for (var lambda: checks.values()) {
            if (!lambda.test(value)) {
                return false;
            }
        }
        return true;
    }
}
