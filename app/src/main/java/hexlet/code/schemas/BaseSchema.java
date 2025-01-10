package hexlet.code.schemas;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<Object>> checks = new TreeMap<>();

    protected final void addCheck(String status, Predicate pr) {
        checks.put(status, pr);
    }

    public final boolean isValid(Object value) {

        return checks.entrySet().stream()
                .allMatch(l -> l.getValue().test(value));
    }
}
