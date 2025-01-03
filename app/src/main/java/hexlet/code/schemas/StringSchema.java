package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends Schema {

    public StringSchema() {
        Predicate<Object> lambda = x -> x != null && !((String) x).isEmpty();
        Schema.addCheck(CheckNames.REQUIRED, lambda);
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        Predicate<Object> lambda = x -> x == null || ((String) x).length() >= minLength;
        Schema.addCheck(CheckNames.MIN_LENGTH, lambda);
        return this;
    }

    public StringSchema contains(String text) {
        Predicate<Object> lambda = x -> x == null || ((String) x).contains(text);
        Schema.addCheck(CheckNames.CONTAINS, lambda);
        return this;
    }
}
