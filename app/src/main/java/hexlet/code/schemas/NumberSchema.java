package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema positive() {
        Predicate<Integer> lambda = n -> n == null || n > 0;
        addCheck("positive", lambda);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        Predicate<Integer> lambda = n -> (n == null) || n >= begin && n <= end;
        addCheck("inRange", lambda);
        return this;
    }
}
