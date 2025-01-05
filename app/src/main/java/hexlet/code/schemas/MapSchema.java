package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> lambda = m -> m instanceof Map;
        addCheck(CheckNames.REQUIRED, lambda);
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeOf(int limit) {
        Predicate<Object> lambda = m -> ((Map) m).size() == limit;
        addCheck(CheckNames.SIZE_OF, lambda);
        return this;
    }

}
