package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema{

    public NumberSchema() {
        Predicate<Object> lambda = n -> n instanceof Integer;
        addCheck(CheckNames.REQUIRED, lambda);
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> lambda = n -> ((int) n) > 0;
        addCheck(CheckNames.POSITIVE, lambda);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Object> lambda = n -> ((int) n) >= begin && ((int) n) <= end;
        addCheck(CheckNames.IN_RANGE, lambda);
        return this;
    }
}
