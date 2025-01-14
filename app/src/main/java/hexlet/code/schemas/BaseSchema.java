package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> checks = new TreeMap<>();

    protected final void addCheck(String status, Predicate<T> pr) {
        checks.put(status, pr);
    }
    /**
     * @return BaseSchema with not null check
     */
    public BaseSchema required() {
        Predicate<T> lambda = Objects::nonNull;
        addCheck("required", lambda);
        return this;
    }

    public final boolean isValid(T value) {
        return checks.entrySet().stream()
                .allMatch(l -> l.getValue().test(value));
    }
}
