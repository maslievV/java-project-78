package hexlet.code.schemas;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class BaseSchema {
    protected final Map<CheckNames, Predicate<Object>> checks = new TreeMap<>();
    protected boolean required = false;

    protected final void addCheck(CheckNames status, Predicate<Object> pr) {
        checks.put(status, pr);
    }

    public final boolean isValid(Object value) {
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
