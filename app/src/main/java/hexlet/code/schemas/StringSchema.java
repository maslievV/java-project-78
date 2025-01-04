package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        Predicate<Object> lambda = x -> x instanceof String && !((String) x).isEmpty();
        addCheck(CheckNames.REQUIRED, lambda);
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        Predicate<Object> lambda = x -> x == null || ((String) x).length() >= minLength;
        addCheck(CheckNames.MIN_LENGTH, lambda);
        return this;
    }

    public StringSchema contains(String text) {
        Predicate<Object> lambda = x -> x == null || ((String) x).contains(text);
        addCheck(CheckNames.CONTAINS, lambda);
        return this;
    }
}
