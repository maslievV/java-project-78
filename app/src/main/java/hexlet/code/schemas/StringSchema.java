package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        Predicate<String> lambda = x -> x == null || x instanceof String;
        addCheck("required", lambda);
    }

    public StringSchema required() {
        Predicate<String> lambda = x -> x != null && !x.isEmpty();
        addCheck("required", lambda);
        return this;
    }

    public StringSchema minLength(int minLength) {
        Predicate<String> lambda = x -> x == null || x.length() >= minLength;
        addCheck("minLength", lambda);
        return this;
    }

    public StringSchema contains(String text) {
        Predicate<String> lambda = x -> x == null || x.contains(text);
        addCheck("contains", lambda);
        return this;
    }
}
